package nl.bvkatwijk.awscdkfnhelper;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FnLocalTest {
    public final FnLocal fn = new FnLocal();

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
