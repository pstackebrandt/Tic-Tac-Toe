import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val numbers = IntArray(scanner.nextInt()) { scanner.nextInt() }
    val searchedNumber = scanner.nextInt()

    println(numbers.count { it == searchedNumber })
}