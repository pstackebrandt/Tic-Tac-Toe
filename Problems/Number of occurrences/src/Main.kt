fun main() {
    val sentence = readLine()!!
    val word = readLine()!!
    println(countOccurrences(sentence, word))
}

private fun countOccurrences(sentence: String, word: String) = sentence.split(word).count() - 1