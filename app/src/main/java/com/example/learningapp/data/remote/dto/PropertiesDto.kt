package com.example.learningapp.data.remote.dto

import com.example.learningapp.domain.model.Properties
import com.squareup.moshi.Json

data class PropertiesDto(
    @Json(name = "files") val files: List<FileDto>
)

fun PropertiesDto.toProperties() : Properties {
    return Properties(
        files = files.map { it.toFile() }
    )
}