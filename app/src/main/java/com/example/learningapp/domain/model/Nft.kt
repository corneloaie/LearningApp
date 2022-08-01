package com.example.learningapp.domain.model



data class Nft(
    val identifier: String,
    val collection: String,
    val timestamp: Int,
    val attributes: String,
    val nonce: Int,
    val type: String,
    val name: String,
    val creator: String,
    val royalties: Double? = null,
    val uris: List<String>,
    val url: String,
    val media: List<Media>,
    val isWhitelistedStorage: Boolean? = null,
    val tags: List<String>? = null,
    val metadata: Metadata,
    val ticker: String
)