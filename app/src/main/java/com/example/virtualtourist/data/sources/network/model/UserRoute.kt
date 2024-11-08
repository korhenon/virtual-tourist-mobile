package com.example.virtualtourist.data.sources.network.model

data class UserRoute(
    val author: UserAuthor,
    val description: String,
    val id: Int,
    val mean_mark: Double,
    val name: String,
    val photo: Int,
    val price: Int,
    val time: Int
)