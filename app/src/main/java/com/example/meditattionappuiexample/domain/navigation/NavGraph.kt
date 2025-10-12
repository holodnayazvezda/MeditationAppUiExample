package com.example.meditattionappuiexample.domain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meditattionappuiexample.ui.screens.MainScreen
import com.example.meditattionappuiexample.ui.screens.WelcomeScreen

@Composable
fun NavigationHost(
        modifier: Modifier = Modifier,
        navHostController: NavHostController = rememberNavController()
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
                                modifier = modifier
                        )
                }
        }
}