package com.example.virtualtourist.ui.screen.home

import com.example.virtualtourist.ui.dto.RouteCompact
import com.example.virtualtourist.ui.utils.ConnectionState

data class HomeState(
    val connection: ConnectionState = ConnectionState(),
    val routes: List<RouteCompact> = listOf()
)
