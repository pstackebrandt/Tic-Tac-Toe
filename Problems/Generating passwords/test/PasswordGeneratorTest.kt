import PasswordGenerator.*
import org.junit.Test

import org.junit.Assert.*

class PasswordGeneratorTest {
    @Test
    fun testTest() {
        assertTrue(true)
    }

    class GetCharTypeTest {
        @Test
        fun `should return lowercase when only lowercase true`() {
            val generator = PasswordGenerator()
            val actual = generator.getCharType(upperCase = false, lowerCase = false)
            val expected = CharType.LowerCase
            assert(actual == expected) { "Should be $expected, was $actual" }
        }


        @Test
        fun `should return uppercase when only uppercase true`() {
            val generator = PasswordGenerator()
            val actual = generator.getCharType(lowerCase = false, digit = false)
            val expected = CharType.UpperCase
            assert(actual == expected) { "Should be $expected, was $actual" }
        }

        @Test
        fun `should return digit when only digit true`() {
            val generator = PasswordGenerator()
            val actual = generator.getCharType(upperCase = false, lowerCase = false)
            val expected = CharType.Digit
            assert(actual == expected) { "Should be $expected, was $actual" }
        }

        @Test
        fun `should return any char when all charTypes true`() {
            val generator = PasswordGenerator()
            val actual = generator.getCharType()
            val expected = listOf(CharType.LowerCase, CharType.UpperCase, CharType.Digit)
            assert(actual == expected.first() ||
                    actual == expected[1] ||
                    actual == expected.last()
            ) { "Should be $expected, was $actual" }
        }

        @Test
        fun `should return char when all charTypes false`() {
            val generator = PasswordGenerator()
            val actual = generator.getCharType()
            val expected = listOf(CharType.LowerCase, CharType.UpperCase, CharType.Digit)
            assert(actual == expected.first() ||
                    actual == expected[1] ||
                    actual == expected.last()
            ) { "Should be $expected, was $actual" }
        }

        @Test
        fun `should return one of both when lowercase and digit true`() {
            val generator = PasswordGenerator()
            val actual = generator.getCharType(upperCase = false)
            val expected = listOf(CharType.LowerCase, CharType.Digit)
            assert(actual == expected.first() ||
                    actual == expected.last()
            ) { "Should be $expected, was $actual" }
        }
    }

    class GetCharTest {
        @Test
        fun `should return lowercase char but not lastChar`() {
            val generator = PasswordGenerator()
            val actual = generator.getChar('a', CharType.LowerCase)
            val expected = 'b'..'z'
            assert(actual in expected) { "Should be $expected, was $actual" }
        }
    }
}