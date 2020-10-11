import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val companiesCount = scanner.nextInt()
    val incomes = with(scanner) {
        IntArray(companiesCount) { this.nextInt() }
    }
    val taxes = with(scanner) {
        IntArray(companiesCount) { this.nextInt() }
    }
    var biggestTax = 0
    var biggestPayer = 0

    for (income in incomes.withIndex()) {
        val currentTax = income.value * taxes[income.index]
        if (biggestTax < currentTax) {
            biggestTax = currentTax
            biggestPayer = income.index
        }
    }

    println(biggestPayer + 1)
}