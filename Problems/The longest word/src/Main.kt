fun main() = println(getLongestWord(getWords()))

private fun getLongestWord(words: List<String>) =
        words.sortedByDescending { it.length }.first()

private fun getWords() = readLine()!!.split(' ')