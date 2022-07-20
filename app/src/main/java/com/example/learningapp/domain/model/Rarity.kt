package com.example.learningapp.domain.model

data class Rarity(
    val avgRarity: Float,
    val statRarity: Float,
    val rarityScore: Float,
    val rarityScoreNormed: Float,
    val usedTraitsCount: Int
)
