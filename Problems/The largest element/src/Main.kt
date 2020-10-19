import java.util.*

const val stop = 0

fun main() {
    println(getNumbers().max())
    // .maxOrNull() leads to unresolved reference at compile time. Why??
}

private fun getNumbers(): List<Int> {
    val numbers = mutableListOf<Int>()
    with(Scanner(System.`in`)) {
        do {
            val number = this.nextInt()
            if (number != stop) numbers.add(number)
        } while (number != stop)
    }
    return numbers
}