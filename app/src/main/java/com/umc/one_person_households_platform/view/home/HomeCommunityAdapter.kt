package com.umc.one_person_households_platform.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.umc.one_person_households_platform.databinding.ItemHomeCommunityListBinding
import com.umc.one_person_households_platform.model.CommunityContent

class HomeCommunityAdapter : ListAdapter<CommunityContent, HomeCommunityAdapter.ViewHolder>(CommunityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeCommunityListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemHomeCommunityListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CommunityContent) {
            with(binding) {
                community = item
                executePendingBindings()
            }
        }
    }
}

class CommunityDiffCallback : DiffUtil.ItemCallback<CommunityContent>() {
    override fun areItemsTheSame(oldItem: CommunityContent, newItem: CommunityContent): Boolean {
        return oldItem.postIdx == newItem.postIdx
    }

    override fun areContentsTheSame(oldItem: CommunityContent, newItem: CommunityContent): Boolean {
        return oldItem == newItem
    }
}