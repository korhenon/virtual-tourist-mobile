package com.example.virtualtourist.domain.serializers

import com.example.virtualtourist.data.sources.network.model.UserRoute
import com.example.virtualtourist.ui.dto.RouteCompact

fun UserRoute.toUiDto(): RouteCompact {
    return RouteCompact(
        id = this.id,
        author = this.author.toUiDto(),
        name = this.name,
        description = this.description,
        time = this.time.timeString(),
        price = "${this.price} ₽",
        meanMark = this.mean_mark,
        photo = this.photo.buildPhotoUrl()
    )
}