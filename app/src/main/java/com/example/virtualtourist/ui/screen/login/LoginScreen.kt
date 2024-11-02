package com.example.virtualtourist.ui.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.virtualtourist.ui.navigation.destinations.Login
import com.example.virtualtourist.ui.navigation.destinations.Registration
import com.example.virtualtourist.ui.theme.inter
import com.example.virtualtourist.ui.widgets.MaxWidthButton
import com.example.virtualtourist.ui.widgets.PasswordTextField
import com.example.virtualtourist.ui.widgets.SingleLineTextField

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {
    val registrationLink = LinkAnnotation.Clickable("registration", linkInteractionListener = {
        navController.navigate(Registration) {
            popUpTo<Login> {
                inclusive = true
            }
        }
    })
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(120.dp))
            Text(
                text = "Вход",
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(80.dp))
            SingleLineTextField(
                value = viewModel.state.email,
                onValueChanged = viewModel::updateEmail,
                placeholder = "Почта"
            )
            Spacer(modifier = Modifier.height(32.dp))
            PasswordTextField(
                value = viewModel.state.password,
                onValueChanged = viewModel::updatePassword
            )
        }
        Column {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                MaxWidthButton(text = "Войти") {

                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = buildAnnotatedString {
                        append("Нет аккаунта? ")
                        withLink(registrationLink) {
                            withStyle(SpanStyle(color = colorScheme.secondary)) {
                                append("Создайте его")
                            }
                        }
                    },
                    fontWeight = FontWeight.Medium,
                    color = colorScheme.onBackground,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = inter
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}