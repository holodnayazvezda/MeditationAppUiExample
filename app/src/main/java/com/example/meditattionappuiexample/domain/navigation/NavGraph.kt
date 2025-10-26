package com.example.meditattionappuiexample.domain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meditattionappuiexample.ui.screens.MainScreen
import com.example.meditattionappuiexample.ui.screens.play_option_screen.PlayOptionScreen
import com.example.meditattionappuiexample.ui.screens.WelcomeScreen
import com.example.meditattionappuiexample.ui.screens.bottomnav.sleep_screen.SleepScreenViewModel
import com.example.meditattionappuiexample.ui.screens.play_option_screen.PlayOptionScreenViewModel

@Composable
fun NavigationHost(
        modifier: Modifier = Modifier,
        navHostController: NavHostController = rememberNavController(),
        bottomNavHostController: NavHostController = rememberNavController(),
        sleepScreenViewModel: SleepScreenViewModel,
        playOptionScreenViewModel: PlayOptionScreenViewModel
) {
    NavHost(
        navController = navHostController,
        startDestination = NavRoutes.WELCOME_SCREEN.route
    ) {
        composable(NavRoutes.WELCOME_SCREEN.route) {
            WelcomeScreen(
                modifier = modifier,
                nextScreen = {
                        navHostController.navigate(NavRoutes.MAIN_SCREEN.route)
                }
            )
        }

        composable(NavRoutes.MAIN_SCREEN.route) {
            MainScreen(
                modifier = modifier,
                navController = navHostController,
                bottomNavController = bottomNavHostController,
                sleepScreenViewModel = sleepScreenViewModel,
                playOptionScreenViewModel = playOptionScreenViewModel
            )
        }
        composable(NavRoutes.PLAY_OPTION_SCREEN.route) {
            PlayOptionScreen(
                navController = navHostController,
                sleepScreenViewModel = sleepScreenViewModel,
                playOptionScreenViewModel = playOptionScreenViewModel,
                nextScreen = {
                    bottomNavHostController.navigate(BottomNavRoutes.MUSIC_SCREEN.route)
                }
            )
        }
    }
}