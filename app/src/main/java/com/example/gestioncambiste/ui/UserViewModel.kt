package com.example.gestioncambiste.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }

    fun loginUser(email: String, password: String, onSuccess: (User) -> Unit, onFailure: () -> Unit) {
        viewModelScope.launch {
            val user = userRepository.getUser(email, password)
            if (user != null) {
                onSuccess(user)
            } else {
                onFailure()
            }
        }
    }

    fun checkEmailExists(email: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val user = userRepository.getUserByEmail(email)
            onResult(user != null)
        }
    }
}