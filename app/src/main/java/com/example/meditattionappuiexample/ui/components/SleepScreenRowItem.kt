package com.example.meditattionappuiexample.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SleepScreenRowItem(
    @StringRes val stringResId: Int,
    @DrawableRes val iconResId: Int
)