package tictactoe

import java.util.*

/** Organizes moves */
class MoveMaker {
    companion object {
        internal fun isCoordinateGiven(first: Int?, second: Int?) =
                !(first == null || second == null)

        internal fun isCoordinateInBorders(row: Int, column: Int) =
                row in 1..3 && column in 1..3

        internal fun isCoordinateFree(cells: String, row: Int, column: Int) =
                cells[CellsHelper.convertCoordinateToCellsIndex(row, column)] == EMPTY_CELL
    }

    /** Get 'cells' including a move from the user. This move is valid. */
    fun makeMove(cells: String, testMove: Pair<Int, Int>? = null): String {
        val move: Pair<Int, Int> = testMove ?: getMove(cells)

        return CellsHelper.addMoveToCells(cells, move)
    }

    private val temporaryCoordinates = 0 to 0

    /* Add coordinates for test of the method only. */
    fun getMove(cells: String, coordinatesForTest: Pair<Int, Int> = temporaryCoordinates): Pair<Int, Int> {
        println("Enter the coordinates:")
        var coordinates: Pair<Int, Int>? //row, column
        do {
            var gotCoordinates = false
            coordinates = if (coordinatesForTest == temporaryCoordinates) {
                readCoordinatesFromConsole(cells)
            } else {
                coordinatesForTest
            }
            if (coordinates != null) {

                gotCoordinates = true
            }
        } while (!gotCoordinates)

        return coordinates!!
    }

    internal fun readCoordinatesFromConsole(cells: String,
                                            isTest: Boolean = false,
                                            forTest: Pair<Int?, Int?> = Pair(null, null)): Pair<Int, Int>? {
        val scanner = Scanner(System.`in`)

        val row = if (!isTest) readIntOrNullFromConsole(scanner) else forTest.first
        val column = if (!isTest) readIntOrNullFromConsole(scanner) else forTest.second

        if (!checkCoordinates(cells, row, column)) return null

        return row!! to column!!
    }

    internal fun checkCoordinates(cells: String, row: Int?, column: Int?): Boolean {
        if (!isCoordinateGiven(row, column)) {
            println("You should enter numbers!")
            return false
        }
        if (!isCoordinateInBorders(row!!, column!!)) {
            println("Coordinates should be from 1 to 3!")
            return false
        }
        if (!isCoordinateFree(cells, row, column)) {
            println("This cell is occupied! Choose another one!")
            return false
        }
        return true
    }

    private fun readIntOrNullFromConsole(scanner: Scanner): Int? {
        if (scanner.hasNextInt()) {
            return scanner.nextInt()
        }
        return null
    }
}