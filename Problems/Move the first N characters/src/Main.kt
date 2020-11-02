import java.util.Scanner

fun main() {
    getInput()
            .run { moveCharsToEnd(movesCount, originalText) }
            .also { println(it) }
}

private fun moveCharsToEnd(count: Int, string: String) =
        string.drop(count) + string.take(count)

private fun getInput() =
        with(Scanner(System.`in`)) {
            Input(next().trim(), nextInt())
        }

data class Input(val originalText: String, val movesCount: Int)