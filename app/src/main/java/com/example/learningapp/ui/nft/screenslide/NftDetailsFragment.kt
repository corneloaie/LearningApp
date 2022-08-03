package com.example.learningapp.ui.nft.screenslide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.learningapp.R
import com.example.learningapp.base.view.fragment.BaseFragment
import com.example.learningapp.databinding.NftDetailsBinding
import com.example.learningapp.domain.model.toDetailsUI
import com.example.learningapp.domain.model.toInformationUI
import com.example.learningapp.ui.nft.NftViewModel

class NftDetailsFragment : BaseFragment<NftViewModel, NftDetailsBinding>(){
    override val layoutId: Int = R.layout.nft_details
    override val viewModel: NftViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val adapter = NftViewAdapter()

        viewModel.nft().observe(viewLifecycleOwner) {
                value -> adapter.submitList(value.toDetailsUI())
        }

        binding.nftDetailsRV.adapter = adapter

        return binding.root
    }
}