import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val numbers = with(scanner) {
        IntArray(nextInt()) { nextInt() }
    }
    println(countTriples(numbers))
}

fun countTriples(numbers: IntArray): Int {
    var triples = 0
    numbers.forEachIndexed { index, value ->
        if (index <= numbers.lastIndex - 2) {
            if (numbers[index + 1] - value == 1 &&
                    numbers[index + 2] - numbers[index + 1] == 1) {
                triples++
            }
        }
    }
    return triples
}
