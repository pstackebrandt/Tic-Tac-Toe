fun main() {
    println(isSubstringOfOrderedAlphabet(getText()))
}

private fun getText() = readLine()!!

fun isSubstringOfOrderedAlphabet(text: String): Boolean {
    text.forEachIndexed { index, value ->
        if (index < text.lastIndex) {
            if (value.toInt() != text[index + 1].toInt() - 1) {
                return false
            }
        }
    }
    return true
}