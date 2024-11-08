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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    private fun notAuthorized(navController: NavController) {
        navController.navigate(Login) {
            popUpTo<Home> {
                inclusive = true
            }
        }
    }

    fun refresh(navController: NavController) {
        viewModelScope.launch {
            setLoading(true)
            try {
                state = state.copy(routes = repository.getRecommendations())
            } catch (_: NotAuthorized) {
                notAuthorized(navController)
            } catch (_: NoInternet) {
                setNoInternet(true)
            }
            setLoading(false)
        }
    }

    fun toggleSubscription(navController: NavController, id: Int, value: Boolean) {
        viewModelScope.launch {
            try {
                repository.toggleSubscription(id, value)
                withContext(Dispatchers.IO) {
                    state = state.copy(routes = state.routes.map {
                        if (it.author.id == id) it.copy(author = it.author.copy(isSubscribe = !value))
                        else it
                    })
                }
            } catch (_: NotAuthorized) {
                notAuthorized(navController)
            } catch (_: NoInternet) {
                setNoInternet(true)
            }
        }
    }

}