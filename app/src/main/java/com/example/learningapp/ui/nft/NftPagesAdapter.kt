package com.example.learningapp.ui.nft

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.learningapp.ui.nft.screenslide.FragmentType
import com.example.learningapp.ui.nft.screenslide.NftInformationFragment

class NftPagesAdapter(hostFragment: Fragment) : FragmentStateAdapter(hostFragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return NftInformationFragment.newInstance(FragmentType.INFORMATION)
            1 -> return NftInformationFragment.newInstance(FragmentType.DETAILS)
        }
        return NftInformationFragment()
    }
}