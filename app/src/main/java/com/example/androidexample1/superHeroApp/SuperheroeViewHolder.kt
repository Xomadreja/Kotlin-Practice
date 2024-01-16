package com.example.androidexample1.superHeroApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexample1.databinding.ItemSuperheroeBinding
import com.squareup.picasso.Picasso

class SuperheroeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroeBinding.bind(view)
    fun bind(superheroeItemResponse: SuperheroeItemResponse, getInfoSuperheroe: (String) -> Unit) {
        binding.tvSuperheroeName.text = superheroeItemResponse.name
        Picasso.get().load(superheroeItemResponse.image.url).into(binding.ivSuperheroe)
        binding.root.setOnClickListener{
            getInfoSuperheroe(superheroeItemResponse.id)
        }
    }

}