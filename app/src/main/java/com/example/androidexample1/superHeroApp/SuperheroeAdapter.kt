package com.example.androidexample1.superHeroApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexample1.R

class SuperheroeAdapter(
    var superheroeList: List<SuperheroeItemResponse> = emptyList(),
    private val getInfoSuperheroe: (String) -> Unit
) : RecyclerView.Adapter<SuperheroeViewHolder>() {
    fun updateList(superheroeList: List<SuperheroeItemResponse>) {
        this.superheroeList = superheroeList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroeViewHolder {
        return SuperheroeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superheroe, parent, false)
        )
    }

    override fun getItemCount(): Int = superheroeList.size

    override fun onBindViewHolder(vholder: SuperheroeViewHolder, position: Int) {
        vholder.bind(superheroeList[position],getInfoSuperheroe)
    }
}