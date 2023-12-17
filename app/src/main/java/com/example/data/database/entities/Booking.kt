package com.example.data.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "Booking",
    foreignKeys = [
        ForeignKey(
            entity = RoomEntity::class,
            parentColumns = ["RoomId"],
            childColumns = ["RoomId"],
            onDelete = ForeignKey.CASCADE // Specify the desired onDelete action
        )
    ]
)
data class Booking (
    @PrimaryKey(autoGenerate = true) val BookingId: Int = 0,
    val RoomId: Int,
    val GuestFirstName: String,
    val GuestLastName: String,
    val GuestEmailAddress: String,
    val ArriveDate: Date,
    val LeaveDate: Date

    )