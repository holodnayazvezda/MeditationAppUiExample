package com.example.meditattionappuiexample.ui.screens.bottomnav.sleep_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SleepScreenViewModel : ViewModel() {
    private val _selectedItemId = MutableStateFlow(0)
    val selectedItemId = _selectedItemId.asStateFlow()

    fun updateSelectedItemId(newId: Int) {
        _selectedItemId.value = newId
    }
}