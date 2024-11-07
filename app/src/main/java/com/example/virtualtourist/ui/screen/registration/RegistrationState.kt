package com.example.virtualtourist.ui.screen.registration

import com.example.virtualtourist.ui.utils.ConnectionState

data class RegistrationState(
    val connection: ConnectionState = ConnectionState(),
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val error: String = "",
    val isEmailValid: Boolean = true
)
