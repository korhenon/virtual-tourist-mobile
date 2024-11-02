package com.example.virtualtourist.ui.screen.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor() : ViewModel() {
    var state by mutableStateOf(RegistrationState())
        private set

    val canRegister get() = state.name.isNotEmpty() && state.email.isNotEmpty() && state.password.isNotEmpty()

    fun updateName(value: String) {
        state = state.copy(name = value)
    }

    fun updateEmail(value: String) {
        state = state.copy(email = value)
    }

    fun updatePassword(value: String) {
        state = state.copy(password = value)
    }

}