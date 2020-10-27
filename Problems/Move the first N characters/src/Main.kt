import java.util.Scanner

fun main() {
    getInput()
            .run { moveCharsToEnd(movesCount, originalText) }
            .also { println(it) }
}

internal fun moveCharsToEnd(count: Int, string: String) =
        if (count >= string.length || count <= 0) {
            string
        } else {
            string.substring(count) + string.subSequence(0 until count)
        }

internal fun getInput() =
        with(Scanner(System.`in`)) {
            Input(next().trim(), nextInt())
        }

data class Input(val originalText: String, val movesCount: Int)