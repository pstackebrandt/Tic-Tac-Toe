import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val ships = getShips(scanner)
    val game = ShipGame(5, 5)
    game.setShips(ships)
    //game.showShips() // for test
    showFreeLines(game)
}

private fun showFreeLines(game: ShipGame) {
    println(game.freeRows().joinToString(separator = " ", transform = { "${it + 1}" }))
    println(game.freeColumns().joinToString(separator = " ", transform = { "${it + 1}" }))
}

private fun getShips(scanner: Scanner): MutableList<Pair<Int, Int>> {
    val ships = mutableListOf<Pair<Int, Int>>()
    repeat(3) { ships.add(Pair(scanner.nextInt() - 1, scanner.nextInt() - 1)) }
    return ships
}

class ShipGame(rowsCount: Int, private val columnsCount: Int) {
    private var rows: Array<IntArray> = Array(rowsCount) {
        IntArray(columnsCount) { 0 }
    }

    fun setShips(ships: List<Pair<Int, Int>>) {
        ships.forEach { ship ->
            rows.forEachIndexed { rIndex, row ->
                row.forEachIndexed { cIndex, _ ->
                    if (ship.first == rIndex && ship.second == cIndex)
                        row[cIndex] = 1
                }
            }
        }
    }

    @Suppress("unused")
    fun showShips() {
        println(rows.forEachIndexed { rIndex, row ->
            println("row: $rIndex")
            row.forEachIndexed { cIndex, column ->
                println("row: $rIndex col: $cIndex $column")
            }
        })
    }

    fun freeColumns(): List<Int> {
        val freeColumns = mutableListOf<Int>()

        for (column in 0 until columnsCount) {
            if (columnFree(column)) {
                freeColumns.add(column)
            }
        }

        return freeColumns
    }

    private fun columnFree(column: Int): Boolean {
        rows.forEach { row ->
            if (row[column] != 0) return false
        }
        return true
    }

    fun freeRows(): List<Int> {
        val freeRows = mutableListOf<Int>()
        rows.forEachIndexed { rIndex, row ->
            if (row.filter { it == 0 }.count() == columnsCount) {
                freeRows.add(rIndex)
            }
        }
        return freeRows
    }
}

