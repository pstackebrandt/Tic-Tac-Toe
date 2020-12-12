package tictactoe

import org.junit.Test
import tictactoe.CellsHelper.Companion.countOCells
import tictactoe.CellsHelper.Companion.countXCells
import tictactoe.TicTacToeGame.Companion.O_CELL
import tictactoe.TicTacToeGame.Companion.X_CELL
import tictactoe.TicTacToeGame.Companion.getPlayerToken

@Suppress("unused")
class CellTest {
    class CountXCellsTest {
        @Test
        fun should_count_x_cells() {
            val expected = 3
            @Suppress("SpellCheckingInspection") val actual = countXCells("XXXOO__O_")
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
            @Suppress("SpellCheckingInspection") val actual = countOCells("XXXOO_OO_")
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
            @Suppress("unused")
            assert(actual == O_CELL) { "Should deliver O cell. delivered: $actual" }
        }
    }
}
