package com.example.virtualtourist.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.virtualtourist.R
import com.example.virtualtourist.ui.navigation.destinations.Login
import com.example.virtualtourist.ui.navigation.destinations.Onboarding
import com.example.virtualtourist.ui.navigation.destinations.Registration
import com.example.virtualtourist.ui.theme.inter
import com.example.virtualtourist.ui.widgets.MaxWidthButton

@Composable
fun OnboardingScreen(navController: NavController) {
    val loginLink = LinkAnnotation.Clickable("login", linkInteractionListener = {
        navController.navigate(Login) {
            popUpTo<Onboarding> {
                inclusive = true
            }
        }
    })
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboard_image),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Долго откладывали путешествие мечты? Отправьтесь в него прямо сейчас!",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                fontFamily = inter
            )
        }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            MaxWidthButton(text = "Создать аккаунт") {
                navController.navigate(Registration) {
                    popUpTo<Onboarding> {
                        inclusive = true
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = buildAnnotatedString {
                    append("Уже есть аккаунт? ")
                    withLink(loginLink) {
                        withStyle(SpanStyle(color = MaterialTheme.colorScheme.secondary)) {
                            append("Войти")
                        }
                    }
                },
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontFamily = inter
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}