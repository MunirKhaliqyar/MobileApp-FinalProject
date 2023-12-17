package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.dao.BookDao
import com.example.data.database.dao.RoomDao
import com.example.data.database.entities.Booking
import com.example.data.database.entities.Room

@Database(entities = [Room::class, Booking::class], version = 1, exportSchema = false)
abstract class HotelDatabase:  RoomDatabase(){
    abstract fun bookDao(): BookDao
    abstract fun roomDao(): RoomDao
}