fun main() = println(answer(isPalindrome(getWord())))

private fun getWord() = readLine()!!
private fun answer(isPalindrome: Boolean) = if (isPalindrome) "yes" else "no"
private fun isPalindrome(word: String) = word == word.reversed()