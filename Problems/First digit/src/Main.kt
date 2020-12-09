fun main() {
    // part of task: use break or return in a loop
    val word = readLine()!!
    println(getFirstDigit(word))
}

private fun getFirstDigit(word: String): String {
    for (char in word) {
        if (char in '0'..'9') {
            return char.toString()
        }
    }
    return "digit not found"
}