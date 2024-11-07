package com.example.virtualtourist.ui.widgets

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EmailField(
    value: String,
    onValueChanged: (String) -> Unit,
    isEmailValid: Boolean
) {
    SingleLineTextField(
        value = value,
        onValueChanged = onValueChanged,
        placeholder = "Почта",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        isError = !isEmailValid
    )
}