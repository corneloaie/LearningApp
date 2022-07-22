package com.example.learningapp.data.remote.dto

import com.example.learningapp.domain.model.Attribute
import com.squareup.moshi.Json

data class AttributeDto(
    @Json(name = "trait_type") val traitType: String,
    @Json(name = "value") val value: String
)

fun AttributeDto.toAttribute() : Attribute {
    return Attribute(
        traitType = traitType,
        value = value
    )
}