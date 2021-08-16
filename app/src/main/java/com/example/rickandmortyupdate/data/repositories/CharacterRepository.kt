package com.example.rickandmortyupdate.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyupdate.data.network.apiservices.CharacterApiService
import com.example.rickandmortyupdate.data.repositories.pagingsource.CharacterPagingSource
import com.example.rickandmortyupdate.models.RickAndMortyCharacter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(val service: CharacterApiService) {

    fun fetchCharacter(): Flow<PagingData<RickAndMortyCharacter>> {
        return Pager(config = PagingConfig(
            pageSize = 10, enablePlaceholders = false
        ), pagingSourceFactory = {
            CharacterPagingSource(service)
        }).flow
    }

}