import java.util.*

const val INPUT_END = 0

fun main() {
    println(getNumbers().max())
    // .getNumbers().maxOrNull() leads to unresolved reference at compile time. Why??
}

private fun getNumbers(): List<Int> {
    val numbers = mutableListOf<Int>()
    with(Scanner(System.`in`)) {
        do {
            val number = this.nextInt()
            if (number != INPUT_END) numbers.add(number)
        } while (number != INPUT_END)
    }
    return numbers
}
