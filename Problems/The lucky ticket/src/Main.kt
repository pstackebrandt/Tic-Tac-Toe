import LuckChecker.Companion.answer
import LuckChecker.Companion.isLucky
import java.util.Scanner

fun main() = println(answer(isLucky(toDigits(getNumber()))))

fun getNumber() = Scanner(System.`in`).next()!!

fun toDigits(number: String) = mutableListOf<Int>().apply {
    number.forEach { this.add(Character.getNumericValue(it)) }
}

class LuckChecker {
    companion object {
        fun answer(lucky: Boolean) =
                if (lucky) {
                    "Lucky"
                } else {
                    "Regular"
                }

        fun isLucky(numbers: List<Int>) =
                numbers.subList(0, 3).sum() == numbers.reversed().subList(0, 3).sum()
    }
}
