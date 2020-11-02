fun main() {
    getWords()
            .joinToString(" ")
            .also { println(it) }
}

private fun getWords() = Array(5) { readLine()!! }