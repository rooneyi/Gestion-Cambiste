package com.example.gestioncambiste.inter

import java.util.Date

class ExchangeRateManagerImpl : ExchangeRateManager {
    private val exchangeRates = mutableMapOf<String, Double>()
    private val exchangeRateHistory = mutableListOf<ExchangeRateHistory>()

    override fun addOrUpdateExchangeRate(currencyPair: String, rate: Double) {
        exchangeRates[currencyPair] = rate
        exchangeRateHistory.add(ExchangeRateHistory(currencyPair, rate, Date()))
    }

    override fun getExchangeRate(currencyPair: String): Double? {
        return exchangeRates[currencyPair]
    }

    override fun getExchangeRateHistory(): List<ExchangeRateHistory> {
        return exchangeRateHistory.toList()
    }
}