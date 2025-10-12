package com.example.meditattionappuiexample.ui.components

import com.example.meditattionappuiexample.domain.navigation.BottomNavRoutes

data class NavItem(
    val route: BottomNavRoutes,
    val label: String,
    val icon: Int
)
