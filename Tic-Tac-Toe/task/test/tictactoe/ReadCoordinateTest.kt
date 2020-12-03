package tictactoe

import org.junit.Assert.*
import org.junit.Test

class ReadCoordinateTest {
    companion object {
        const val CELLS = "X_X_O____"
    }

    class GetMoveTest {
        @Test
        fun returns_a_result() {
            val expected = 2 to 3
            val actual = MoveMaker().getMove(CELLS, expected)
            assertEquals(expected, actual)
        }
    }

    class ReadCoordinatesFromConsoleTest {
        @Test
        fun should_return_values() {
            val expected = 1 to 2
            val actual = MoveMaker().readCoordinatesFromConsole(CELLS, true, 1 to 2)
            assertEquals(expected, actual)
        }

        @Test
        fun should_return_null_because_first_value_from_console_was_null() {
            val actual = MoveMaker().readCoordinatesFromConsole(CELLS, true, null to 4)
            assertNull(actual)
        }

        @Test
        fun should_return_null_because_second_value_from_console_was_null() {
            val actual = MoveMaker().readCoordinatesFromConsole(CELLS, true, 1 to null)
            assertNull(actual)
        }
    }
}