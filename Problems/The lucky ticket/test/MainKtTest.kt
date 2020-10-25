import org.junit.Test

import org.junit.Assert.*
import toDigits

class MainKtTest {

    @Test
    fun getTest() {
        assertTrue(true)
    }

    @Test
    fun toDigits() {
        val expected = "[0, 9, 0, 2, 3, 4]"
        val actual = toDigits("090234")
        println(actual)
        assert(actual.toString() == expected.toString())
    }
}