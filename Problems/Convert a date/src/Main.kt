import java.util.Scanner

fun main() {
    readLine()!!.split('-')
            .run { "${this[1]}/${this[2]}/${this[0]}" }
            .also { println(it) }
}