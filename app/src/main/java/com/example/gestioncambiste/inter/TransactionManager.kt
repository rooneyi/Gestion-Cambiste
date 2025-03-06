package com.example.gestioncambiste.inter

import java.util.Date

interface TransactionManager {

    fun recordTransaction(transaction: Transaction)
    fun calculateConversion(amount: Double, fromCurrency: String, toCurrency: String): Double
    fun getTotalAmount(currency: String): Double
    fun getTransactionHistory(): List<Transaction>

}

data class Transaction(
    val type: TransactionType,
    val amount: Double,
    val currency: String,
    val client: String,
    val date: Date
)

enum class TransactionType {
    BUY, SELL
}