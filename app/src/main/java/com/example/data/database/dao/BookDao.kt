package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.entities.Booking

@Dao
interface BookDao {
    @Query("SELECT * FROM Booking")
    fun getAll(): List<Booking>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(booking: Booking)
    @Delete()
    fun delete(room: Booking)
    @Query("SELECT * FROM Booking WHERE BookingId = :id")
    fun getBookingById(id: String): Booking
}