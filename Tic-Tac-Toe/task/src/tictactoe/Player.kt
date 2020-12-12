package tictactoe

enum class Player {
    X,
    O
}

fun Player.getChar(): Char {
    return if (this == Player.X) {
        TicTacToeGame.X_CELL
    } else {
        TicTacToeGame.O_CELL
    }
}