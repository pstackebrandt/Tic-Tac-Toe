fun main() = println(compress(getDNAString()))

private fun compress(dNAString: String) =
        StringBuilder().apply {
            var currentChar = '#'
            var equalCharCount = 0
            dNAString.forEachIndexed { index, char ->
                if (index == 0) {
                    currentChar = char
                }
                if (char == currentChar) {
                    equalCharCount++
                    if (index == dNAString.lastIndex) {
                        this.appendCompressedGroup(currentChar, equalCharCount)
                    }
                } else {
                    this.appendCompressedGroup(currentChar, equalCharCount)
                    currentChar = char
                    equalCharCount = 1
                    if (index == dNAString.lastIndex) {
                        this.appendCompressedGroup(currentChar, equalCharCount)
                    }
                }
            }
        }.toString()

private fun getDNAString() = readLine()!!

private fun StringBuilder.appendCompressedGroup(
    currentChar: Char,
    equalCharCount: Int
) = this.append("$currentChar$equalCharCount")
