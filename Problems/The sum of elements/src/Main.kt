import java.util.*

fun main() {
    println(getNumbers().sum())
}

private fun getNumbers(): List<Int> {
    val list = mutableListOf<Int>()
    with(Scanner(System.`in`)) {
        while (this.hasNextInt()) {
            val value = this.nextInt()
            if (value > 0) {
                list.add(value)
            } else {
                break
            }
        }
    }
    return list
}
