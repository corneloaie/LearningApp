package com.example.learningapp.ui.nft

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.learningapp.ui.nfts.NftsFragment

class NftPagesAdapter(hostFragment: Fragment) : FragmentStateAdapter(hostFragment) {

    override fun getItemCount(): Int = 10

    override fun createFragment(position: Int): Fragment {
        if(position == 0) {
            return NftsFragment()
        }
        return NftsFragment()
    }
}