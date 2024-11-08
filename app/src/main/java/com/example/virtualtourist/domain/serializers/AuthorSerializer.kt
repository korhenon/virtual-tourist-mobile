package com.example.virtualtourist.domain.serializers

import com.example.virtualtourist.data.sources.network.model.UserAuthor
import com.example.virtualtourist.ui.dto.AuthorCompact


fun UserAuthor.toUiDto(): AuthorCompact {
    return AuthorCompact(
        id = this.id,
        name = this.name,
        photo = this.photo.buildPhotoUrl(),
        subscribersInfo = russianDeclension(
            this.subscribers_count,
            WordVariants("пописчик", "подписчика", "подписчиков")
        ),
        isSubscribe = this.is_subscribe
    )
}