package com.example.learningapp.domain.usecase

import com.example.learningapp.domain.model.Nft
import com.example.learningapp.domain.repository.NftsRepository
import io.reactivex.rxjava3.core.Single

interface GetNftsUseCase {
    fun execute() : Single<List<Nft>>
}

internal class GetNftsUseCaseImplementation(
    private val repository: NftsRepository
) : GetNftsUseCase {
    override fun execute(): Single<List<Nft>> {
        return repository.getNfts()
    }
}