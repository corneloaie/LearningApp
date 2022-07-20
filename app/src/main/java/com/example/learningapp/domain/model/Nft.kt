package com.example.learningapp.domain.model

import com.example.learningapp.data.remote.dto.MediaDto
import com.example.learningapp.data.remote.dto.NftDto


data class Nft(
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
    val media: List<Media>,
    val isWhitelistedStorage: Boolean,
    val tags: List<String>,
    val metadata: Metadata,
    val ticker: String
)
//fun NftDto.toNft():Nft =  Nft(
//    identifier,
//    collection,
//    timestamp,
//    attributes,
//    nonce,
//    type,
//    name,
//    creator,
//    royalties,
//    uris,
//    url,
//    media as List<Media>,
//    isWhitelistedStorage,
//    tags,
//    metadata as Metadata,
//    ticker
//)