package com.example.virtualtourist.data.repository

import com.example.virtualtourist.data.sources.network.RetrofitService
import com.example.virtualtourist.data.sources.network.model.UserRoute
import com.example.virtualtourist.data.sources.network.model.UserRoutesResponse
import com.example.virtualtourist.data.utils.NetworkDataRepository
import javax.inject.Inject

class UserDataRepository @Inject constructor(
    private val api: RetrofitService
) : NetworkDataRepository() {
    suspend fun getRecommendations(token: String): UserRoutesResponse? {
        return safeRequest({
            return@safeRequest api.getRecommendations(token)
        }, UserRoutesResponse::class.java)
    }
}