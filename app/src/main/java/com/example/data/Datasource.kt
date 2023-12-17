package com.example.data

import com.example.data.database.entities.Room
import com.example.finalproject.R

class Datasource {
    fun loadAvailableRoom(): List<Room> {
        return listOf<Room>(
            Room(1,100.0,"adsffadfaf", "https://maps.app.goo.gl/Kgv5hZY1D1WP5rDL6", R.drawable.room1),
            Room(2,150.0,"adsffadfaf", "https://maps.app.goo.gl/Kgv5hZY1D1WP5rDL6", R.drawable.room2),
            Room(3,45.0,"adsffadfaf", "https://maps.app.goo.gl/Kgv5hZY1D1WP5rDL6", R.drawable.room3),
            Room(4,85.0,"adsffadfaf", "https://maps.app.goo.gl/Kgv5hZY1D1WP5rDL6", R.drawable.room4),
            Room(5,852.0,"adsffadfaf", "https://maps.app.goo.gl/Kgv5hZY1D1WP5rDL6", R.drawable.room5),
            Room(6,355.0,"adsffadfaf", "https://maps.app.goo.gl/Kgv5hZY1D1WP5rDL6", R.drawable.room6),
        )
    }
}