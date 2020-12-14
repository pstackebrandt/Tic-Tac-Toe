fun main() {
    val result = Array(2) { row -> Array(3) { col -> "[$row][$col]" } }
    println(result.contentDeepToString())
}