import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val (hour, minute, second, day, month) = IntArray(5) { scanner.nextInt() }
    val year = scanner.nextInt()

    println("$hour:$minute:$second $day/$month/$year")
}