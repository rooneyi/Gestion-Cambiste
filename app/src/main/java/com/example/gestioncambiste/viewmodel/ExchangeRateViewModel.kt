package com.example.gestioncambiste.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gestioncambiste.data.model.ExchangeRate
import com.example.gestioncambiste.data.repository.ExchangeRateRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ExchangeRateViewModel(private val repository: ExchangeRateRepository) : ViewModel() {

    private val _exchangeRates = MutableStateFlow<List<ExchangeRate>>(emptyList())
    val exchangeRates = _exchangeRates.asStateFlow()

    init {
        loadExchangeRates()
    }

    fun addOrUpdateExchangeRate(currency: String, rate: Double) {
        viewModelScope.launch {
            repository.addOrUpdateExchangeRate(currency, rate)
            loadExchangeRates()
        }
    }

    private fun loadExchangeRates() {
        viewModelScope.launch {
            _exchangeRates.value = repository.getExchangeRates()
        }
    }
}
