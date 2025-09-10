package nl.bvkatwijk.awscdkfnhelper.gen;

import io.vavr.collection.List;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

class GeneratorTest {
    @Test
    void testMethod() {
        Approvals.verify(new Generator.Method(
            List.of(),
            "methodName",
            "String",
            List.of(
                new Generator.MethodSource.Parameter(
                    "String",
                    "param"
                )
            )
        ).test().mkString("\n"));
    }
}
