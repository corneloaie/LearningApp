package com.example.learningapp.data.remote.dto

import com.example.learningapp.domain.model.Rarity
import com.squareup.moshi.Json

data class RarityDto(
    @Json(name = "avgRarity") val avgRarity: Float? = null,
    @Json(name = "statRarity") val statRarity: Float? = null,
    @Json(name = "rarityScore") val rarityScore: Float? = null,
    @Json(name = "rarityScoreNormed") val rarityScoreNormed: Float? = null,
    @Json(name = "usedTraitsCount") val usedTraitsCount: Int? = null
)

fun RarityDto.toRarity() : Rarity {
    return Rarity(
        avgRarity = avgRarity,
        statRarity = statRarity,
        rarityScore = rarityScore,
        rarityScoreNormed = rarityScoreNormed,
        usedTraitsCount = usedTraitsCount
    )
}