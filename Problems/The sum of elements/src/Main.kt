import java.util.*

fun main() {
    println(getNumbers().sum())
}

private fun getNumbers(): List<Int> {
    var list = mutableListOf<Int>()
    with(Scanner(System.`in`)) {
        while (this.hasNextInt()) {
            var value = this.nextInt()
            if (value > 0) {
                list.add(value)
            } else {
                break
            }
        }
    }
    return list
}
