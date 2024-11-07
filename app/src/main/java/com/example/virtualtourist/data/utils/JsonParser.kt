package com.example.virtualtourist.data.utils

import com.google.gson.Gson
import retrofit2.Response

fun <T> Response<*>.parseBody(cls: Class<T>): T? {
    val json = this.errorBody()?.string() ?: return null
    return Gson().fromJson(json, cls)
}