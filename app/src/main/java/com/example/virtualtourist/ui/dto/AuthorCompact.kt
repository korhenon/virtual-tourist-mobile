package com.example.virtualtourist.ui.dto

import kotlinx.serialization.Serializable

@Serializable
data class AuthorCompact(
    val id: Int,
    val isSubscribe: Boolean,
    val name: String,
    val photo: String,
    val subscribersInfo: String
)
