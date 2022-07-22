package com.example.learningapp.data.remote.dto

import com.example.learningapp.domain.model.File
import com.squareup.moshi.Json

data class FileDto(
    @Json(name = "uri") val uri: String,
    @Json(name = "type") val type: String
)

fun FileDto.toFile() : File {
    return File(
        uri = uri,
        type = type
    )
}