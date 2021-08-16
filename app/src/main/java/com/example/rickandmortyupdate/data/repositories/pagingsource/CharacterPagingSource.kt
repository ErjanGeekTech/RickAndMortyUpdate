package com.example.rickandmortyupdate.data.repositories.pagingsource

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyupdate.data.network.apiservices.CharacterApiService
import com.example.rickandmortyupdate.models.RickAndMortyCharacter
import retrofit2.HttpException
import java.io.IOException

private const val PIXABAY_STARTING_PAGE_INDEX = 1

class CharacterPagingSource(
    private val service: CharacterApiService
) : PagingSource<Int, RickAndMortyCharacter>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickAndMortyCharacter> {
        val position = params.key ?: PIXABAY_STARTING_PAGE_INDEX
        return try {
            val response = service.fetchCharacter(position)
            val next = response.info.next
            val nextPageNumber = if (next == null) {
                null
            } else {
                Uri.parse(response.info.next).getQueryParameter("page")!!.toInt()
            }
            LoadResult.Page(
                data = response.result,
                prevKey = null,
                nextKey = nextPageNumber
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RickAndMortyCharacter>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
