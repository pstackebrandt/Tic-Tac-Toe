import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val numbers = with(scanner) {
        IntArray(this.nextInt()) { this.nextInt() }.toMutableList()
    }
    val searchedNumber = scanner.nextInt()

    if (numbers.contains(searchedNumber)) {
        "YES"
    } else {
        "NO"
    }.also {
        println(it)
    }
}