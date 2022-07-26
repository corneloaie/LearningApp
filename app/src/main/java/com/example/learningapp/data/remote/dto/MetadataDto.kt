package com.example.learningapp.data.remote.dto

import com.example.learningapp.domain.model.Metadata
import com.squareup.moshi.Json

data class MetadataDto(
    @Json(name = "name") val name: String? = null,
    @Json(name = "dna") val dna: String? = null,
    @Json(name = "fileName") val fileName: String? = null,
    @Json(name = "fileUri") val fileUri: String? = null,
    @Json(name = "fileType") val fileType: String? = null,
    @Json(name = "edition") val edition: Int? = null,
    @Json(name = "date") val date: Long? = null,
    @Json(name = "image") val image: String? = null,
    @Json(name = "collection") val collection: String? = null,
    @Json(name = "description") val description: String? = null,
    @Json(name = "attributes") val attributes: List<AttributeDto>? = null,
    @Json(name = "properties") val properties: PropertiesDto? = null,
    @Json(name = "rarity") val rarity: RarityDto? = null,
    @Json(name = "id") val id: Int? = null,
    @Json(name = "compiler") val compiler: String? = null
)

fun MetadataDto.toMetadata() : Metadata {
    return Metadata(
        name = name,
        dna = dna,
        fileName = fileName,
        fileUri = fileUri,
        fileType = fileType,
        edition = edition,
        date = date,
        image = image,
        collection = collection,
        description = description,
        attributes = attributes?.map { it.toAttribute() },
        properties = properties?.toProperties(),
        rarity = rarity?.toRarity(),
        id = id,
        compiler = compiler

    )
}
