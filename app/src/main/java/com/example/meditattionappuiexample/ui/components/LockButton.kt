package com.example.meditattionappuiexample.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LockButton() {
    var locked by remember { mutableStateOf(true) }
    val iconAlpha by animateFloatAsState(targetValue = if (locked) 1f else 0.8f, label = "iconAlpha")

    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.White.copy(alpha = 0.2f))
            .clickable { locked = !locked },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (locked) Icons.Filled.Lock else Icons.Filled.Check,
            contentDescription = if (locked) "Locked" else "Unlocked",
            tint = Color.White,
            modifier = Modifier
                .alpha(iconAlpha)
                .size(25.dp)
        )
    }
}


@Preview
@Composable
private fun LockButtonPreview() {
    LockButton()
}