package com.example.virtualtourist.ui.screen.home

import com.example.virtualtourist.data.sources.network.model.UserRoute
import com.example.virtualtourist.ui.utils.ConnectionState

data class HomeState(
    val connection: ConnectionState = ConnectionState(),
    val routes: List<UserRoute> = listOf()
)
