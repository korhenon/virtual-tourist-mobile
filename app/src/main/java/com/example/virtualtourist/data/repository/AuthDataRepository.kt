package com.example.virtualtourist.data.repository

import com.example.virtualtourist.data.sources.network.RetrofitService
import com.example.virtualtourist.data.sources.network.model.LoginBody
import com.example.virtualtourist.data.sources.network.model.RegistrationBody
import com.example.virtualtourist.data.sources.network.model.TokenResponse
import com.example.virtualtourist.data.utils.NetworkDataRepository
import com.example.virtualtourist.data.utils.parseBody
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class AuthDataRepository @Inject constructor(
    private val api: RetrofitService
) : NetworkDataRepository() {
    suspend fun registration(name: String, email: String, password: String): TokenResponse? {
        return safeRequest({
            return@safeRequest api.registration(RegistrationBody(name, email, password))
        }, TokenResponse::class.java)
    }

    suspend fun login(email: String, password: String): TokenResponse? {
        return safeRequest({
            return@safeRequest api.login(LoginBody(email, password))
        }, TokenResponse::class.java)
    }
}