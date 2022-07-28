package com.example.learningapp.ui.nfts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.learningapp.base.viewmodel.BaseViewModel
import com.example.learningapp.domain.model.Nft
import com.example.learningapp.domain.usecase.GetNftsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class NftsViewModel @Inject constructor(
    private val getNftsUseCase: GetNftsUseCase
) : BaseViewModel() {

    private val nftList: MutableLiveData<List<Nft>> = MutableLiveData<List<Nft>>()
    fun nftList(): LiveData<List<Nft>> {
        return this.nftList
    }

    private val TAG = NftsViewModel::class.java.simpleName



    init {
        getNftList()
    }

    private fun getNftList() {
        disposables.add(getNftsUseCase.execute().subscribe(
            {
                value -> nftList.postValue(value)
            },
            {
                Log.e(TAG, it.toString())
                //TODO rxjava exception handling https://medium.com/swlh/master-error-handling-in-rxjava-crush-em-5cb66bb16ccd
            }
        ))

    }
}