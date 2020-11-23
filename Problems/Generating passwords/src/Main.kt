import java.util.Scanner
import kotlin.random.Random

fun main() = println(PasswordGenerator().generatePassword(getPasswordParts()))

data class PasswordParts(var upperCase: Int, var lowerCase: Int, var digit: Int, var leftChars: Int)

internal fun getPasswordParts() = with(Scanner(System.`in`)) {
    PasswordParts(upperCase = nextInt(),
            lowerCase = nextInt(),
            digit = nextInt(),
            leftChars = nextInt())
}

class PasswordGenerator {
    enum class CharType {
        UpperCase,
        LowerCase,
        Digit
    }

    internal fun generatePassword(parts: PasswordParts): String {
        var password = ""
        with(parts) {
            while (leftChars > 0) {
                val currentCharType = getCharType(upperCase = upperCase > 0,
                        lowerCase = lowerCase > 0,
                        digit = digit > 0)
                val lastChar: Char = if (password.isNotEmpty()) password.last() else ' '
                val char = getChar(lastChar, currentCharType)
                password += char
                leftChars--

                when (currentCharType) {
                    CharType.UpperCase -> upperCase--
                    CharType.LowerCase -> lowerCase--
                    CharType.Digit -> digit--
                }
            }
        }
        return password
    }

    /** Get char of {charType}. Char is not equal to {lastChar}. */
    internal fun getChar(lastChar: Char, charType: CharType): Char {
        val range =
                when (charType) {
                    CharType.UpperCase -> 'A'..'Z'
                    CharType.LowerCase -> 'a'..'z'
                    CharType.Digit -> '0'..'9'
                }

        var newChar: Char
        do {
            newChar = range.random()
        } while (newChar == lastChar)

        return newChar
    }

    internal fun getCharType(
        upperCase: Boolean = true,
        lowerCase: Boolean = true,
        digit: Boolean = true
    ): CharType {
        var upperCase = upperCase
        var lowerCase = lowerCase
        var digit = digit

        if (!upperCase && !lowerCase && !digit) {
            upperCase = true
            lowerCase = true
            digit = true
        }

        var value = Random.nextInt(0, 2)

        while (true) {
            if (upperCase) {
                value--
                if (value < 0) return CharType.UpperCase
            }

            if (lowerCase) {
                value--
                if (value < 0) return CharType.LowerCase
            }

            if (digit) {
                value--
                if (value < 0) return CharType.Digit
            }
        }
    }
}
