import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val number = scanner.nextInt()
    println(when {
        number in 0..9 -> 1
        number <= 99 -> 2
        number <= 999 -> 3
        number <= 9999 -> 4
        else -> "out of range"
    }
    )
}