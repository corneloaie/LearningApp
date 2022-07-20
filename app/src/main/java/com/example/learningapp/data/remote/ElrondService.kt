package com.example.learningapp.data.remote

import com.example.learningapp.data.remote.dto.NftDto
import io.reactivex.rxjava3.core.Single

//todo rename
interface ElrondService {
    fun getNfts(): Single<List<NftDto>> // am omis suspend, fiindca rxjava
}