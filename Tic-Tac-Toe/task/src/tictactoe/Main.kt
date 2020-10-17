package tictactoe

import java.util.Scanner
import kotlin.math.abs

const val X_CELL = 'X'
const val O_CELL = 'O'
const val EMPTY_CELL = '_'
const val CELLS_LENGTH = 9

fun main() {
    val cells = getInput().toUpperCase()
    val gameState = checkGameState(cells)
    printGame(cells)
    printGameState(gameState)
}

//    Game not finished, when neither side has three
//    in a row but the grid still has empty cells.
//    Draw when no side has a three in a row and the grid has no empty cells.
//    X wins when the grid has three X’s in a row.
//    O wins when the grid has three O’s in a row.
//    Impossible, both have rows > 0,
//    difference of chips wrong, expected 1 or 0

enum class GameState {
    GameGoesOn,
    XHasWon,
    OHasWon,
    Impossible,
    StaleMate
}

enum class Player {
    X,
    O
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

fun checkGameState(cells: String): GameState {
    if (isImpossibleCells(cells)) return GameState.Impossible
    if (isWinner(Player.X, cells)) return GameState.XHasWon
    if (isWinner(Player.O, cells)) return GameState.OHasWon
    if (hasEmptyCells(cells)) return GameState.GameGoesOn
    return GameState.StaleMate
}

fun isWinner(player: Player, cells: String) = takenLinesCount(cells, player) > 0

fun isImpossibleCells(cells: String): Boolean {
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
    val token = getPlayerToken(player)
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

internal fun getPlayerToken(player: Player) =
        if (player == Player.X) X_CELL else O_CELL

internal fun countPlayerCells(cells: String) =
        countXCells(cells) to countOCells(cells)

internal fun countXCells(cells: String) =
        cells.filter { it.toUpperCase() == X_CELL }.count()

internal fun countOCells(cells: String) =
        cells.filter { it.toUpperCase() == O_CELL }.count()

internal fun hasEmptyCells(cells: String) =
        cells.contains(EMPTY_CELL)

private fun getInput() = Scanner(System.`in`).next()

private fun printGame(cells: String) {
    println("---------")
    println("| ${cells[0]} ${cells[1]} ${cells[2]} |")
    println("| ${cells[3]} ${cells[4]} ${cells[5]} |")
    println("| ${cells[6]} ${cells[7]} ${cells[8]} |")
    println("---------")
}
