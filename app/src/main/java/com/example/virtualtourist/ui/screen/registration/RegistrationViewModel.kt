package com.example.virtualtourist.ui.screen.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.virtualtourist.domain.AuthRepository
import com.example.virtualtourist.domain.exceptions.BadRequest
import com.example.virtualtourist.domain.exceptions.EmailIsNotValid
import com.example.virtualtourist.domain.exceptions.NoInternet
import com.example.virtualtourist.ui.navigation.destinations.Home
import com.example.virtualtourist.ui.navigation.destinations.Login
import com.example.virtualtourist.ui.navigation.destinations.Registration
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    var state by mutableStateOf(RegistrationState())
        private set

    val canRegister get() = state.name.isNotEmpty() && state.email.isNotEmpty() && state.password.isNotEmpty() && state.isEmailValid

    fun updateName(value: String) {
        state = state.copy(name = value)
    }

    fun updateEmail(value: String) {
        state = state.copy(email = value, isEmailValid = true)
    }

    fun updatePassword(value: String) {
        state = state.copy(password = value)
    }

    private fun setLoading(value: Boolean) {
        state = state.copy(connection = state.connection.copy(loading = value))
    }

    private fun setNoInternet(value: Boolean) {
        state = state.copy(connection = state.connection.copy(noInternet = value))
    }

    fun closeNoInternet() {
        setNoInternet(false)
    }

    fun registration(navController: NavController) {
        viewModelScope.launch {
            setLoading(true)
            try {
                repository.registration(state.name, state.email, state.password)
                navController.navigate(Home) {
                    popUpTo<Registration> {
                        inclusive = true
                    }
                }
            } catch (_: EmailIsNotValid) {
                state = state.copy(isEmailValid = false)
            } catch (e: BadRequest) {
                state = state.copy(error = e.message ?: "")
            } catch (_: NoInternet) {
                setNoInternet(true)
            }
            setLoading(false)
        }
    }

}