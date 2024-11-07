package com.example.virtualtourist.ui.screen.login

import com.example.virtualtourist.ui.utils.ConnectionState

data class LoginState(
    val connection: ConnectionState = ConnectionState(),
    val email: String = "",
    val password: String = "",
    val isEmailValid: Boolean = true,
    val error: String = ""
)
