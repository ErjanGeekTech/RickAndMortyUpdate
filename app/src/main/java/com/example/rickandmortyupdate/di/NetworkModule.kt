package com.example.rickandmortyupdate.di

import com.example.rickandmortyupdate.data.network.RetrofitClient
import com.example.rickandmortyupdate.data.network.apiservices.CharacterApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    val retrofit = RetrofitClient()

    @Singleton
    @Provides
    fun provideCharacterApiService(): CharacterApiService{
        return retrofit.provideCharacterApiService()
    }

}