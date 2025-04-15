package com.example.catfightingclub.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.catfightingclub.R
import com.example.catfightingclub.databinding.CatViewBinding
import com.example.catfightingclub.model.Cat
import com.example.catfightingclub.model.CatsService
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CatsAdapter @Inject constructor(
    private val actionListener: CatActionListener,
    @ApplicationContext private val context: Context
): ListAdapter<Cat, CatsAdapter.CatViewHolder>(ItemDiffCallback()) {

    inner class CatViewHolder(private val binding: CatViewBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(cat: Cat) {
            binding.catIdentifier.text = cat.id.toString()
            binding.catName.text = cat.name
            if (cat.isFavorite) {
                changeToFavorite(binding)
            }
            else {
                changeToDefault(binding)
            }
            binding.catFavoriteButton.setOnClickListener {
                if (actionListener.getCatById(cat.id).isFavorite) {
                    changeToDefault(binding)
                }
                else {
                    changeToFavorite(binding)
                }
                actionListener.onChangeStatus(cat.id)
            }
        }

        private fun changeToFavorite(binding: CatViewBinding) {
            binding.catFavoriteButton.text = context.getString(R.string.favorite_rv_button_name)
            binding.catFavoriteButton.setBackgroundColor(Color.RED)
        }

        private fun changeToDefault(binding: CatViewBinding) {
            binding.catFavoriteButton.text = context.getString(R.string.default_rv_button_name)
            binding.catFavoriteButton.setBackgroundColor(context.getColor(R.color.purple_500))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = CatViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemDiffCallback : DiffUtil.ItemCallback<Cat>() {
        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem == newItem
        }
    }
}
