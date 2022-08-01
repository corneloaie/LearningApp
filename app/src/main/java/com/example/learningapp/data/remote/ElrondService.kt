package com.example.learningapp.data.remote

import com.example.learningapp.data.remote.dto.NftDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ElrondService {
    @GET("/nfts")
    fun getNfts(): Single<List<NftDto>>
}