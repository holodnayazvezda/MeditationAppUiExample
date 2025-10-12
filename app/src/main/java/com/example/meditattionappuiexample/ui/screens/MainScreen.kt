package com.example.meditattionappuiexample.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.meditattionappuiexample.domain.navigation.BottomNavGraph
import com.example.meditattionappuiexample.ui.components.BottomNavigationBar

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = bottomNavController) }
    ) { innerPadding ->
        BottomNavGraph(
            navController = bottomNavController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}