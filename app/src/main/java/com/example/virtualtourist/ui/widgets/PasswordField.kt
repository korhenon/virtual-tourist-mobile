package com.example.virtualtourist.ui.widgets

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.virtualtourist.R

@Composable
fun PasswordField(
    value: String,
    onValueChanged: (String) -> Unit
) {
    var isPassword by remember { mutableStateOf(true) }
    val icon = @Composable {
        IconButton(onClick = { isPassword = !isPassword }) {
            Icon(
                painter = painterResource(id = if (isPassword) R.drawable.visibility else R.drawable.visibility_off),
                contentDescription = ""
            )
        }
    }
    SingleLineTextField(
        value = value,
        onValueChanged = onValueChanged,
        trailingIcon = if (value.isNotEmpty()) icon else null,
        isPassword = isPassword,
        placeholder = "Пароль",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}