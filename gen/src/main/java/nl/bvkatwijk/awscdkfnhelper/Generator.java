package nl.bvkatwijk.awscdkfnhelper;

import io.vavr.Function1;
import io.vavr.collection.List;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Files;
import java.nio.file.Path;

public class Generator {
    private static final String IND = "\t";

    public static void main(String[] args) {
        new Generator().run();
    }

    @SneakyThrows
    private void run() {
        var path = Path.of(this.getClass().getResource("Fn.java").toURI());
        var file = Files.readString(path);
        var methods = extractMethods(file);
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
                extractName(source)
            );
        }

        private String extractName(List<String> source) {
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
        String name
        ) { }

    public static String indent(String s) {
        return IND + s;
    }
}
