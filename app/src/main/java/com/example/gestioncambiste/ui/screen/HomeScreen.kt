package com.example.gestioncambiste.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gestioncambiste.data.model.ExchangeRate
import com.example.gestioncambiste.data.model.User
import com.example.gestioncambiste.viewmodel.ExchangeRateViewModel
import com.example.gestioncambiste.viewmodel.TransactionViewModel

@Composable
fun HomeScreen(
    user: User,
    transactionViewModel: TransactionViewModel,
    exchangeRateViewModel: ExchangeRateViewModel
) {
    var currency by remember { mutableStateOf("") }
    var rate by remember { mutableStateOf("") }
    val exchangeRates by exchangeRateViewModel.exchangeRates.collectAsState()

    Scaffold(
        bottomBar = {
            BottomAppBar {
                Button(
                    onClick = { /* Action transaction */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Effectuer une transaction")
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(text = "Bienvenue, ${user.fullName} !", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(16.dp))

            // Formulaire pour ajouter ou mettre à jour un taux de change
            OutlinedTextField(
                value = currency,
                onValueChange = { currency = it.uppercase() },
                label = { Text("Devise (USD, EUR, ZAR...)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = rate,
                onValueChange = { rate = it },
                label = { Text("Taux de change (CDF)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (currency.isNotBlank() && rate.isNotBlank()) {
                        exchangeRateViewModel.addOrUpdateExchangeRate(currency, rate.toDouble())
                        currency = ""
                        rate = ""
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Enregistrer le taux")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Affichage de l'historique des taux de change
            Text(text = "Historique des Taux de Change :", style = MaterialTheme.typography.titleMedium)

            LazyColumn {
                items(exchangeRates) { exchangeRate ->
                    ExchangeRateItem(exchangeRate)
                }
            }
        }
    }
}

@Composable
fun ExchangeRateItem(exchangeRate: ExchangeRate) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "Devise: ${exchangeRate.currency}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Taux: ${exchangeRate.rate} CDF", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
