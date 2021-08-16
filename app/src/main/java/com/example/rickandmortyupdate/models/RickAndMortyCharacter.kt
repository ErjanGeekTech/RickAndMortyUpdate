package com.example.rickandmortyupdate.models

import com.google.gson.annotations.SerializedName

data class RickAndMortyCharacter(
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("image")
    var image: String,
)