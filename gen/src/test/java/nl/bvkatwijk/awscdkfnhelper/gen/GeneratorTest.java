package nl.bvkatwijk.awscdkfnhelper.gen;

import io.vavr.collection.List;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneratorTest {
    public static final Generator.MethodSource.Parameter STRING_PARAM =
        new Generator.MethodSource.Parameter(
            "String",
            "param"
        );

    private static Generator.Method METHOD_SIMPLE = new Generator.Method(
        List.of(),
        "methodName",
        "String",
        List.of(
            STRING_PARAM
        )
    );


    @Test
    void testClass() {
        Approvals.verify(METHOD_SIMPLE.test().mkString("\n"));
    }

    @Test
    void testMethod() {
        Approvals.verify(METHOD_SIMPLE.testMethod().mkString("\n"));
    }

    @Test
    void delegation() {
        Approvals.verify(GeneratorTest.METHOD_SIMPLE.delegation().mkString("\n"));
    }

    @Test
    void interfaceDeclaration() {
        Approvals.verify(METHOD_SIMPLE.interfaceDeclaration().mkString("\n"));
    }

    @Test
    void methodSource() {
        assertEquals(
            METHOD_SIMPLE, new Generator.MethodSource(List.of(
                "public static String methodName(String param) {",
                "return \"foo\";",
                "}"
            )).toMethod());
    }
}
