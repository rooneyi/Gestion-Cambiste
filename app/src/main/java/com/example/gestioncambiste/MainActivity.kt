package com.example.gestioncambiste

import TransactionViewModel
import TransactionViewModelFactory
import com.example.gestioncambiste.ui.screen.LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gestioncambiste.factory.UserViewModelFactory
import com.example.gestioncambiste.viewmodel.UserViewModel
import com.example.gestioncambiste.ui.theme.GestionCambisteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GestionCambisteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val userViewModel: UserViewModel = viewModel(
                        factory = UserViewModelFactory((application as GestionCambisteApplication).repository)
                    )
                    val transactionViewModel: TransactionViewModel = viewModel(
                        factory = TransactionViewModelFactory((application as GestionCambisteApplication).transactionManager)
                    )

                    LoginScreen(userViewModel = userViewModel,transactionViewModel = transactionViewModel)
                }
            }
        }
    }
}

