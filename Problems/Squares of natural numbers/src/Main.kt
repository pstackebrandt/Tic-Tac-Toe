import java.util.*

fun main() {
    val border = Scanner(System.`in`).nextInt()
    var number = 1
    while (number * number <= border) {
        println(number * number)
        number++
    }
}