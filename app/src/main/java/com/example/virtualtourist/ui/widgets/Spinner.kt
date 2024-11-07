package com.example.virtualtourist.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.virtualtourist.ui.theme.Shading

@Composable
fun Spinner(loading: Boolean) {
    if (loading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Shading),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = colorScheme.primary)
        }
    }
}