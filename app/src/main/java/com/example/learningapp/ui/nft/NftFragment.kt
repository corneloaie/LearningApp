package com.example.learningapp.ui.nft

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.example.learningapp.R
import com.example.learningapp.base.view.fragment.BaseFragment
import com.example.learningapp.databinding.NftFragmentBinding
import com.example.learningapp.domain.model.Nft
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NftFragment : BaseFragment<NftViewModel, NftFragmentBinding>() {
    override val layoutId: Int = R.layout.nft_fragment
    override val viewModel: NftViewModel by activityViewModels()

    val args: NftFragmentArgs by navArgs()

    val viewPager: ViewPager2 by lazy { binding.pager }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        initObservers()

        initViews()

        viewModel.getNft(args.myItem)

        return binding.root
    }

    private fun initViews() {
        val adapter = NftPagesAdapter(this)

        val tabLayout = binding.tabLayout

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = viewModel.tabTitles[position]
        }.attach()
    }

    private fun initObservers() {
        viewModel.nft().observe(viewLifecycleOwner) { value ->
            binding.nftViewImage.load(value.media.get(0).thumbnailUrl) {
                placeholder(R.drawable.ic_launcher_background)
                error(androidx.constraintlayout.widget.R.drawable.abc_ic_search_api_material)
            }
            binding.nftViewImage.setOnClickListener {
                popupImage(value)
            }
        }
    }

    private fun popupImage(value: Nft) {
        val layoutInflater = LayoutInflater.from(context)
        val popupView: View = layoutInflater.inflate(R.layout.popupnftimage, null)
        val image = popupView.findViewById<ImageView>(R.id.popupImage)
        image.load(value.media.get(0).thumbnailUrl)
        val popupWindow: PopupWindow = PopupWindow(popupView, 600, 600, true)
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
    }

}