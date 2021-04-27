package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateInterest_cardMirMinInterest() {
        //arrange
        val testCard = "Mir"
        val testTransferredThisMonth = 0
        val testAmountToTransfer = 1000
        //act
        val interest = calculateInterest(
            card = testCard,
            transferredThisMonth = testTransferredThisMonth,
            amountToTransfer = testAmountToTransfer
        )
// assert
        assertEquals(35, interest)
    }

    @Test
    fun calculateInterest_cardMasterInterest() {
        //arrange
        val testCard = "MasterCard"
        val testTransferredThisMonth = 0
        val testAmountToTransfer = 100000
        //act
        val interest = calculateInterest(
            card = testCard,
            transferredThisMonth = testTransferredThisMonth,
            amountToTransfer = testAmountToTransfer
        )
// assert
        assertEquals(620, interest)
    }

}