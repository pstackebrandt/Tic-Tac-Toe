import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val number1 = scanner.nextLong()
    val operator = scanner.next()
    val number2 = scanner.nextLong()

    println(when (operator) {
        "+" -> number1 + number2
        "-" -> number1 - number2
        "/" -> {
            if (number2 != 0L) {
                number1 / number2
            } else {
                "Division by 0!"
            }
        }
        "*" -> number1 * number2
        else -> "Unknown operator"
    })
}