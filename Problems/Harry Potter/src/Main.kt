import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val house = scanner.next()

    println(when (house) {
        "gryffindor" -> "bravery"
        "hufflepuff" -> "loyalty"
        "slytherin" -> "cunning"
        "ravenclaw" -> "intellect"
        else -> "not a valid house"
    })
}