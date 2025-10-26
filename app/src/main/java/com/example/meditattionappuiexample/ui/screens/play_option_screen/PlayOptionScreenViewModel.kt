package com.example.meditattionappuiexample.ui.screens.play_option_screen

import androidx.lifecycle.ViewModel
import com.example.meditattionappuiexample.data.models.SleepScreenCardDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlayOptionScreenViewModel : ViewModel() {
    private val _selectedCardDTO = MutableStateFlow(SleepScreenCardDTO())

    val selectedCardDTO = _selectedCardDTO.asStateFlow()

    fun updateSelectedCardDTO(
        newSelectedCardDTO: SleepScreenCardDTO
    ) {
        _selectedCardDTO.value = newSelectedCardDTO
    }
}