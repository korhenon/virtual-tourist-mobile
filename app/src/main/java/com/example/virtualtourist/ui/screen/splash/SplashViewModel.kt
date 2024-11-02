package com.example.virtualtourist.ui.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.virtualtourist.ui.navigation.destinations.Onboarding
import com.example.virtualtourist.ui.navigation.destinations.Splash
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    fun navigate(navController: NavController) {
        viewModelScope.launch {
            navController.navigate(Onboarding) {
                popUpTo<Splash> {
                    inclusive = true
                }
            }
        }
    }
}