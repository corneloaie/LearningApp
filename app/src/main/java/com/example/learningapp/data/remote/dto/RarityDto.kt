package com.example.learningapp.data.remote.dto

import com.example.learningapp.domain.model.Rarity
import com.squareup.moshi.Json

data class RarityDto(
    @Json(name = "avgRarity") val avgRarity: Float,
    @Json(name = "statRarity") val statRarity: Float,
    @Json(name = "rarityScore") val rarityScore: Float,
    @Json(name = "rarityScoreNormed") val rarityScoreNormed: Float,
    @Json(name = "usedTraitsCount") val usedTraitsCount: Int
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