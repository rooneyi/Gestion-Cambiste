package com.example.gestioncambiste.navigation

import TransactionScreen
import com.example.gestioncambiste.viewmodel.TransactionViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gestioncambiste.ui.screen.SplashScreen
import com.example.gestioncambiste.ui.screen.LoginScreen
import com.example.gestioncambiste.ui.screen.SignUpScreen
import com.example.gestioncambiste.ui.screen.HomeScreen
import com.example.gestioncambiste.viewmodel.UserViewModel
import androidx.compose.runtime.*


import com.example.gestioncambiste.viewmodel.ExchangeRateViewModel

@Composable
fun NavigationGraph(
    userViewModel: UserViewModel,
    transactionViewModel: TransactionViewModel,
    exchangeRateViewModel: ExchangeRateViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen() }
        composable("login") { LoginScreen(userViewModel, transactionViewModel,exchangeRateViewModel) }
        composable("signup") { SignUpScreen(userViewModel, { navController.navigate("login") }) }
        composable("home") { backStackEntry ->
            val userEmail = backStackEntry.arguments?.getString("user")
            userEmail?.let { email ->
                var user by remember { mutableStateOf<com.example.gestioncambiste.data.model.User?>(null) }

                LaunchedEffect(email) {
                    userViewModel.getUserByEmail(email) { fetchedUser ->
                        user = fetchedUser
                    }
                }

                user?.let {
                    HomeScreen(it, transactionViewModel, exchangeRateViewModel)
                }
            }
        }
        composable("transactions") { TransactionScreen(transactionViewModel) }
    }
}

