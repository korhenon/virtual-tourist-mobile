package com.example.virtualtourist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.virtualtourist.ui.navigation.destinations.Login
import com.example.virtualtourist.ui.navigation.destinations.Onboarding
import com.example.virtualtourist.ui.navigation.destinations.Registration
import com.example.virtualtourist.ui.navigation.destinations.Splash
import com.example.virtualtourist.ui.screen.login.LoginScreen
import com.example.virtualtourist.ui.screen.onboarding.OnboardingScreen
import com.example.virtualtourist.ui.screen.registration.RegistrationScreen
import com.example.virtualtourist.ui.screen.splash.SplashScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Splash, modifier = modifier) {
        composable<Splash> { SplashScreen(navController = navController) }
        composable<Onboarding> { OnboardingScreen(navController = navController) }
        composable<Registration> { RegistrationScreen(navController = navController) }
        composable<Login> { LoginScreen(navController = navController) }
    }
}