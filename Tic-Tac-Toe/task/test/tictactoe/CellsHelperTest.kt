package tictactoe

import org.junit.Test
import org.junit.Assert.*

internal class CellsHelperTest {
    class ConvertCoordinateToCellsIndexTest {
        @Test
        fun testTest() {
            assertTrue(true)
        }

        // We don't check, whether coordinate fits in a cells unit (3x3).

        @Test
        fun should_convert_r1_c1() {
            val actual = CellsHelper.convertCoordinateToCellsIndex(1, 1)
            val expected = 0
            assertEquals(expected, actual)
        }

        @Test
        fun should_convert_r2_c3() {
            val actual = CellsHelper.convertCoordinateToCellsIndex(2, 3)
            val expected = 5
            assertEquals(expected, actual)
        }

        @Test
        fun should_convert_r3_c3() {
            val actual = CellsHelper.convertCoordinateToCellsIndex(3, 3)
            val expected = 8
            assertEquals(expected, actual)
        }
    }
}