package com.example.learningapp.ui.nfts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapp.databinding.NftsCardviewBinding
import com.example.learningapp.domain.model.Nft

class NftsAdapter() : ListAdapter<Nft, NftsAdapter.NftViewHolder>(NftListDiffCallback()) {

    class NftViewHolder private constructor(val binding: NftsCardviewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Nft) {
            binding.nft = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : NftViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NftsCardviewBinding.inflate(layoutInflater, parent, false)
                return NftViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NftViewHolder {
        return NftViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NftViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class NftListDiffCallback: DiffUtil.ItemCallback<Nft>() {
    override fun areItemsTheSame(oldItem: Nft, newItem: Nft): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Nft, newItem: Nft): Boolean {
        return oldItem == newItem
    }

}