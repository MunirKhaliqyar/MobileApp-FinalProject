package com.example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.model.room

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Room] data object.
 */
class RoomAdapter(
    private val context: Context,
    private val dataset: List<room>
) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Room object.
    class RoomViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val cardView: TextView = view.findViewById(R.id.cardText)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.room_layout, parent, false)

        return RoomViewHolder(adapterLayout)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount(): Int {
        return dataset.size
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room = dataset[position]
        holder.cardView.text = context.resources.getString(room.stringResourceId)
        TODO("Not yet implemented")
    }
}