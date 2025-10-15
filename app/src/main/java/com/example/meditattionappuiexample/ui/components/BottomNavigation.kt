package com.example.meditattionappuiexample.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.meditattionappuiexample.R
import com.example.meditattionappuiexample.data.models.NavItem
import com.example.meditattionappuiexample.domain.navigation.BottomNavRoutes

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {

    val items = listOf(
        NavItem(BottomNavRoutes.HOME_SCREEN, stringResource(R.string.home), R.drawable.ic_home),
        NavItem(BottomNavRoutes.SLEEP_SCREEN, stringResource(R.string.sleep), R.drawable.ic_sleep),
        NavItem(
            BottomNavRoutes.MEDITATE_SCREEN,
            stringResource(R.string.meditate),
            R.drawable.ic_meditate
        ),
        NavItem(BottomNavRoutes.MUSIC_SCREEN, stringResource(R.string.music), R.drawable.ic_music),
        NavItem(BottomNavRoutes.AFSAR_SCREEN, stringResource(R.string.afsar), R.drawable.ic_afsar)
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val backgroundColor = MaterialTheme.colorScheme.background
    val activeBackground = MaterialTheme.colorScheme.primary
    val activeContentColor = MaterialTheme.colorScheme.onPrimary
    val inactiveContentColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                val isSelected = item.route.route == currentRoute

                Column(
                    modifier = Modifier
                        .width(72.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(
                                if (isSelected) activeBackground else Color.Transparent,
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.label,
                            tint = if (isSelected) activeContentColor else inactiveContentColor,
                            modifier = Modifier.size(22.dp).clickable {
                                if (!isSelected) {
                                    navController.navigate(item.route.route)
                                }
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item.label,
                        style = TextStyle(
                            color = if (isSelected) activeContentColor else inactiveContentColor,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    Spacer(Modifier.height(15.dp))
                }
            }
        }
    }


}