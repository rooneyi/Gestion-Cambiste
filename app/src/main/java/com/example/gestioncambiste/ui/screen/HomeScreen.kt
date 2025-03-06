package com.example.gestioncambiste.ui.screen

import TransactionViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gestioncambiste.data.model.User
import com.example.gestioncambiste.inter.Transaction

@Composable
fun HomeScreen(user: User, transactionViewModel: TransactionViewModel) {
    val transactions = transactionViewModel.getTransactionHistory()
    val totalBalanceUSD = transactionViewModel.getTotalAmount("USD")
    val totalBalanceCDF = transactionViewModel.getTotalAmount("CDF")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Section de bienvenue
        Text(
            text = "Bienvenue, ${user.fullName} !",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Section des soldes
        Text(
            text = "Solde Actuel",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "USD: $totalBalanceUSD",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "CDF: $totalBalanceCDF",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Section des dernières transactions
        Text(
            text = "Dernières Transactions",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        if (transactions.isNotEmpty()) {
            transactions.takeLast(3).forEach { transaction ->
                TransactionItem(transaction = transaction)
                Spacer(modifier = Modifier.height(8.dp))
            }
        } else {
            Text(
                text = "Aucune transaction enregistrée",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Type: ${transaction.type}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Montant: ${transaction.amount} ${transaction.currency}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Client: ${transaction.client}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Date: ${transaction.date}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}