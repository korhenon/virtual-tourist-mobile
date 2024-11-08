package com.example.virtualtourist.ui.widgets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class SubscribeButtonCompactVariant {
    Primary, Secondary
}

@Composable
fun SubscribeButtonCompact(
    isSubscribed: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: SubscribeButtonCompactVariant = SubscribeButtonCompactVariant.Primary,
) {
    if (!isSubscribed) {
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = when (variant) {
                    SubscribeButtonCompactVariant.Primary -> colorScheme.primary
                    SubscribeButtonCompactVariant.Secondary -> colorScheme.tertiary
                },
                contentColor = colorScheme.background
            ),
            modifier = modifier.defaultMinSize(1.dp, 1.dp)
        ) {
            Text(text = "Подписаться", fontSize = 14.sp, lineHeight = 14.sp)
        }
    } else {
        OutlinedButton(
            onClick = onClick,
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = colorScheme.onSurface,
                contentColor = colorScheme.onSecondaryContainer
            ),
            modifier = Modifier.defaultMinSize(1.dp, 1.dp)
        ) {
            Text(text = "Отписаться", fontSize = 14.sp, lineHeight = 14.sp)
        }
    }
}