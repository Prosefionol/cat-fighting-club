package com.example.catfightingclub.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.catfightingclub.databinding.FavoriteCatViewBinding
import com.example.catfightingclub.model.Cat

class FavoriteCatsAdapter: ListAdapter<Cat, FavoriteCatsAdapter.FavoriteCatViewHolder>(ItemDiffCallback()) {

    class FavoriteCatViewHolder(
        private val binding: FavoriteCatViewBinding
    ): RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(cat: Cat) {
            binding.favoriteCatIdentifier.text = cat.id.toString()
            binding.favoriteCatName.text = cat.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteCatViewHolder {
        val binding = FavoriteCatViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteCatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteCatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemDiffCallback: DiffUtil.ItemCallback<Cat>() {
        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem == newItem
        }
    }
}