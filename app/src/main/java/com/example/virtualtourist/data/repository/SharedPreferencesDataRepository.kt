package com.example.virtualtourist.data.repository

import com.example.virtualtourist.data.sources.local.SharedPreferencesService
import javax.inject.Inject

class SharedPreferencesDataRepository @Inject constructor(
    private val sp: SharedPreferencesService
) {
    val token get() = sp.getToken()

    fun setToken(value: String) {
        sp.putToken(value)
    }

    fun deleteToken() {
        sp.putToken(null)
    }
}