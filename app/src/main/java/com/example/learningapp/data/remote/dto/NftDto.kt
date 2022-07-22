package com.example.learningapp.data.remote.dto

import com.example.learningapp.domain.model.Media
import com.example.learningapp.domain.model.Metadata
import com.example.learningapp.domain.model.Nft
import com.squareup.moshi.Json
import java.net.URL

data class NftDto(
    @Json(name = "identifier") val identifier: String,
    @Json(name = "collection") val collection: String,
    @Json(name= "timestamp") val timestamp: Int,
    @Json(name = "attributes") val attributes: String,
    @Json(name = "nonce") val nonce: Int,
    @Json(name = "type") val type: String,
    @Json(name = "name") val name: String,
    @Json(name = "creator") val creator: String,
    @Json(name = "royalties") val royalties: Int,
    @Json(name = "uris") val uris: List<String>,
    @Json(name = "url") val url: String,
    @Json(name = "media") val media: List<MediaDto>,
    @Json(name = "isWhiteListedStorage") val isWhitelistedStorage: Boolean,
    @Json(name = "tags") val tags: List<String>,
    @Json(name = "metadata") val metadata: MetadataDto,
    @Json(name = "ticker") val ticker: String
)

fun NftDto.toNft() : Nft {
    return Nft(
        identifier = identifier,
        collection = collection,
        timestamp = timestamp,
        attributes = attributes,
        nonce = nonce,
        type = type,
        name = name,
        creator = creator,
        royalties = royalties,
        uris = uris,
        url = url,
        media = media.map { it.toMedia() },
        isWhitelistedStorage = isWhitelistedStorage,
        tags = tags,
        metadata = metadata.toMetadata(),
        ticker = ticker
    )
}