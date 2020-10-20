import java.util.*

fun main(args: Array<String>) {
    Scanner(System.`in`).let { my -> IntArray(my.nextInt()) { my.nextInt() }.toList() }.windowed(3)
        .filter { it == (it[0]..it[2]).toList() }.also { println(it.size) }
}
