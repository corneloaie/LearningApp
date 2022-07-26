package com.example.learningapp.ui.nfts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.learningapp.base.viewmodel.BaseViewModel
import com.example.learningapp.domain.model.Nft
import com.example.learningapp.domain.usecase.GetNftsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NftsViewModel @Inject constructor(
    private val getNftsUseCase: GetNftsUseCase
) : BaseViewModel() {

    private val nftList: MutableLiveData<List<Nft>> = MutableLiveData<List<Nft>>()
    fun nftList(): LiveData<List<Nft>> {
        return this.nftList
    }




    init {
        getNftList()
    }

    private fun getNftList() {
        val disposable: Disposable = getNftsUseCase.execute().subscribe{
                value -> nftList.postValue(value)
        }
        disposables.add(disposable)
    }
}