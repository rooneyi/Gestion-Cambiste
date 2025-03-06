package com.example.gestioncambiste.inter

import java.util.Date

class ReportManagerImpl(private val transactionManager: TransactionManager) : ReportManager {
    override fun generateDailyProfitReport(date: Date): Double {
        val transactions = transactionManager.getTransactionHistory().filter { it.date == date }
        return transactions.sumOf { it.amount }
    }

    override fun generateMonthlyProfitReport(month: Int, year: Int): Double {
        val transactions = transactionManager.getTransactionHistory().filter {
            it.date.month == month && it.date.year == year
        }
        return transactions.sumOf { it.amount }
    }
}