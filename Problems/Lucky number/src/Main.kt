fun main() {
    getNumbers()
            .run {
                chunked(length / 2) {
                    it.sumBy { Character.getNumericValue(it) }
                }
            }
            .run {
                isLucky()
            }
            .run {
                getAnswer(this)
            }
            .also {
                println(it)
            }
}

private fun getNumbers() = readLine()!!
private fun List<Int>.isLucky() = first() == last()
private fun getAnswer(isLucky: Boolean) = if (isLucky) "YES" else "NO"