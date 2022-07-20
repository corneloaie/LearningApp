package com.example.learningapp.data.remote.dto

import java.net.URL

//todo, serialize annotation from moshi? to follow good practices with matching the key name in the response body
data class NftDto(
    val identifier: String,
    val collection: String,
    val timestamp: Int,
    val attributes: String,
    val nonce: Int,
    val type: String,
    val name: String,
    val creator: String,
    val royalties: Int,
    val uris: List<String>, // sau ArrayList? presupun ca nu o sa modificam lista
    val url: String,
    val media: List<MediaDto>,
    val isWhitelistedStorage: Boolean,
    val tags: List<String>,
    val metadata: MetadataDto,
    val ticker: String
)