class TriplesTest {

    @org.junit.Test
    fun find_2_triples() {
        var numbers = intArrayOf(1, 2, 3, 4, 5, 6)
        val actual = countTriples(numbers)

        val expected = 4
        assert(actual == expected) { "$expected triple expected, actual: $actual" }
    }

    @org.junit.Test
    fun find_4_triples() {
        var numbers = intArrayOf(1, 2, 4, 5, 6, 7)
        val actual = countTriples(numbers)
        val expected = 2
        assert(actual == expected) { "$expected triple expected, actual: $actual" }
    }

    @org.junit.Test
    fun find_0_triples() {
        var numbers = intArrayOf(1, 3, 3, 4, 7, 6)
        val actual = countTriples(numbers)
        assert(actual == 0) { "triple expected" }
    }

    @org.junit.Test
    fun find_0_triples_because_2_numbers_only() {
        var numbers = intArrayOf(1, 3)
        val actual = countTriples(numbers)
        assert(actual == 0) { "no triple expected" }
    }

    @org.junit.Test
    fun find_0_triples_ignore_descending_triple() {
        var numbers = intArrayOf(1, 4, 7, 5, 4, 3)
        val actual = countTriples(numbers)
        assert(actual == 0) { "no triple expected" }
    }
}