import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val word1 = scanner.next()
    val operator = scanner.next()
    val word2 = scanner.next()

    println(when (operator) {
        "equals" -> word1 == word2
        "plus" -> word1 + word2
        "endsWith" -> word1.endsWith(word2)
        else -> "Unknown operation"
    })
}