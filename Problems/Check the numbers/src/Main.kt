//package checkTheNumbers
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val numbersCount = scanner.nextInt()
    val numbers = IntArray(numbersCount) { scanner.nextInt() }
    val firstAndSecond = setOf(scanner.nextInt(), scanner.nextInt())

    val areNeighbours = areNeighbours(numbers, firstAndSecond)
    val result = if (areNeighbours) {
        "NO"
    } else {
        "YES"
    }

    println(result)
}

internal fun areNeighbours(numbers: IntArray, firstAndSecond: Set<Int>): Boolean {
    for (number in numbers.withIndex()) {
        if (number.index < numbers.lastIndex) {
            val currentAndNext = setOf(number.value, numbers[number.index + 1])
            if (currentAndNext == firstAndSecond) {
                return true
            }
        }
    }
    return false
}