package com.example.learningapp.data.remote.dto

import com.example.learningapp.domain.model.Media
import com.squareup.moshi.Json

data class MediaDto(
    @Json(name = "url") val url: String,
    @Json(name = "originalUrl") val originalUrl: String,
    @Json(name = "thumbnailUrl") val thumbnailUrl: String,
    @Json(name = "fileType") val fileType: String,
    @Json(name = "fileSize") val fileSize: Int
)

fun MediaDto.toMedia() : Media {
    return Media(
        url = url,
        originalUrl = originalUrl,
        thumbnailUrl = thumbnailUrl,
        fileType = fileType,
        fileSize = fileSize
    )
}