package tictactoe

import org.junit.Assert.*
import org.junit.Test

class ReadCoordinateTest {

    @Test
    fun testTest() {
        assertTrue(true)
    }

    class GetMoveTest {
        @Test
        fun returns_a_result() {
            val expected = 2 to 3
            val actual = MoveMaker().getMove(expected)
            assertEquals(expected, actual)
        }
    }

    class ReadCoordinatesFromConsoleTest {
        @Test
        fun should_return_values() {
            val expected = 1 to 2
            val actual = MoveMaker().readCoordinatesFromConsole(true, 1 to 2)
            assertEquals(expected, actual)
        }

        @Test
        fun should_return_null_because_first_value_from_console_was_null() {
            val actual = MoveMaker().readCoordinatesFromConsole(true, null to 4)
            assertNull(actual)
        }

        @Test
        fun should_return_null_because_second_value_from_console_was_null() {
            val actual = MoveMaker().readCoordinatesFromConsole(true, 1 to null)
            assertNull(actual)
        }
    }

    class CheckCoordinatesTest {

        class CheckForNotNullTest {
            @Test
            fun should_invalidate_first_value_if_is_null() {
                val actual = MoveMaker().checkCoordinates(null, 1)
                assertFalse(actual)
            }

            @Test
            fun should_invalidate_second_value_if_is_null() {
                val actual = MoveMaker().checkCoordinates(2, null)
                assertFalse(actual)
            }

            @Test
            fun should_validate_first_value_if_is_null() {
                val actual = MoveMaker().checkCoordinates(2, 1)
                assertTrue(actual)
            }
        }

        class CheckForBorderFitTest {
            private val smallestValidValue = 1
            private val biggestValidValue = 3

            @Test
            fun should_validate_values_fit_3_1() {
                val actual = MoveMaker().checkCoordinates(smallestValidValue, biggestValidValue)
                assertTrue(actual)
            }

            @Test
            fun should_validate_values_fit_1_3() {
                val actual = MoveMaker().checkCoordinates(biggestValidValue, smallestValidValue)
                assertTrue(actual)
            }

            @Test
            fun should_invalidate_first_value_too_small() {
                val actual = MoveMaker().checkCoordinates(smallestValidValue - 1, biggestValidValue)
                assertFalse(actual)
            }

            @Test
            fun should_invalidate_first_value_too_big() {
                val actual = MoveMaker().checkCoordinates(smallestValidValue, biggestValidValue + 1)
                assertFalse(actual)
            }

            @Test
            fun should_invalidate_second_value_too_big() {
                val actual = MoveMaker().checkCoordinates(smallestValidValue, biggestValidValue + 1)
                assertFalse(actual)
            }

            @Test
            fun should_invalidate_second_value_too_small() {
                val actual = MoveMaker().checkCoordinates(biggestValidValue, smallestValidValue - 1)
                assertFalse(actual)
            }
        }
    }
}