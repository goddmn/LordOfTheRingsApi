package com.example.lordoftherings.model

data class Pages(
    val current: Int,
    val prev: Int,
    val hasPrev: Boolean,
    val next: Int,
    val hasNext: Boolean,
    val total: Int
)
