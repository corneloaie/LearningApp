package com.example.learningapp.ui.nft.screenslide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.learningapp.R
import com.example.learningapp.base.view.fragment.BaseFragment
import com.example.learningapp.databinding.NftFragmentscreenslideBinding
import com.example.learningapp.databinding.NftsFragmentBinding

class NftSlidePageFragment : BaseFragment<NftSlidePageViewModel, NftFragmentscreenslideBinding>() {
    override val layoutId: Int = R.layout.nft_fragmentscreenslide
    override val viewModel: NftSlidePageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}