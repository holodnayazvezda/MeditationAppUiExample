package com.example.meditattionappuiexample.ui.screens.bottomnav

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.meditattionappuiexample.ui.screens.play_option_screen.PlayOptionScreenViewModel
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.example.meditattionappuiexample.domain.navigation.BottomNavRoutes
import com.example.meditattionappuiexample.domain.navigation.NavRoutes

@Composable
fun MusicScreen(
    playOptionScreenViewModel: PlayOptionScreenViewModel,
    bottomNavController: NavHostController

) {
    val selectedCardData = playOptionScreenViewModel.selectedCardDTO.collectAsState().value
    Text(
        text = selectedCardData.name,
        modifier = Modifier.clickable {
            bottomNavController.popBackStack()
        }
    )
}