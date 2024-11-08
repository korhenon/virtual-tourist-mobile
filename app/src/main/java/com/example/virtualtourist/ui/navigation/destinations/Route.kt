package com.example.virtualtourist.ui.navigation.destinations

import com.example.virtualtourist.ui.dto.AuthorCompact
import kotlinx.serialization.Serializable

@Serializable
data class Route(
    val id: Int,
    val authorId: Int,
)
