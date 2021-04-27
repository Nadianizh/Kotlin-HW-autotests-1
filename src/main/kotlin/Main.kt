package ru.netology

fun main() {
    transferMoney("vkPay", 10_000, 5_000)
    //   transferMoney("vkPay", 36_000, 5_000)
    transferMoney("MasterCard", 0, 100_000)
    //   transferMoney("Maestro", 50_000, 250)
    //   transferMoney("Mir", 500_000, 150_000)
    //   transferMoney("Visa", 550_000, 20_000)
}

fun transferMoney(card: String, transferredThisMonth: Int, amountToTransfer: Int) {
    if (checkLimits(card, transferredThisMonth, amountToTransfer)) {
        println("превышен лимит по карте $card")
    } else {
        val interest = calculateInterest(card, transferredThisMonth, amountToTransfer)

        println(" перевод $amountToTransfer по карте $card выполнен, размер комиссии $interest ")
    }
}

fun checkLimits(card: String, transferredThisMonth: Int, amountToTransfer: Int): Boolean {
    val dayLimit: Int
    val monthLimit: Int

    if (card == "vkPay") {
        dayLimit = 15_000
        monthLimit = 40_000

    } else {
        dayLimit = 150_000
        monthLimit = 600_000
    }
    return (amountToTransfer > dayLimit || (transferredThisMonth + amountToTransfer) > monthLimit)
}

fun calculateInterest(card: String, transferredThisMonth: Int, amountToTransfer: Int): Int {
    val interest: Int
    when (card) {
        "Maestro", "MasterCard" -> interest =
            if ((amountToTransfer + transferredThisMonth < 75000) && (amountToTransfer + transferredThisMonth > 300))
                0 else (amountToTransfer * 0.006).toInt() + 20

        "Visa", "Mir" -> interest = if (amountToTransfer * 0.0075 < 35) 35 else (amountToTransfer * 0.0075).toInt()

        else -> interest = 0
    }
    return interest
}