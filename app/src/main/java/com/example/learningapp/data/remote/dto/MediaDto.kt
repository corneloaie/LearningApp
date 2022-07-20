package com.example.learningapp.data.remote.dto

data class MediaDto(
    val url: String,
    val originalUrl: String,
    val thumbnailUrl: String,
    val fileType: String,
    val fileSize: Int
)