package com.example.meditattionappuiexample.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SleepScreenRowItemDTO(
    @StringRes val stringResId: Int,
    @DrawableRes val iconResId: Int
)