package tictactoe

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
    }
}