import java.util.*

fun main() {
    getNumbers(getCount()).forEach { print("$it ") }
}

private fun getNumbers(number: Int): MutableList<Int> {
    return mutableListOf<Int>()
            .apply {
                var leftNumbers = number
                var repetions = 1
                while (leftNumbers > 0) {
                    for (repetition in 1..repetions) {
                        if (leftNumbers > 0) {
                            add(repetions)
                        }
                        leftNumbers--
                    }
                    repetions++
                }
            }
}

private fun getCount() = Scanner(System.`in`).nextInt()