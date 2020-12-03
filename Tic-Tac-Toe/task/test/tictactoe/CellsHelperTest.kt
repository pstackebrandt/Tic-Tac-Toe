package tictactoe

import org.junit.Test
import org.junit.Assert.*

@Suppress("unused")
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

    class AddMoveToCellsTest {
        private val testCells = "012345678"

        @Test
        fun should_add_move_at_1_3() {
            val actual = CellsHelper.addMoveToCells(testCells, 1 to 3)
            val expected = "01X345678"
            assertEquals(expected, actual)
        }

        @Test
        fun should_add_move_at_first_index() {
            val actual = CellsHelper.addMoveToCells(testCells, 1 to 1)
            val expected = "X12345678"
            assertEquals(expected, actual)
        }

        @Test
        fun should_add_move_at_last_index() {
            val actual = CellsHelper.addMoveToCells(testCells, 3 to 3)
            val expected = "01234567X"
            assertEquals(expected, actual)
        }
    }
}