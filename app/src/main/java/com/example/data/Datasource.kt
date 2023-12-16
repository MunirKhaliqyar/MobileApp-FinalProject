package com.example.data

import com.example.finalproject.R
import com.example.model.Room

class Datasource {
    fun loadAvailableRoom(): List<Room> {
        return listOf<Room>(
            Room(R.string.room1, R.drawable.room1),
            Room(R.string.room2, R.drawable.room2),
            Room(R.string.room3, R.drawable.room3),
            Room(R.string.room4, R.drawable.room4),
            Room(R.string.room5, R.drawable.room5),
            Room(R.string.room6, R.drawable.room6),
        )
    }
}