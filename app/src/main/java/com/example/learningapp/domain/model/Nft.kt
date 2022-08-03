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
    val metadata: Metadata? = null,
    val ticker: String,
    val owner: String? = null
)

fun Nft.toDetailsUI() : List<PropertyUI> {
    return listOf(
        PropertyUI("Rarity-type", type),
        PropertyUI("Rarity-rank", timestamp.toString())
    )
}

fun Nft.toInformationUI() : List<PropertyUI> {
    return listOf(
        PropertyUI("Name", name),
        PropertyUI("Description", metadata?.description),
        PropertyUI("Current owner", owner)
    )
}

data class PropertyUI(val title: String?, val subtitle: String?)