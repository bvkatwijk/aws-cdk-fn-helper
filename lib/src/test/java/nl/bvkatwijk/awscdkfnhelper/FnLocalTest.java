package nl.bvkatwijk.awscdkfnhelper;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FnLocalTest {
    public final FnLocal fn = new FnLocal();

    @Nested
    class Base64DataTest {
        @Test
        void doc_examples_0() {
            assertEquals(
                "QVdTIENsb3VkRm9ybWF0aW9u",
                fn.base64("AWS CloudFormation")
            );
        }
    }

    @Nested
    class ConditionEqualsLhsRhsTest {
        @Test
        void doc_examples_0() {
            assertEquals(
                false,
                //TODO use example from docs after implementing ref
                fn.conditionEquals(new Object(), new Object()).resolve(null)
            );
        }
    }

    @Nested
    class JoinDelimiterListOfValuesTest {
        @Test
        void doc_examples_0() {
            assertEquals(
                "a:b:c",
                fn.join(":", List.of("a", "b", "c"))
            );
        }
    }

    @Nested
    class LenArrayTest {
        @Test
        void doc_examples_0() {
            assertEquals(
                3,
                fn.len(new String[]{"a", "b", "c"})
            );
        }
    }

    @Nested
    class SelectIndexArrayTest {
        @Test
        void doc_examples_0() {
            assertEquals(
                "grapes",
                fn.select(1, List.of("apples", "grapes", "oranges", "mangoes"))
            );
        }
    }

    @Nested
    class SplitDelimiterSourceTest {
        @Test
        void docs_examples_0() {
            assertEquals(
                List.of("a", "b", "c"),
                fn.split("|", "a|b|c")
            );
        }

        @Test
        void docs_examples_1() {
            assertEquals(
                List.of("a", "", "c", ""),
                fn.split("|", "a||c|")
            );
        }
    }
}
