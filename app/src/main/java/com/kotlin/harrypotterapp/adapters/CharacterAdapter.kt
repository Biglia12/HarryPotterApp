package com.kotlin.harrypotterapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.harrypotterapp.R
import com.kotlin.harrypotterapp.databinding.ItemCharacterBinding
import com.kotlin.harrypotterapp.model.CharactersModel
import com.squareup.picasso.Picasso


class CharacterAdapter(
    val context: Context, val list: List<CharactersModel>,var clickListener: OnItemCharacterClickListener
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return CharacterViewHolder(layoutInflater.inflate(R.layout.item_character, parent, false))

    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item, clickListener)

    }


    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemCharacterBinding.bind(view)


        fun bind(list: CharactersModel, actionClick: OnItemCharacterClickListener) {

            binding.textViewNameCharacter.text = list.personaje
            binding.textViewHouseHogwarts.text = list.casaDeHogwarts
            binding.textViewRealName.text = list.interpretadoPor

            Picasso.get()
                .load(list.imagen)
                .placeholder(R.drawable.ic_icon_placeholder_harry)
                .resize(250, 300)
                .into(binding.imageViewCharacter)

            itemView.setOnClickListener {
                actionClick.onItemClick(list, adapterPosition)
            }

            }

        }


    }

    interface OnItemCharacterClickListener {
        fun onItemClick(item: CharactersModel, position: Int)
    }


