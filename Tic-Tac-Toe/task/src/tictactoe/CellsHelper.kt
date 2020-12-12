package tictactoe

import tictactoe.TicTacToeGame.Companion.EMPTY_CELL
import tictactoe.TicTacToeGame.Companion.MAX_COLUMNS
import tictactoe.TicTacToeGame.Companion.O_CELL
import tictactoe.TicTacToeGame.Companion.X_CELL

class CellsHelper {
    companion object {
        internal fun hasEmptyCells(cells: String) =
                cells.contains(EMPTY_CELL)

        internal fun countXCells(cells: String) =
                cells.filter { it.toUpperCase() == X_CELL }.count()

        internal fun countOCells(cells: String) =
                cells.filter { it.toUpperCase() == O_CELL }.count()

        /** Cell positions in a 3x3 game: 012345678, coordinate (1..3, 1..3) */
        internal fun convertCoordinateToCellsIndex(row: Int, column: Int) =
                (row - 1) * MAX_COLUMNS + column - 1

        internal fun addMoveToCells(cells: String, move: Pair<Int, Int>, player: Player = Player.X): String {
            val index = convertCoordinateToCellsIndex(move.first, move.second)
            return cells.take(index) + player.getChar().toString() + cells.takeLast(cells.length - (index + 1))
        }
    }
}