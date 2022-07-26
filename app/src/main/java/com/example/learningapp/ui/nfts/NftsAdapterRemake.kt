package com.example.learningapp.ui.nfts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapp.databinding.NftsCardviewBinding
import com.example.learningapp.domain.model.Nft

class NftsAdapterRemake(
    private val list: List<Nft>
) : ListAdapter<Nft, NftsAdapterRemake.ViewHolder>(NftListDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder private constructor(val binding: NftsCardviewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Nft) {
            binding.nft = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NftsCardviewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
}

