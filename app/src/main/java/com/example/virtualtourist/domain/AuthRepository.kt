package com.example.virtualtourist.domain

import com.example.virtualtourist.data.repository.AuthDataRepository
import com.example.virtualtourist.data.repository.SharedPreferencesDataRepository
import com.example.virtualtourist.domain.exceptions.BadRequest
import com.example.virtualtourist.domain.exceptions.EmailIsNotValid
import com.example.virtualtourist.domain.exceptions.NoInternet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val data: AuthDataRepository,
    private val sp: SharedPreferencesDataRepository
) {
    private fun validateEmail(email: String): Boolean {
        return email.matches(Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$"))
    }

    suspend fun hasToken(): Boolean {
        return withContext(Dispatchers.IO) {
            return@withContext sp.token != null
        }
    }

    suspend fun registration(name: String, email: String, password: String) {
        withContext(Dispatchers.IO) {
            if (validateEmail(email)) {
                val response = data.registration(name, email, password) ?: throw NoInternet()
                if (response.token != null) {
                    sp.setToken(response.token)
                } else throw BadRequest(response.message)
            } else throw EmailIsNotValid()
        }
    }

    suspend fun login(email: String, password: String) {
        withContext(Dispatchers.IO) {
            if (validateEmail(email)) {
                val response = data.login(email, password) ?: throw NoInternet()
                if (response.token != null) {
                    sp.setToken(response.token)
                } else throw BadRequest(response.message)
            } else throw EmailIsNotValid()
        }
    }
}