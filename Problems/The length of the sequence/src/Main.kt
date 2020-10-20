import java.util.*

fun main() {
    println(Scanner(System.`in`)
            .readAllNumbers()
            .count())
}

fun Scanner.readAllNumbers() = mutableListOf<Int>()
        .apply {
            while (hasNextInt()) {
                val number = nextInt()
                if (number != 0) {
                    this.add(number)
                } else {
                    break
                }
            }
        }