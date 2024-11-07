package com.example.virtualtourist.di

import com.example.virtualtourist.data.sources.network.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkDataSourceProvider {
    @Provides
    fun provideRetrofit(): RetrofitService {
        return RetrofitService.apiService
    }
}