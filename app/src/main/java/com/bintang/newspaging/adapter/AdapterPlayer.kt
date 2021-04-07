package com.bintang.newspaging.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bintang.newspaging.databinding.ActivityListItemPlayerBinding
import com.bintang.newspaging.model.DataItem

class AdapterPlayer : PagingDataAdapter<DataItem, AdapterPlayer.AdapterHolder>(playerDiffUtil()) {


    class playerDiffUtil : DiffUtil.ItemCallback<DataItem>() {
        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem == newItem
        }

    }

    class AdapterHolder(var binding: ActivityListItemPlayerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataItem) {
            binding.firstName.text = item.firstName
            binding.lastname.text = item.lastName
            binding.position.text = item.position
        }
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        val binding = ActivityListItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AdapterHolder(binding)
    }
}