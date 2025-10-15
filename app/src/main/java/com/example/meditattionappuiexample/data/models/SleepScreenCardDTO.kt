package com.example.meditattionappuiexample.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SleepScreenCardDTO(
    @DrawableRes val imageResId: Int,
    val name: String,
    val durationMinutes: Int,
    val category: String
)
