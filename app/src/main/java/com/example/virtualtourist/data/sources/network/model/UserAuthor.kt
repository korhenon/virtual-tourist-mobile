package com.example.virtualtourist.data.sources.network.model

data class UserAuthor(
    val id: Int,
    val is_subscribe: Boolean,
    val name: String,
    val photo: Int?,
    val subscribers_count: Int
)