package com.example.virtualtourist.ui.screen.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    fun updateEmail(value: String) {
        state = state.copy(email = value)
    }
    fun updatePassword(value: String) {
        state = state.copy(password = value)
    }
}