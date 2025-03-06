package com.example.gestioncambiste.inter

class TransactionManagerImpl(private val exchangeRateManager: ExchangeRateManager) :
    TransactionManager {
    private val transactions = mutableListOf<Transaction>()

    override fun recordTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    override fun calculateConversion(amount: Double, fromCurrency: String, toCurrency: String): Double {
        val rate = exchangeRateManager.getExchangeRate("$fromCurrency/$toCurrency")
        return rate?.let { amount * it } ?: throw IllegalArgumentException("Taux de change non trouvé")
    }

    override fun getTotalAmount(currency: String): Double {
        return transactions.filter { it.currency == currency }.sumOf { it.amount }
    }

    // Implémentation de la méthode getTransactionHistory
    override fun getTransactionHistory(): List<Transaction> {
        return transactions.toList() // Retourne une copie de la liste des transactions
    }
}