package com.example.meditattionappuiexample.data.models

import androidx.annotation.DrawableRes

data class SleepScreenCardDTO(
    @DrawableRes val imageResId: Int = 0,
    val name: String = "",
    val durationMinutes: Int = 0,
    val category: String = "",
    val description: String = "",
    val favourites: Int = 0,
    val listenings: Int = 0
)
