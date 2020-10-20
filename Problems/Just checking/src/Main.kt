import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    scanner.nextLine() // ignore size
    val numbers = scanner.nextLine()
    val possibleNeighbours = scanner.nextLine()

    println(formatAnswer(areNeighbours(numbers, possibleNeighbours)))
}

fun areNeighbours(numbers: String, possibleNeighbours: String) =
        numbers.contains(possibleNeighbours) ||
                numbers.contains(possibleNeighbours.reversed())

private fun formatAnswer(areNeighbours: Boolean) = if (areNeighbours) {
    "YES"
} else {
    "NO"
}
