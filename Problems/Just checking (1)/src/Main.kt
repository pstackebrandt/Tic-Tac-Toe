import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val languageNumber = scanner.nextInt()

    println(when (languageNumber) {
        2 -> "Yes!"
        1, 3, 4 -> "No!"
        else -> "Unknown number"
    })
}