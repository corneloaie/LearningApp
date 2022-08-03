package com.example.learningapp.ui.nft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.example.learningapp.R
import com.example.learningapp.base.view.fragment.BaseFragment
import com.example.learningapp.databinding.NftFragnentBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NftFragment : BaseFragment<NftViewModel, NftFragnentBinding>() {
    override val layoutId: Int = R.layout.nft_fragnent
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


        val informationTab =
            tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_information)))
        val detailsTab =
            tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_details)))


        viewPager.adapter = adapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    private fun initObservers() {
        viewModel.nft().observe(viewLifecycleOwner) { value ->
            binding.nftViewImage.load(value.media.get(0).thumbnailUrl) {
                placeholder(R.drawable.ic_launcher_background)
                error(androidx.constraintlayout.widget.R.drawable.abc_ic_search_api_material)
            }
        }
    }

}