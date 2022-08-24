package com.example.learningapp.data.remote

import com.example.learningapp.data.remote.dto.NftDto
import com.example.learningapp.domain.model.Nft
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ElrondService {
    @GET("/nfts")
    fun getNfts(@Query("collection") getByCollection: String = "ELFARM-327070"): Single<List<NftDto>>
    @GET("/nfts/{id}")
    fun getNft(@Path("id") getById:String) : Single<NftDto>
}