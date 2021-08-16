package com.example.rickandmortyupdate.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyupdate.databinding.ItemCharacterBinding
import com.example.rickandmortyupdate.models.RickAndMortyCharacter

class CharacterAdapter :
    PagingDataAdapter<RickAndMortyCharacter, CharacterAdapter.CharacterViewHolder>(
        differCallback
    ) {

    private lateinit var binding: ItemCharacterBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.CharacterViewHolder {
        binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CharacterAdapter.CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(item: RickAndMortyCharacter) {
            Glide
                .with(binding.imageItemCharacter)
                .load(item.image)
                .into(binding.imageItemCharacter)
            binding.textItemCharacter.text = item.name
        }

    }

    companion object {
        val differCallback = object : DiffUtil.ItemCallback<RickAndMortyCharacter>() {
            override fun areItemsTheSame(
                oldItem: RickAndMortyCharacter,
                newItem: RickAndMortyCharacter
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: RickAndMortyCharacter,
                newItem: RickAndMortyCharacter
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}