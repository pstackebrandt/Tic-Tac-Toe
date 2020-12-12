package tictactoe

//    A few rules
//    =============
//    X starts
//    Game not finished, when neither side has three
//    in a row but the grid still has empty cells.
//    Draw when no side has a three in a row and the grid has no empty cells.
//    A player wins when he has 3 in a line (row, column, diagonal).
//    Impossible: - both have rows > 0,
//    - difference of chips wrong, expected 1 or 0

//    Code state
//    ==========
//    Not all useful tests implemented.
//    Much of code not optimized.

class TicTacToeGame(startPlayer: Player = Player.X) {
    var cells: String = "_________"
    private var gameState: GameState
    private var currentPlayer: Player

    init {
        gameState = checkGameState()
        currentPlayer = startPlayer
    }

    fun start() {
        show()
        loopGame()
    }

    private fun loopGame() {
        while (gameState == GameState.GameGoesOn) {
            nextMove()
            show()
            gameState = checkGameState()
            currentPlayer = nextPlayer(currentPlayer)
        }
        showGameState()
    }

    private fun nextMove() {
        cells = MoveMaker().makeMove(cells, currentPlayer)
    }

    private fun nextPlayer(currentPlayer: Player) = if (currentPlayer == Player.X) {
        Player.O
    } else {
        Player.X
    }

    private fun show() = printGame(cells)
    private fun showGameState() = printGameState(gameState)
    private fun checkGameState() = StateChecker.checkGameState(cells)

    companion object {
        const val O_CELL = 'O'
        const val X_CELL = 'X'
        const val EMPTY_CELL = '_'
        const val CELLS_LENGTH = 9
        const val MAX_COLUMNS = 3

        fun printGame(cells: String) {
            println("---------")
            println("| ${cells[0]} ${cells[1]} ${cells[2]} |")
            println("| ${cells[3]} ${cells[4]} ${cells[5]} |")
            println("| ${cells[6]} ${cells[7]} ${cells[8]} |")
            println("---------")
        }

        fun printGameState(gameState: GameState) {
            println(when (gameState) {
                GameState.XHasWon -> "X wins"
                GameState.OHasWon -> "O wins"
                GameState.StaleMate -> "Draw"
                GameState.GameGoesOn -> "Game not finished"
                GameState.Impossible -> "Impossible"
            })
        }

        internal fun getPlayerToken(player: Player) =
                if (player == Player.X) X_CELL else O_CELL
    }
}
