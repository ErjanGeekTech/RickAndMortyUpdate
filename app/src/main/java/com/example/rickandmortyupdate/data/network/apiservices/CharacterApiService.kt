package com.example.rickandmortyupdate.data.network.apiservices

import com.example.rickandmortyupdate.models.RickAndMortyCharacter
import com.example.rickandmortyupdate.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
    suspend fun fetchCharacter(
        @Query("page") page: Int
    ): RickAndMortyResponse<RickAndMortyCharacter>

}