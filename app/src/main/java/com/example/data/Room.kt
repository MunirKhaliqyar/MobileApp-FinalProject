package com.example.data

import java.io.Serializable

data class Room(
    val stringResourceId: Int,
    val imageResourceId: Int,
    val description: String
) : Serializable
