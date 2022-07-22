package com.example.learningapp.domain.repository

import com.example.learningapp.domain.model.Nft
import io.reactivex.rxjava3.core.Single


interface NftsRepository {
    fun getNfts(): Single<List<Nft>>
}
