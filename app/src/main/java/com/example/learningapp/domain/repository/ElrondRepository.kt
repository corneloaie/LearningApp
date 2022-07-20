package com.example.learningapp.domain.repository

import com.example.learningapp.data.remote.ElrondService
import com.example.learningapp.data.remote.dto.NftDto
import com.example.learningapp.domain.model.Nft
import io.reactivex.rxjava3.core.Flowable.fromIterable
import io.reactivex.rxjava3.core.Observable.fromIterable
import io.reactivex.rxjava3.core.Single
import java.util.*


val service: ElrondService = TODO() //not good, need DI
//pretend service has been injected in a variable called service

interface ElrondRepository {
    fun getNfts(): Single<List<Nft>> {  // o sa rescriu toata chestia asta, cu siguranta nu e in regula. ar fi trebuit sa folosesc generice
        val source: Single<List<NftDto>> = service.getNfts()

        return source.map { it -> it.map {
            it.toNft()
        } }
    }
}