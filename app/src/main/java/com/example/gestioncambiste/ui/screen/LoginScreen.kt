package com.example.gestioncambiste.ui.screen

import com.example.gestioncambiste.viewmodel.TransactionViewModel
import android.annotation.SuppressLint
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.gestioncambiste.data.model.User
import com.example.gestioncambiste.viewmodel.ExchangeRateViewModel
import com.example.gestioncambiste.viewmodel.UserViewModel

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun LoginScreen(userViewModel: UserViewModel, transactionViewModel: TransactionViewModel,exchangeRateViewModel: ExchangeRateViewModel) {
    var showSignUp by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var loggedInUser by remember { mutableStateOf<User?>(null) }

    if (loggedInUser != null) {
        HomeScreen(user = loggedInUser!!, transactionViewModel = transactionViewModel, exchangeRateViewModel = exchangeRateViewModel)
    } else if (showSignUp) {
        SignUpScreen(
            userViewModel = userViewModel,
            onNavigateToLogin = { showSignUp = false }
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Connexion",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Mot de passe") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    userViewModel.loginUser(
                        email = email,
                        password = password,
                        onSuccess = { user ->
                            loggedInUser = user
                        },
                        onFailure = {
                            errorMessage = "Email ou mot de passe incorrect."
                        }
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Se connecter")
            }
            Spacer(modifier = Modifier.height(16.dp))

            ClickableText(
                text = AnnotatedString("Pas de compte ? Inscrivez-vous"),
                onClick = { showSignUp = true },
                style = MaterialTheme.typography.bodyMedium.copy(
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colorScheme.primary
                )
            )

            errorMessage?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}
