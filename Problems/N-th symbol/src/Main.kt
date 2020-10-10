import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val text = scanner.nextLine()
    val number = scanner.nextInt()

    println("Symbol # $number of the string \"$text\" is '${text[number - 1]}'")
}