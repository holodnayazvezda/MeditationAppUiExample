package com.example.meditattionappuiexample.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = DarkBackground,
    primary = DarkButton,
    onPrimary = DarkButtonText,
    onBackground = DarkTextPrimary
)

private val LightColorScheme = lightColorScheme(
    background = LightBackground,
    primary = LightButton,
    onPrimary = LightButtonText,
    onBackground = LightTextPrimary
)

@Composable
fun MeditattionAppUiExampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}