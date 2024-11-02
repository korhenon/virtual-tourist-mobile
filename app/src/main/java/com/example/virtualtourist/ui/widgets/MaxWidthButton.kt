package com.example.virtualtourist.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.virtualtourist.ui.theme.inter

@Composable
fun MaxWidthButton(
    text: String,
    enabled: Boolean = true,
    color: Color = colorScheme.primary,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = colorScheme.onPrimary,
            disabledContainerColor = colorScheme.primaryContainer,
            disabledContentColor = colorScheme.background
        ),
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(text = text, fontWeight = FontWeight.Medium, fontSize = 20.sp, fontFamily = inter)
    }
}