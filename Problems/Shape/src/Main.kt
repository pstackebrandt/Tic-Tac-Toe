import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val shape = scanner.nextInt()
    val chosen = "You have chosen a "
    println(when (shape) {
        1 -> chosen + "square"
        2 -> chosen + "circle"
        3 -> chosen + "triangle"
        4 -> chosen + "rhombus"
        else -> "There is no such shape!"
    })
}