import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    with(getNumbers(scanner)) {
        val max = this.max()
        val index = getPosition(this, max)

        println("$max $index")
    }
}

private fun getNumbers(scanner: Scanner): List<Int> = mutableListOf<Int>()
        .apply {
            scanner.let {
                while (it.hasNextInt()) {
                    this.add(it.nextInt())
                }
            }
        }

private fun getPosition(numbers: List<Int>, max: Int?) =
        numbers.indexOf(max) + 1