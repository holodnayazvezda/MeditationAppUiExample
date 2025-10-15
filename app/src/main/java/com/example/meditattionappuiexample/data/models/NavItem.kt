package com.example.meditattionappuiexample.data.models

import com.example.meditattionappuiexample.domain.navigation.BottomNavRoutes

data class NavItem(
    val route: BottomNavRoutes,
    val label: String,
    val icon: Int
)
