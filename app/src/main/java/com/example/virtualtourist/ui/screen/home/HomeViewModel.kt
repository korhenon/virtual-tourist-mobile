package com.example.virtualtourist.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.virtualtourist.domain.UserRepository
import com.example.virtualtourist.domain.exceptions.NoInternet
import com.example.virtualtourist.domain.exceptions.NotAuthorized
import com.example.virtualtourist.ui.navigation.destinations.Home
import com.example.virtualtourist.ui.navigation.destinations.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
    var state by mutableStateOf(HomeState())

    private fun setLoading(value: Boolean) {
        state = state.copy(connection = state.connection.copy(loading = value))
    }

    private fun setNoInternet(value: Boolean) {
        state = state.copy(connection = state.connection.copy(noInternet = value))
    }

    fun closeNoInternet() {
        setNoInternet(false)
    }

    fun init(navController: NavController) {
        refresh(navController)
    }

    fun refresh(navController: NavController) {
        viewModelScope.launch {
            setLoading(true)
            try {
                state = state.copy(routes = repository.getRecommendations())
            } catch (_: NotAuthorized) {
                navController.navigate(Login) {
                    popUpTo<Home> {
                        inclusive = true
                    }
                }
            } catch (_: NoInternet) {
                setNoInternet(true)
            }
            setLoading(false)
        }
    }

}