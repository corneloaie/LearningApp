package com.example.learningapp.ui.nft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import coil.load
import com.example.learningapp.R
import com.example.learningapp.base.view.fragment.BaseFragment
import com.example.learningapp.databinding.NftFragnentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NftFragment : BaseFragment<NftViewModel, NftFragnentBinding>() {
    override val layoutId: Int = R.layout.nft_fragnent
    override val viewModel: NftViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        viewModel.nft().observe(viewLifecycleOwner) {
            value -> binding.nftViewImage.load(value.media.get(0).thumbnailUrl) {
                placeholder(R.drawable.ic_launcher_background)
                error(androidx.constraintlayout.widget.R.drawable.abc_ic_search_api_material)
        }
        }

        return binding.root


    }
}