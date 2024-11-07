package com.example.virtualtourist.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.virtualtourist.ui.theme.inter

@Composable
fun SingleLineTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    placeholder: String = "",
    isError: Boolean = false,
    isPassword: Boolean = false,
    label: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions()
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        colors = OutlinedTextFieldDefaults.colors(
            focusedPlaceholderColor = colorScheme.onSurface,
            unfocusedPlaceholderColor = colorScheme.onSurface,
            unfocusedTextColor = colorScheme.onBackground,
            focusedTextColor = colorScheme.onBackground,
            errorBorderColor = colorScheme.error,
            errorContainerColor = colorScheme.errorContainer,
            errorTextColor = colorScheme.onBackground,
            errorLabelColor = colorScheme.error,
            focusedBorderColor = colorScheme.primary,
            cursorColor = colorScheme.primary,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = colorScheme.surface,
            unfocusedContainerColor = colorScheme.surface
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        shape = RoundedCornerShape(12.dp),
        textStyle = TextStyle(fontWeight = FontWeight.Medium, fontFamily = inter),
        placeholder = { Text(text = placeholder) },
        isError = isError,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        singleLine = true,
        trailingIcon = trailingIcon,
        keyboardOptions = keyboardOptions,
        label = label
    )
}