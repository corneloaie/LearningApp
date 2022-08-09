package com.example.learningapp.ui.nft.screenslide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.learningapp.R
import com.example.learningapp.base.view.fragment.BaseFragment
import com.example.learningapp.databinding.NftInformationFragmentBinding
import com.example.learningapp.domain.model.toInformationUI
import com.example.learningapp.ui.nft.NftViewModel

class NftInformationFragment : BaseFragment<NftViewModel, NftInformationFragmentBinding>() {
    override val layoutId: Int = R.layout.nft_information_fragment
    override val viewModel: NftViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val adapter = NftViewAdapter()

        initObservers(adapter)

        initViews(adapter)

        return binding.root
    }

    private fun initViews(adapter: NftViewAdapter) {
        val recyclerView = binding.nftInformationRV

        recyclerView.adapter = adapter

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun initObservers(adapter: NftViewAdapter) {
        viewModel.nft().observe(viewLifecycleOwner) { value ->
            adapter.submitList(value.toInformationUI())
        }
    }

}