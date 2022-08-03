package com.example.learningapp.ui.nft

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.example.learningapp.base.viewmodel.BaseViewModel
import com.example.learningapp.domain.model.Nft
import com.example.learningapp.domain.usecase.GetNftUseCase
import com.example.learningapp.ui.nfts.NftsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NftViewModel @Inject constructor(
    private val getNftUseCase: GetNftUseCase,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel(){

    private val nft: MutableLiveData<Nft> = MutableLiveData<Nft>()
    fun nft(): LiveData<Nft> {
        return this.nft
    }

    private val TAG = NftViewModel::class.java.simpleName

    fun getNft(id: String) {
        disposables.add(getNftUseCase.execute(id).subscribe(
            {
                value -> nft.postValue(value)
            },
            {

            }
        ))

    }
}