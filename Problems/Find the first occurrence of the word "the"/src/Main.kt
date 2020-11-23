fun main() {
    val indexOrNull = readLine()?.indexOf("the", ignoreCase = true)
    println(indexOrNull ?: -1)
}
