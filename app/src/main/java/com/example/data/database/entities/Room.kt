package com.example.data.database.entities

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Room")
data class Room (
    @PrimaryKey(autoGenerate = true) val RoomId: Int = 0,
    val Price: Double,
    val Description: String,
    val LocationURL: String,
    @DrawableRes val ImageResourceId: Int
)