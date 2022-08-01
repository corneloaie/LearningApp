package com.example.learningapp.data.remote

import com.example.learningapp.data.remote.dto.NftDto
import com.example.learningapp.domain.model.Nft
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ElrondService {
    @GET("/nfts")
    fun getNfts(): Single<List<NftDto>>
    @GET("/nfts/{id}")
    fun getNft(
        @Path("id") getById:String
    ) : Single<NftDto>
}