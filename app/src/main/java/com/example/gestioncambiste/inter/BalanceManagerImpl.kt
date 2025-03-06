package com.example.gestioncambiste.inter

class BalanceManagerImpl(private val transactionManager: TransactionManager) : BalanceManager {
    override fun getCurrentBalance(currency: String): Double {
        return transactionManager.getTotalAmount(currency)
    }

    override fun getTransactionHistory(): List<Transaction> {
        return transactionManager.getTransactionHistory()
    }
}