package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.navigation.ui.AppBarConfiguration
import com.example.adapter.RoomAdapter
import com.example.data.Datasource
import com.example.data.Room
import com.example.finalproject.databinding.ActivityMainBinding
import com.example.finalproject.databinding.ActivityRoomBinding
import com.example.finalproject.databinding.FragmentRoomCardBinding

class RoomActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val room = intent.getSerializableExtra("selectedRoom") as? Room

        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (room != null) {
            binding.roomCard.itemTitle.text = room.stringResourceId.toString()
            binding.detailsText.text = room.description
        }

        binding.backButton.setOnClickListener {
            finish()
        }

        binding.bookButton.setOnClickListener {
            // Navigate to ReceiptActivity
            val intent = Intent(this, ReceiptActivity::class.java)
            startActivity(intent)
        }
    }
}