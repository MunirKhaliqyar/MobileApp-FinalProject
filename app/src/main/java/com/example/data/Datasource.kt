package com.example.data

import com.example.finalproject.R
import com.example.model.Room

class Datasource {
    fun loadAvailableRoom(): List<Room> {
        return listOf<Room>(
            Room(R.string.roomBooked1),
            Room(R.string.roomBooked2),
            Room(R.string.roomBooked3)
        )
    }
}