package com.example.learningapp.domain.usecase

import com.example.learningapp.domain.model.Nft
import com.example.learningapp.domain.repository.NftsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface GetNftsUseCase {
    fun execute(): Single<List<Nft>>
}

class GetNftsUseCaseImplementation @Inject constructor(
    private val repository: NftsRepository
) : GetNftsUseCase {
    override fun execute(): Single<List<Nft>> {
        return repository.getNfts()
    }
}