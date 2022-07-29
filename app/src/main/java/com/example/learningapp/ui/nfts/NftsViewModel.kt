package com.example.learningapp.ui.nfts

import android.accounts.NetworkErrorException
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
import java.lang.RuntimeException
import javax.inject.Inject


@HiltViewModel
class NftsViewModel @Inject constructor(
    private val getNftsUseCase: GetNftsUseCase
) : BaseViewModel() {

    private val nftList: MutableLiveData<List<Nft>> = MutableLiveData<List<Nft>>()
    fun nftList(): LiveData<List<Nft>> {
        return this.nftList
    }

    private val error: MutableLiveData<String?> = MutableLiveData<String?>()
    fun getError(): LiveData<String?> {
        return this.error
    }


    private val TAG = NftsViewModel::class.java.simpleName


    init {
        getNftList()
    }

    private fun getNftList() {
        disposables.add(getNftsUseCase.execute().subscribe(
            { value ->
                nftList.postValue(value)
            },
            {
                Log.e(TAG, it.toString())
                when(it) {
                    is NetworkErrorException -> error.postValue("Something happened with the internet connection to the server: ${it.toString()}")
                    is RuntimeException -> error.postValue("Something happened with the application itself: ${it.toString()}")
                    is IllegalArgumentException -> error.postValue("The API has been passed an illegal argument: ${it.toString()}")
                    else -> {
                        error.postValue("Something unaccounted for happened: ${it.toString()}")
                    }
                }
                //TODO rxjava exception handling https://medium.com/swlh/master-error-handling-in-rxjava-crush-em-5cb66bb16ccd
            }
        ))

    }
}