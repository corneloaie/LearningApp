package com.example.learningapp.ui.nfts

import com.example.learningapp.base.viewmodel.BaseViewModel
import com.example.learningapp.domain.usecase.GetNftsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NftsViewModel @Inject constructor(
    private val getNftsUseCase: GetNftsUseCase
) : BaseViewModel() {
}