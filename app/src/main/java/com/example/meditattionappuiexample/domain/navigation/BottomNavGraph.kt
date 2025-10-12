package com.example.meditattionappuiexample.domain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meditattionappuiexample.ui.screens.bottomnav.*


@Composable
fun BottomNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavRoutes.SLEEP_SCREEN.route,
        modifier = modifier
    ) {
        composable(BottomNavRoutes.HOME_SCREEN.route) { HomeScreen() }
        composable(BottomNavRoutes.SLEEP_SCREEN.route) { SleepScreen() }
        composable(BottomNavRoutes.MEDITATE_SCREEN.route) { MeditateScreen() }
        composable(BottomNavRoutes.MUSIC_SCREEN.route) { MusicScreen() }
        composable(BottomNavRoutes.AFSAR_SCREEN.route) { AfsarScreen() }
    }
}
