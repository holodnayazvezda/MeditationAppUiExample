package com.example.meditattionappuiexample.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.meditattionappuiexample.domain.navigation.BottomNavGraph
import com.example.meditattionappuiexample.ui.components.BottomNavigationBar
import com.example.meditattionappuiexample.ui.screens.bottomnav.sleep_screen.SleepScreenViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    sleepScreenViewModel: SleepScreenViewModel
) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = bottomNavController) }
    ) { innerPadding ->
        BottomNavGraph(
            navController = bottomNavController,
            globalNavController = navController,
            sleepScreenViewModel = sleepScreenViewModel,
            modifier = Modifier.padding(innerPadding)
        )
    }
}