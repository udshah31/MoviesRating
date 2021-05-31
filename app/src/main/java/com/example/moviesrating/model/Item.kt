package com.example.moviesrating.model

data class Item(
    val id: Int,
    val title: String,
    val subTitle: String,
    val imageId: Int,
    val source: String = "demo source"
)
