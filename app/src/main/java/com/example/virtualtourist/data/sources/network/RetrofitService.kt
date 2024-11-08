package com.example.virtualtourist.data.sources.network

import com.example.virtualtourist.data.sources.network.model.LoginBody
import com.example.virtualtourist.data.sources.network.model.MessageResponse
import com.example.virtualtourist.data.sources.network.model.RegistrationBody
import com.example.virtualtourist.data.sources.network.model.SubscribeBody
import com.example.virtualtourist.data.sources.network.model.TokenResponse
import com.example.virtualtourist.data.sources.network.model.UserRoutesResponse
import com.example.virtualtourist.data.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface RetrofitService {
    companion object {
        val apiService: RetrofitService by lazy {
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .client(
                    OkHttpClient.Builder().readTimeout(3, TimeUnit.MINUTES)
                        .connectTimeout(3, TimeUnit.MINUTES).build()
                ).build().create(RetrofitService::class.java)
        }
    }

    @POST("/auth/registration")
    suspend fun registration(@Body body: RegistrationBody): TokenResponse

    @POST("/auth/login")
    suspend fun login(@Body body: LoginBody): TokenResponse

    @GET("/user/recommendations")
    suspend fun getRecommendations(@Header("token") token: String): UserRoutesResponse

    @POST("/user/subscribe")
    suspend fun subscribe(@Header("token") token: String, @Body body: SubscribeBody): MessageResponse

    @POST("/user/unsubscribe")
    suspend fun unsubscribe(@Header("token") token: String, @Body body: SubscribeBody): MessageResponse
}