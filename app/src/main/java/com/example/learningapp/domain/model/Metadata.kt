package com.example.learningapp.domain.model


data class Metadata(
    val name: String? = null,
    val dna: String? = null, // proprietatile astea 2 sunt optionale, si din cauza ca sunt optionale le initializez cu null
    val fileName: String? = null,
    val fileUri: String? = null,
    val fileType: String? = null,
    val edition: Int? = null,
    val date: Int? = null,
    val image: String? = null,
    val collection: String? = null,
    val description: String,
    val attributes: List<Attribute>,
    val properties: Properties? = null,
    val rarity: Rarity? = null,
    val id: Int? = null,
    val compiler: String? = null
)
