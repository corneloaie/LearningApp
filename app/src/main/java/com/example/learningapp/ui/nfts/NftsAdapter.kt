package com.example.learningapp.ui.nfts

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.learningapp.R
import com.example.learningapp.base.adapter.BaseDataBoundListAdapter
import com.example.learningapp.base.adapter.BaseDataBoundViewHolder
import com.example.learningapp.databinding.NftsCardviewBinding
import com.example.learningapp.domain.model.Nft
import java.util.stream.BaseStream

class NftsAdapter(
    private val list: List<Nft>
) : BaseDataBoundListAdapter<Nft, NftsCardviewBinding>(NftListDiffCallback()) {
    override fun getItemLayout(viewType: Int): Int {
        return R.layout.nfts_cardview
    }

    override fun bind(binding: NftsCardviewBinding, item: Nft, position: Int) {
        binding.apply {
            nft = item
            nftImage.load(item.media[0].thumbnailUrl)
            executePendingBindings()
        }
    }
}

class NftListDiffCallback: DiffUtil.ItemCallback<Nft>() {
    override fun areItemsTheSame(oldItem: Nft, newItem: Nft): Boolean {
        return oldItem.name == newItem.name // nu tin minte daca nft-urile pot sa aiba aceleasi nume
    }

    override fun areContentsTheSame(oldItem: Nft, newItem: Nft): Boolean {
        return oldItem == newItem
    }

}