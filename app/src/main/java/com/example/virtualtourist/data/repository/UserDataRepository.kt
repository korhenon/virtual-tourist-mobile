package com.example.virtualtourist.data.repository

import com.example.virtualtourist.data.sources.network.RetrofitService
import com.example.virtualtourist.data.sources.network.model.MessageResponse
import com.example.virtualtourist.data.sources.network.model.SubscribeBody
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

    suspend fun subscribe(token: String, authorId: Int): MessageResponse? {
        return safeRequest({
            return@safeRequest api.subscribe(token, SubscribeBody(authorId))
        }, MessageResponse::class.java)
    }

    suspend fun unsubscribe(token: String, authorId: Int): MessageResponse? {
        return safeRequest({
            return@safeRequest api.unsubscribe(token, SubscribeBody(authorId))
        }, MessageResponse::class.java)
    }
}