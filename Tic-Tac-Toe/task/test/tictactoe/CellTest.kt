package tictactoe

import org.junit.Test
import org.junit.Assert.*
import tictactoe.CellsHelper.Companion.countOCells
import tictactoe.CellsHelper.Companion.countXCells
import tictactoe.CellsHelper.Companion.hasEmptyCells

class CellTest {
    companion object {
        const val CELLS_WITH_ROW_0_TAKEN_BY_X = "XXXO_OOO_"
        const val CELLS_WITH_COLUMN_TAKEN_BY_O = "XO_XO__O_"
        const val CELLS_WITH_SLASH_LINE_TAKEN_BY_O = "X_OXO_O__"
        const val CELLS_WITH_BACK_SLASH_LINE_TAKEN_BY_X = "X_O_XO_OX"
        const val CELLS_WITH_NO_LINE_TAKEN = "XO_______"
        const val CELLS_WITH_REGULAR_CHARACTERS_AND_LENGTH = "XOXO_____"
        const val CELLS_TOO_SHORT = "XOXO__"
        const val CELLS_TOO_LONG = "XOXO_____XO" //11 characters
        const val CELLS_WITH_INVALID_CHARACTERS = "XOXO1#_ _"
        const val CELLS_WITH_PLAYER_CELLS_COUNT_OFF_BALANCE = "XXXO_____"
        const val CELLS_WITH_PLAYER_CELLS_COUNT_OK = "XXOO_____"
        const val CELLS_WITH_UNFINISHED_GAME = "XXOO_____"
        const val CELLS_WITH_STALE_MATE = "XOXXXOOXO"
    }

    @Test
    fun testTest() {
        assertTrue(true)
    }

    class CountXCellsTest {
        @Test
        fun should_count_x_cells() {
            val expected = 3
            val actual = countXCells("XXXOO__O_")
            assert(actual == expected) { "Should count $expected X cells. Counted: $actual" }
        }

        @Test
        fun should_count_0_x_cells() {
            val expected = 0
            val actual = countXCells("___OO__O_")
            assert(actual == expected) { "Should count $expected X cells. Counted: $actual" }
        }
    }

    class CountOCellsTest {
        @Test
        fun should_count_x_cells() {
            val expected = 4
            val actual = countOCells("XXXOO_OO_")
            assert(actual == expected) { "Should count $expected O cells. Counted: $actual" }
        }

        @Test
        fun should_count_0_O_cells() {
            val expected = 0
            val actual = countOCells("XXX___XX_")
            assert(actual == expected) { "Should count $expected X cells. Counted: $actual" }
        }
    }

    class GetPlayerCellTest {
        @Test
        fun should_deliver_player_x_cell_token() {
            val actual = getPlayerToken(Player.X)
            assert(actual == X_CELL) { "Should deliver X cell. delivered: $actual" }
        }

        @Test
        fun should_deliver_player_o_cell_token() {
            val actual = getPlayerToken(Player.O)
            assert(actual == O_CELL) { "Should deliver O cell. delivered: $actual" }
        }
    }
}