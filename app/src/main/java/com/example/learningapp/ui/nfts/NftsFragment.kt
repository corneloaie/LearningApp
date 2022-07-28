package com.example.learningapp.ui.nfts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.learningapp.R
import com.example.learningapp.base.view.fragment.BaseFragment
import com.example.learningapp.databinding.NftsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NftsFragment : BaseFragment<NftsViewModel, NftsFragmentBinding>(){
    override val layoutId: Int = R.layout.nfts_fragment
    override val viewModel: NftsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: NftsFragmentBinding = DataBindingUtil.inflate(
            inflater, layoutId, container, false
        )
        binding.viewModel = viewModel


        binding.apply {
            viewModel = this@NftsFragment.viewModel
            lifecycleOwner = this@NftsFragment
        }

        val adapter = NftsAdapter()

        viewModel.nftList().observe(viewLifecycleOwner) {
            value -> adapter.submitList(value)
        }

        binding.nftsRecyclerView.adapter = adapter

        return binding.root
    }
}