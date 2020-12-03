package tictactoe

import org.junit.Assert
import org.junit.Test

class MoveMakerTest {
    @Test
    fun testTest() {
        Assert.assertTrue(true)
    }

    class CheckForNotNullTest {
        @Test
        fun should_invalidate_first_value_if_is_null() {
            val actual = MoveMaker.isCoordinateGiven(null, 1)
            Assert.assertFalse(actual)
        }

        @Test
        fun should_invalidate_second_value_if_is_null() {
            val actual = MoveMaker.isCoordinateGiven(2, null)
            Assert.assertFalse(actual)
        }

        @Test
        fun should_validate_first_value_if_is_null() {
            val actual = MoveMaker.isCoordinateGiven(2, 1)
            Assert.assertTrue(actual)
        }
    }

    class IsCoordinateInBordersTest {
        @Test
        fun should_validate_coordinate_in_borders_for_r3_c1() {
            val actual = MoveMaker.isCoordinateInBorders(3, 1)
            Assert.assertTrue(actual)
        }

        @Test
        fun should_validate_coordinate_in_borders_for_r3_c3() {
            val actual = MoveMaker.isCoordinateInBorders(3, 3)
            Assert.assertTrue(actual)
        }

        @Test
        fun should_invalidate_coordinate_in_borders_because_row_too_big_with_4() {
            val actual = MoveMaker.isCoordinateInBorders(4, 1)
            Assert.assertFalse(actual)
        }

        @Test
        fun should_invalidate_coordinate_in_borders_because_col_too_big_with_4() {
            val actual = MoveMaker.isCoordinateInBorders(2, 4)
            Assert.assertFalse(actual)
        }

        @Test
        fun should_invalidate_coordinate_in_borders_because_row_too_small_with_0() {
            val actual = MoveMaker.isCoordinateInBorders(0, 2)
            Assert.assertFalse(actual)
        }

        @Test
        fun should_invalidate_coordinate_in_borders_because_col_too_small_with_minus1() {
            val actual = MoveMaker.isCoordinateInBorders(3, -1)
            Assert.assertFalse(actual)
        }
    }

    class IsCoordinateFreeTest {
        @Test
        fun should_validate_coordinate_is_free() {
            val actual = MoveMaker.isCoordinateFree(ReadCoordinateTest.CELLS, 3, 1)
            Assert.assertTrue(actual)
        }

        @Test
        fun should_invalidate_coordinate_is_free() {
            val actual = MoveMaker.isCoordinateFree(ReadCoordinateTest.CELLS, 1, 3)
            Assert.assertFalse(actual)
        }
    }
}