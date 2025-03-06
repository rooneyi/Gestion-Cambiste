package com.example.gestioncambiste.inter

import java.util.Date

interface ExchangeRateManager {
    fun addOrUpdateExchangeRate(currencyPair: String, rate: Double)
    fun getExchangeRate(currencyPair: String): Double?
    fun getExchangeRateHistory(): List<ExchangeRateHistory>
}

data class ExchangeRateHistory(val currencyPair: String, val rate: Double, val date: Date)