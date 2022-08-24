package com.example.learningapp.domain.usecase

import com.example.learningapp.domain.model.Nft
import com.example.learningapp.domain.repository.NftsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface GetNftUseCase {
    fun execute(id: String) : Single<Nft>
}

class GetNftUseCaseImplementation @Inject constructor(
    private val repository: NftsRepository
) : GetNftUseCase {
    override fun execute(id: String): Single<Nft> {
        return repository.getNft(id)
    }

}