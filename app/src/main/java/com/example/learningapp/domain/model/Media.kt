package com.example.learningapp.domain.model

data class Media(
    val url: String,
    val originalUrl: String,
    val thumbnailUrl: String,
    val fileType: String,
    val fileSize: Int
)
