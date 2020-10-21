import java.util.*

fun main() {
    calculateValues(getStartNumber()).forEach { println(it) }
}

internal fun calculateValues(number: Int) =
        mutableListOf<Int>().apply {
            var workNumber = number
            while (workNumber > 1) {
                this.add(workNumber)
                if (workNumber.isEven()) {
                    workNumber /= 2
                } else {
                    workNumber = workNumber * 3 + 1
                }
            }
            this.add(workNumber)
        }

private fun Int.isEven() = this % 2 == 0
private fun getStartNumber() = Scanner(System.`in`).nextInt()
