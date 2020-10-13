import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val numbers = with(scanner) {
        IntArray(nextInt()) { nextInt() }
    }
    numbers.indexOfFirst { it == numbers.max() }
            .also { println(it) }
}