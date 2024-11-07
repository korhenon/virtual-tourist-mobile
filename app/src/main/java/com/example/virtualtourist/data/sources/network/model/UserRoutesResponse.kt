package com.example.virtualtourist.data.sources.network.model

data class UserRoutesResponse(
    val message: String,
    val routes: List<UserRoute>
)