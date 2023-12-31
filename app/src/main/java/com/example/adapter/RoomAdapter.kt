package com.example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.data.Room
import com.example.data.database.entities.RoomEntity
import com.example.finalproject.R

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [RoomEntity] data object.
 */
class RoomAdapter(
    private val context: Context,
    private var dataset: List<Room>,
    private val onItemClickListener: (Room) -> Unit
) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Room object.
    class RoomViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.fragment_room_card, parent, false)
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
        holder.textView.text = context.resources.getString(room.stringResourceId)
        holder.imageView.setImageResource(room.imageResourceId)

        holder.itemView.setOnClickListener {
            onItemClickListener.invoke(room)
        }
    }

    fun updateDataset(newDataset: List<Room>) {
        dataset = newDataset
        notifyDataSetChanged()
    }
}