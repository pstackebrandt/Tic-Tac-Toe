import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val numbers = with(scanner) {
        IntArray(this.nextInt()) { this.nextInt() }
    }
    val shiftedNumbers = mutableListOf(numbers.last())
    shiftedNumbers.addAll(numbers.toList().subList(0, numbers.lastIndex))
    shiftedNumbers.forEach{ print("$it ")}
}