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
		void canonical() {
			assertEquals(
				List.of("tg", "abc-123", "def-456"),
				fn.split("/", "tg/abc-123/def-456")
			);
		}
	}
}
