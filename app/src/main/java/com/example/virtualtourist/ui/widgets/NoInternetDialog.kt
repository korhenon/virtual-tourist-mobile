package com.example.virtualtourist.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun NoInternetDialog(noInternet: Boolean, closeDialog: () -> Unit) {
    if (noInternet) {
        AlertDialog(
            onDismissRequest = closeDialog,
            confirmButton = {
                Text(
                    text = "Хорошо",
                    modifier = Modifier.clickable { closeDialog() })
            },
            containerColor = colorScheme.background,
            textContentColor = colorScheme.onBackground,
            titleContentColor = colorScheme.onBackground,
            text = {
                Text(
                    text = "У вас отсутвует подключение к интернету или у нас проблемы с сервером, попробуйте повторить позже",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            title = {
                Text(
                    text = "Похоже вы вне сети",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
        )
    }
}