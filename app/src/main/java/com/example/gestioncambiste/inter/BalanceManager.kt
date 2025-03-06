package com.example.gestioncambiste.inter


interface BalanceManager {
    fun getCurrentBalance(currency: String): Double
    fun getTransactionHistory(): List<Transaction>
}