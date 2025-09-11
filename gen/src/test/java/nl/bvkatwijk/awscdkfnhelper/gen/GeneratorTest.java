package nl.bvkatwijk.awscdkfnhelper.gen;

import io.vavr.collection.List;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

class GeneratorTest {
    public static final Generator.MethodSource.Parameter STRING_PARAM =
        new Generator.MethodSource.Parameter(
            "String",
            "param"
        );

    private static Generator.Method METHOD_SIMPLE() {
        return new Generator.Method(
            List.of(),
            "methodName",
            "String",
            List.of(
                STRING_PARAM
            )
        );
    }

    @Test
    void testMethod() {
        Approvals.verify(METHOD_SIMPLE().test().mkString("\n"));
    }

    @Test
    void testBody() {
        Approvals.verify(METHOD_SIMPLE().testMethod().mkString("\n"));
    }

    @Test
    void delegation() {
        Approvals.verify(METHOD_SIMPLE().delegation().mkString("\n"));
    }

    @Test
    void interfaceDeclaration() {
        Approvals.verify(METHOD_SIMPLE().interfaceDeclaration().mkString("\n"));
    }
}
