import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val numbers = with(scanner) {
        IntArray(this.nextInt()) { this.nextInt() }.toMutableList()
    }

    with(numbers) {
        val shifts = scanner.nextInt()
        Collections.rotate(this, shifts)
        println(this.joinToString(separator = " "))
    }
}