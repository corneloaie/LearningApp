package com.example.learningapp.data.repository

import com.example.learningapp.data.remote.ElrondService
import com.example.learningapp.data.remote.dto.toNft
import com.example.learningapp.domain.model.Nft
import com.example.learningapp.domain.repository.NftsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class NftsRepositoryImpl @Inject constructor(
    private val service: ElrondService
) : NftsRepository {
    override fun getNfts(): Single<List<Nft>> {
        return service.getNfts()
            .map {
                it.map { nftDto ->
                    nftDto.toNft()
                }
            }
    }
}