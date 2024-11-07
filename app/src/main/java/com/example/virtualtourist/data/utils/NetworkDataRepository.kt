package com.example.virtualtourist.data.utils

import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class NetworkDataRepository {
    protected suspend fun <T> safeRequest(method: suspend () -> T?, cls: Class<T>): T? {
        return try {
            method()
        } catch (e: HttpException) {
            e.response()?.parseBody(cls)
        } catch (_: UnknownHostException) {
            null
        } catch (_: SocketTimeoutException) {
            null
        }
    }
}