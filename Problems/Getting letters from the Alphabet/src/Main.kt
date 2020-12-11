import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`)
    val lastLetter = input.next().first()
    val previousLetters = previousLetters(lastLetter)
    println(previousLetters.joinToString(separator = ""))
}

private fun previousLetters(lastLetter: Char): MutableList<Char> {
    val previousLetters = mutableListOf<Char>()

    for (char in 'a'..'z') {
        if (char == lastLetter) {
            return previousLetters
        }
        previousLetters.add(char)
    }
    return previousLetters
}