import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val scanner = Scanner(System.`in`)
    val type = scanner.next()

    println(when (type) {
        "triangle" ->
            areaOfTriangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble())

        "rectangle" -> areaOfRectangle(scanner.nextDouble(), scanner.nextDouble())

        else -> // "circle"
            areaOfCircle(scanner.nextDouble())
    })
}

private fun areaOfTriangle(sideA: Double, sideB: Double, sideC: Double): Double {
    val s = (sideA + sideB + sideC) / 2
    return sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
}

private fun areaOfRectangle(sideA: Double, sideB: Double) = sideA * sideB

private fun areaOfCircle(radius: Double) = radius.pow(2) * 3.14
