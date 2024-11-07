package com.example.virtualtourist.ui.utils

import com.example.virtualtourist.data.sources.network.model.UserAuthor
import com.example.virtualtourist.data.sources.network.model.UserRoute
import com.example.virtualtourist.data.utils.BASE_URL

fun UserRoute.buildPhotoUrl(): String {
    return "$BASE_URL/files/photos/${this.photo}"
}

fun UserAuthor.buildPhotoUrl(): String {
    return "$BASE_URL/files/photos/${this.photo}"
}
