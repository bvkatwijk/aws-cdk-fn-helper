package nl.bvkatwijk.awscdkfnhelper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import software.amazon.awscdk.ICfnConditionExpression;
import software.amazon.awscdk.IPostProcessor;
import software.amazon.awscdk.IResolveContext;
import software.amazon.awscdk.ResolveChangeContextOptions;
import software.constructs.IConstruct;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FnLocalTest {
    public static final ICfnConditionExpression EXPR_FALSE = new ICfnConditionExpression() {
        @Override
        public @NotNull List<String> getCreationStack() {
            return List.of();
        }

        @Override
        public @NotNull Object resolve(@NotNull IResolveContext context) {
            return false;
        }
    };
    public static final IResolveContext CTX_EMPTY = new IResolveContext() {
        @Override
        public @NotNull List<String> getDocumentPath() {
            return List.of();
        }

        @Override
        public @NotNull Boolean getPreparing() {
            return null;
        }

        @Override
        public @NotNull IConstruct getScope() {
            return null;
        }

        @Override
        public void registerPostProcessor(@NotNull IPostProcessor postProcessor) {

        }

        @Override
        public @NotNull Object resolve(
            @NotNull Object x,
            @Nullable ResolveChangeContextOptions options) {
            return null;
        }

        @Override
        public @NotNull Object resolve(@NotNull Object x) {
            return null;
        }
    };
    private static final ICfnConditionExpression EXPR_TRUE = new ICfnConditionExpression() {
        @Override
        public @NotNull List<String> getCreationStack() {
            return List.of();
        }

        @Override
        public @NotNull Object resolve(@NotNull IResolveContext context) {
            return true;
        }
    };
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
    class ConditionAndConditionsTest {
        @Test
        void single_false() {
            assertEquals(
                false,
                fn.conditionAnd(EXPR_FALSE)
                    .resolve(CTX_EMPTY)
            );
        }

        @Test
        void single_true() {
            assertEquals(
                true,
                fn.conditionAnd(EXPR_TRUE)
                    .resolve(CTX_EMPTY)
            );
        }

        @Test
        void false_true() {
            assertEquals(
                false,
                fn.conditionAnd(EXPR_FALSE, EXPR_TRUE)
                    .resolve(CTX_EMPTY)
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
    class ConditionNotConditionTest {
        @Test
        void simple_true() {
            assertEquals(
                false,
                fn.conditionNot(EXPR_TRUE)
                    .resolve(CTX_EMPTY)
            );
        }

        @Test
        void simple_false() {
            assertEquals(
                true,
                fn.conditionNot(EXPR_FALSE)
                    .resolve(CTX_EMPTY)
            );
        }
    }

    @Nested
    class ConditionOrConditionsTest {
        @Test
        void simple_true() {
            assertEquals(
                true,
                fn.conditionOr(EXPR_TRUE)
                    .resolve(CTX_EMPTY)
            );
        }

        @Test
        void simple_false() {
            assertEquals(
                false,
                fn.conditionOr(EXPR_FALSE)
                    .resolve(CTX_EMPTY)
            );
        }

        @Test
        void false_true() {
            assertEquals(
                true,
                fn.conditionOr(EXPR_FALSE, EXPR_TRUE)
                    .resolve(CTX_EMPTY)
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
    class ParseDomainNameUrlTest {
        @Test
        void tests() {
            assertAll(
                () -> assertEquals("example.com", fn.parseDomainName("https://www.example.com/path?q=123")),
                () -> assertEquals("sub.domain.co.uk", fn.parseDomainName("http://sub.domain.co.uk/test")),
                () -> assertEquals("example.org", fn.parseDomainName("example.org/something"))
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
