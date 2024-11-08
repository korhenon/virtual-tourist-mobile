package com.example.virtualtourist.domain

import com.example.virtualtourist.data.repository.SharedPreferencesDataRepository
import com.example.virtualtourist.data.repository.UserDataRepository
import com.example.virtualtourist.data.sources.network.model.UserRoute
import com.example.virtualtourist.domain.exceptions.NoInternet
import com.example.virtualtourist.domain.exceptions.NotAuthorized
import com.example.virtualtourist.domain.serializers.toUiDto
import com.example.virtualtourist.ui.dto.RouteCompact
import com.example.virtualtourist.ui.navigation.destinations.Route
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(
    val data: UserDataRepository,
    val sp: SharedPreferencesDataRepository
) {
    suspend fun getRecommendations(): List<RouteCompact> {
        return withContext(Dispatchers.IO) {
            val token = sp.token ?: throw NotAuthorized()
            val response = data.getRecommendations(token) ?: throw NoInternet()
            return@withContext response.routes.map { it.toUiDto() }
        }
    }

    suspend fun toggleSubscription(authorId: Int, isSubscribed: Boolean) {
        return withContext(Dispatchers.IO) {
            val token = sp.token ?: throw NotAuthorized()
            if (!isSubscribed) data.subscribe(token, authorId) ?: throw NoInternet()
            else data.unsubscribe(token, authorId) ?: throw NoInternet()
        }
    }
}