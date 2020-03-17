package com.example.lordoftherings.model

import com.google.gson.annotations.SerializedName

data class Docs(
    val birth: String,
    val death: String,
    val gender: String,
    val hair: String,
    val height: String,
    @SerializedName("_id")
    val id: String,
    val name: String,
    val race: String,
    val realm: String,
    val spouse: String,
    val wikiUrl: String
)