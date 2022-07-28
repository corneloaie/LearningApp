package com.example.learningapp.domain.model


data class Metadata(
    val name: String? = null,
    val dna: String? = null,
    val fileName: String? = null,
    val fileUri: String? = null,
    val fileType: String? = null,
    val edition: Int? = null,
    val date: Long? = null,
    val collection: String? = null,
    val description: String? = null,
    val attributes: List<Attribute>? = null,
    val properties: Properties? = null,
    val rarity: Rarity? = null,
    val id: Int? = null,
    val compiler: String? = null
)
