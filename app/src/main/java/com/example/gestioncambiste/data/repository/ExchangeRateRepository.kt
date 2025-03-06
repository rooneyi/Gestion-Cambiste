package com.example.gestioncambiste.data.repository

import com.example.gestioncambiste.data.model.ExchangeRate

class ExchangeRateRepository {
    private val exchangeRates = mutableListOf<ExchangeRate>()

    fun addOrUpdateExchangeRate(currency: String, rate: Double) {
        val existingRate = exchangeRates.find { it.currency == currency }
        if (existingRate != null) {
            exchangeRates.remove(existingRate)
        }
        exchangeRates.add(ExchangeRate(currency, rate))
    }

    fun getExchangeRates(): List<ExchangeRate> {
        return exchangeRates
    }
}
