package com.example.lordoftherings.network

import com.example.lordoftherings.model.CharacterModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("character")
    fun getCharacters(): Call<CharacterModel>

    @POST("character")
    fun getCharacterDetail(
        id: String
    ): Call<CharacterModel>
}