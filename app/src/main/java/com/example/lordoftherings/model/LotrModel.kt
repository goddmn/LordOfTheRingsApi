package com.example.lordoftherings.model

data class LotrModel(
    val docs: List<Docs>,
    val pages: Pages,
    val items: Items
)

data class Docs(
    val _id: String,
    val name: String,
    val runtimeInMinutes: Int,
    val budgetInMillions: Int,
    val boxOfficeRevenueInMillions: Int,
    val academyAwardNominations: Int,
    val academyAwardWins: Int
)

data class Pages(
    val current: Int,
    val prev: Int,
    val hasPrev: Boolean,
    val next: Int,
    val hasNext: Boolean,
    val total: Int
)

data class Items(
    val begin: Int,
    val end: Int,
    val total: Int
)