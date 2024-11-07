package com.example.virtualtourist.data.sources.network.model

data class UserRoute(
    val author: UserAuthor,
    val description: String,
    val id: Int,
    val mean_mark: Double,
    val name: String,
    val photo: Int,
    val price: Int,
    val start_latitude: Double,
    val start_longitude: Double,
    val time: Int
)