package com.example.virtualtourist.ui.dto

import com.example.virtualtourist.ui.navigation.destinations.Route

data class RouteCompact(
    val id: Int,
    val author: AuthorCompact,
    val name: String,
    val description: String,
    val time: String,
    val price: String,
    val meanMark: Double,
    val photo: String,
) {
    fun toDestination(): Route {
        return Route(id, author.id)
    }
}