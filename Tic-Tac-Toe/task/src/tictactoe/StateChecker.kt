package tictactoe

import tictactoe.TicTacToeGame.Companion.CELLS_LENGTH
import kotlin.math.abs

class StateChecker {
    companion object {
        fun checkGameState(cells: String): GameState {
            if (isImpossibleCells(cells)) return GameState.Impossible
            if (isWinner(Player.X, cells)) return GameState.XHasWon
            if (isWinner(Player.O, cells)) return GameState.OHasWon
            if (CellsHelper.hasEmptyCells(cells)) return GameState.GameGoesOn
            return GameState.StaleMate
        }

        private fun isImpossibleCells(cells: String): Boolean {
            if (!hasValidCharacters(cells)) return true
            if (!isPlayerCellsCountOk(cells)) return true
            if (!hasBalancedLinesCount(cells)) return true
            return false
        }

        private fun hasBalancedLinesCount(cells: String) =
                takenLinesCount(cells, Player.O) + takenLinesCount(cells, Player.X) <= 1

        internal fun isPlayerCellsCountOk(cells: String) =
                with(countPlayerCells(cells)) { abs(first - second) <= 1 }

        internal fun hasValidCharacters(cells: String): Boolean {
            if (!hasValidLength(cells)) return false
            return cells.filter { it in "XO_" }.count() == 9
        }

        internal fun hasValidLength(cells: String) =
                cells.length == CELLS_LENGTH

        /** Get count of lines taken by [player]. A line may be a row, column or diagonal. */
        internal fun takenLinesCount(cells: String, player: Player): Int {
            val lines = listOf(
                    listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8),  // rows
                    listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // columns
                    listOf(6, 4, 2), listOf(0, 4, 8) // slash line, back slash line
            )
            val token = TicTacToeGame.getPlayerToken(player)
            var takenLines = 0

            for (line in lines) {
                if (cells[line[0]] == token &&
                        cells[line[1]] == token &&
                        cells[line[2]] == token) {
                    takenLines++
                }
            }
            return takenLines
        }

        internal fun countPlayerCells(cells: String) =
                CellsHelper.countXCells(cells) to CellsHelper.countOCells(cells)

        fun isWinner(player: Player, cells: String) = takenLinesCount(cells, player) > 0
    }
}