package com.example.rickandmortyupdate.ui.fragmetns.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyupdate.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel
    @Inject constructor(val repository: CharacterRepository)
    : ViewModel(){

        fun fetchCharacter() = repository.fetchCharacter().cachedIn(viewModelScope)

}