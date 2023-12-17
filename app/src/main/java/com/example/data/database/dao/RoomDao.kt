package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.entities.Booking
import com.example.data.database.entities.RoomEntity

@Dao
interface RoomDao {
    @Query("SELECT * FROM Room")
    suspend fun getAll(): List<RoomEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(roomEntity: RoomEntity)
    @Delete()
    suspend fun delete(roomEntity: RoomEntity)
    @Query("SELECT * FROM Room WHERE RoomId = :id")
    suspend fun getRoomById(id: String): Booking
}