package com.example.virtualtourist.domain.serializers

import com.example.virtualtourist.data.utils.BASE_URL

fun Int?.buildPhotoUrl(): String {
    return "$BASE_URL/files/photos/${this}"
}