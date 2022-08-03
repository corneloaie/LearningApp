package com.example.learningapp.ui.nft.screenslide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapp.databinding.NftViewDynamicBinding
import com.example.learningapp.domain.model.PropertyUI

class NftViewAdapter : ListAdapter<PropertyUI, NftViewAdapter.ViewHolder>(PropertyUIDiffCallBack()) {
    class ViewHolder constructor(val binding: NftViewDynamicBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PropertyUI) {
            binding.propertyui = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NftViewDynamicBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PropertyUIDiffCallBack : DiffUtil.ItemCallback<PropertyUI>() {
    override fun areItemsTheSame(oldItem: PropertyUI, newItem: PropertyUI): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: PropertyUI, newItem: PropertyUI): Boolean {
        return oldItem == newItem
    }

}