package com.example.meditattionappuiexample.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.meditattionappuiexample.data.models.SleepScreenCardDTO

@Composable
fun PlayOptionScreen(
    navController: NavHostController
) {
    val cardDTO = navController.currentBackStackEntry?.savedStateHandle?.get<SleepScreenCardDTO>("cardDTO")
    Text(
        text = cardDTO?.name ?: ""
    )
}