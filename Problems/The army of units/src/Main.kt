import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val units = scanner.nextInt()

    println(when {
        units <= 0 -> "no army"
        units <= 4 -> "few"
        units <= 9 -> "several"
        units <= 19 -> "pack"
        units <= 49 -> "lots"
        units <= 99 -> "horde"
        units <= 249 -> "throng"
        units <= 499 -> "swarm"
        units <= 999 -> "zounds"
        else -> "legion"
    })
}