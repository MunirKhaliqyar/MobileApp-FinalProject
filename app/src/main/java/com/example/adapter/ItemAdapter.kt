package com.example.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.model.room

class ItemAdapter(private val context: Context, private val dataset: List<room>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val cardView: TextView = view.findViewById(R.id.cardText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}