import java.util.*

data class PurchaseData(val purchases: List<Int>, val money: Int)
data class PurchaseCheckResult(val money: Int, val sufficientMoney: Boolean, val lastPurchase: Int)

fun main() = print(checkPurchases(getPurchaseData()))

private fun getPurchaseData(): PurchaseData {
    val purchases = mutableListOf<Int>()
    val money: Int

    with(Scanner(System.`in`)) {
        money = nextInt()
        while (hasNextInt()) {
            purchases.add(nextInt())
        }
    }
    return PurchaseData(purchases, money)
}

private fun checkPurchases(purchaseData: PurchaseData): PurchaseCheckResult {
    var money = purchaseData.money
    purchaseData.purchases.forEach {
        if (money - it >= 0) {
            money -= it
        } else {
            return PurchaseCheckResult(money, false, lastPurchase = it)
        }
    }
    return PurchaseCheckResult(money, true, purchaseData.purchases.last())
}

private fun print(checkResult: PurchaseCheckResult) {
    if (checkResult.sufficientMoney) {
        println("Thank you for choosing us to manage your account! You have ${checkResult.money} money.")
    } else {
        println("Error, insufficient funds for the purchase." +
                " You have ${checkResult.money}, but you need ${checkResult.lastPurchase}.")
    }
}
