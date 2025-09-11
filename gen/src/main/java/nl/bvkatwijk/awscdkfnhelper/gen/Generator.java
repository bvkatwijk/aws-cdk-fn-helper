package nl.bvkatwijk.awscdkfnhelper.gen;

import io.vavr.Function1;
import io.vavr.collection.List;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public record Generator() {
    private static final String IND = "\t";

    public static void main(String[] args) {
        new Generator().run();
    }

    @SneakyThrows
    private void run() {
        var path = Path.of(this.getClass().getResource("Fn.java").toURI());
        var file = Files.readString(path);
        var methods = extractMethods(file);

        writeInterface(methods);
        writeDelegator(methods);
        writeLocalTest(methods);
    }

    @SneakyThrows
    private void writeLocalTest(List<Method> methods) {
        var writer = new FileWriter("./lib/src/test/java/nl/bvkatwijk/awscdkfnhelper/FnLocalGenTest.java");
        writer.write(List.of(
            "package nl.bvkatwijk.awscdkfnhelper;",
            "",
            "import org.junit.jupiter.api.Nested;",
            "import org.junit.jupiter.api.Test;",
            "",
            "import java.util.List;",
            "",
            "import static org.junit.jupiter.api.Assertions.assertEquals;",
            "",
            "public class FnLocalGenTest {",
            indent("public final FnLocal fn = new FnLocal();"),
            "",
            allTests(methods),
            "}"
        ).mkString("", "\n", "\n"));
        writer.close();
    }

    private static String allTests(List<Method> methods) {
        return methods
            .flatMap(Method::test)
            .map(Generator::indent)
            .mkString("\n");
    }

    @SneakyThrows
    private void writeDelegator(List<Method> methods) {
        var writer = new FileWriter("./lib/src/main/java/nl/bvkatwijk/awscdkfnhelper/FnDelegate.java");
        writer.write(List.of(
            "package nl.bvkatwijk.awscdkfnhelper;",
            "",
            "public class FnDelegate {",
            methods.flatMap(Method::delegation).map(Generator::indent).mkString("\n"),
            "}"
        ).mkString("", "\n", "\n"));
        writer.close();
    }

    @SneakyThrows
    private void writeInterface(List<Method> methods) {
        var writer = new FileWriter("./lib/src/main/java/nl/bvkatwijk/awscdkfnhelper/IFn.java");
        writer.write(List.of(
            "package nl.bvkatwijk.awscdkfnhelper;",
            "",
            "public interface IFn {",
            methods.flatMap(Method::interfaceDeclaration).map(Generator::indent).mkString("\n"),
            "}"
        ).mkString("", "\n", "\n"));
        writer.close();
    }

    private List<Method> extractMethods(String file) {
        return List.of(file.split("(\\r?\\n){2,}"))
            .filter(it -> it.contains("public static "))
            .map(it -> new MethodSource(List.of(it.split("(\\r?\\n)")).map(String::trim)))
            .map(MethodSource::toMethod)
            .toList();
    }

    public record MethodSource(List<String> source) {
        public Method toMethod() {
            return new Method(
                meta(source),
                name(source),
                returnType(source),
                parameters(source)
            );
        }

        public record Parameter(String type, String name) {
            public String declaration() {
                return type + " " + name;
            }
        }

        private List<Parameter> parameters(List<String> source) {
            return Function1.<List<String>>identity()
                .andThen(this::declaration)
                .andThen(it -> StringUtils.substringBetween(it, "(", ")"))
                .andThen(it -> it.split(", (?![^<]*>)"))
                .andThen(List::of)
                .andThen(it -> it.map(String::trim))
                .andThen(it -> it.filter(StringUtils::isNotBlank))
                .andThen(it -> it.map(param -> {
                    var type = StringUtils.substringBeforeLast(param, " ").trim();
                    var name = StringUtils.substringAfterLast(param, " ").trim();
                    return new Parameter(type, name);
                }))
                .apply(source);
        }

        private String returnType(List<String> source) {
            return Function1.<List<String>>identity()
                .andThen(this::declaration)
                .andThen(it -> StringUtils.substringBefore(it, "("))
                .andThen(it -> StringUtils.substringBeforeLast(it, " "))
                .andThen(it -> StringUtils.substringAfterLast(it, " "))
                .apply(source);
        }

        private List<String> meta(List<String> source) {
            return source.takeUntil(it -> it.startsWith("public static"));
        }

        private String name(List<String> source) {
            return Function1.<List<String>>identity()
                .andThen(this::declaration)
                .andThen(it -> StringUtils.substringBefore(it, "("))
                .andThen(it -> StringUtils.substringAfterLast(it, " "))
                .apply(source);
        }

        private String declaration(List<String> source) {
            return source
                .find(it -> it.startsWith("public static"))
                .getOrElseThrow(() -> new IllegalArgumentException("No public static in " + source));
        }
    }

    public record Method(
        List<String> meta,
        String name,
        String returnType,
        List<MethodSource.Parameter> parameters) {

        public List<String> interfaceDeclaration() {
            return meta
                .append(returnType + " " + name + "(" + paramDeclarations(parameters) + ");\n");
        }

        private String paramDeclarations(List<MethodSource.Parameter> parameters) {
            return parameters
                .map(MethodSource.Parameter::declaration)
                .mkString(", ");
        }

        public List<String> delegation() {
            return List.of(
                "public " + returnType + " " + name + "(" + paramDeclarations(parameters) + ") {",
                indent("return software.amazon.awscdk.Fn." + name + "(" + paramArgs(parameters) + ");"),
                "}"
            );
        }

        private String paramArgs(List<MethodSource.Parameter> parameters) {
            return parameters
                .map(MethodSource.Parameter::name)
                .mkString(", ");
        }

        public List<String> test() {
            return List.of(
                "@Nested",
                "class " + testClassName() + " {",
                testBody()
                    .map(Generator::indent)
                    .mkString("\n"),
                "}\n"
            );
        }

        public List<String> testBody() {
            return List.of(
                "@Test",
                "void canonical() {",
                indent("FnLocalTest." + testClassName() + ".canonical();"),
                "}"
            );
        }

        private String testClassName() {
            return capitalize(name)
                + parameters.map(MethodSource.Parameter::name).map(Generator::capitalize).mkString()
                + "Test";
        }
    }

    public static String indent(String s) {
        return IND + s;
    }

    public static String capitalize(String s) {
        return StringUtils.capitalize(s);
    }
}
