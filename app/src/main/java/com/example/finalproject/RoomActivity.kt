package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.finalproject.databinding.ActivityMainBinding
import com.example.finalproject.databinding.ActivityRoomBinding

class RoomActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

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