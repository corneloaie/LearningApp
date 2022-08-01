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
        super.onCreateView(inflater, container, savedInstanceState)

        val adapter = NftsAdapter()

        viewModel.getError().observe(viewLifecycleOwner) {
            value -> binding.nftsErrorHandling.text = value
        }

        viewModel.nftList().observe(viewLifecycleOwner) {
            value -> adapter.submitList(value)
        }

        binding.nftsRecyclerView.adapter = adapter

        return binding.root
    }
}