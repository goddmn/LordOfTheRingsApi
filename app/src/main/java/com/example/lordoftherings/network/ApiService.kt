package com.example.lordoftherings.network

import com.example.lordoftherings.model.CharacterModel
import com.example.lordoftherings.model.LotrModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("movie")
    fun getMovie(): Call<LotrModel>

    @GET("character")
    fun getCharacters(): Call<CharacterModel>
}