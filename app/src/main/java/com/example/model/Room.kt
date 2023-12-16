package com.example.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Room (
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int){
}