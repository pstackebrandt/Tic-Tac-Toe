@file:Suppress("unused")

package tictactoe

import java.util.*

const val X_CELL = 'X'
const val O_CELL = 'O'
const val EMPTY_CELL = '_'
const val CELLS_LENGTH = 9

@Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER")
const val MAX_ROWS = 3
const val MAX_COLUMNS = 3

fun main() {
    //val gameStateHelper = GameStateHelper()
    var cells = getStartSituation().toUpperCase()
    //var gameState = gameStateHelper.checkGameState(cells)
    printGame(cells)

    cells = MoveMaker().makeMove(cells)
    //gameState = checkGameState(cells) // todo activate for stage 5/5

    printGame(cells)
    //printGameState(gameState) // todo activate for stage 5/5
}

//  Any Rules
//    difference of chips wrong, expected 1 or 0
//    Impossible, both have rows > 0,
//    O wins when the grid has three O’s in a row.
//    X wins when the grid has three X’s in a row.
//    Draw when no side has a three in a row and the grid has no empty cells.
//    in a row but the grid still has empty cells.
//    Game not finished, when neither side has three
//  ---------

enum class Player {
    X,
    O
}

private fun getStartSituation(): String {
    println("Enter cells:")
    return Scanner(System.`in`).next()
}

internal fun getPlayerToken(player: Player) =
        if (player == Player.X) X_CELL else O_CELL

private fun printGame(cells: String) {
    println("---------")
    println("| ${cells[0]} ${cells[1]} ${cells[2]} |")
    println("| ${cells[3]} ${cells[4]} ${cells[5]} |")
    println("| ${cells[6]} ${cells[7]} ${cells[8]} |")
    println("---------")
}
