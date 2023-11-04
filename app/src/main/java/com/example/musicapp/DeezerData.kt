package com.example.musicapp

data class DeezerData(
    val `data`: List<Data>,
    val next: String,
    val total: Int
)