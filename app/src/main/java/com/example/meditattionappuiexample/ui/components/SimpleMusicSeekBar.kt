package com.example.meditattionappuiexample.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SimpleMusicSeekBar(
    progress: Float,
    buffered: Float = 0f,
    onValueChange: (Float) -> Unit,
    onValueChangeFinished: (() -> Unit)? = null,
    modifier: Modifier = Modifier.fillMaxWidth(),
    playedTrackColor: Color = Color(0xFF7C4DFF),
    thumbColor: Color = Color(0xFF7C4DFF),
    trackHeight: Dp = 3.dp,
    bufferAlpha: Float = 0.35f
) {
    // clamp
    val p = progress.coerceIn(0f, 1f)
    val b = buffered.coerceIn(0f, 1f)

    Box(
        modifier = modifier
            .height(28.dp), // enough for thumb + track
        contentAlignment = Alignment.CenterStart
    ) {
        // Buffered bar (underneath)
        // Using LinearProgressIndicator as simple built-in buffered indicator
        LinearProgressIndicator(
            progress = { progress + 0.1f},
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .height(trackHeight),
            // small visual tweak: use theme color but faded
            color = playedTrackColor.copy(alpha = bufferAlpha),
            trackColor = ProgressIndicatorDefaults.linearTrackColor,
            strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
        )

        // Slider on top for actual seek control
        // We make inactive track transparent so the buffered bar underneath is visible.
        Slider(
            value = p,
            onValueChange = { onValueChange(it.coerceIn(0f, 1f)) },
            onValueChangeFinished = { onValueChangeFinished?.invoke() },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                // slightly fade the Slider's whole surface so it looks thinner if desired:
                .alpha(1f),
            colors = SliderDefaults.colors(
                thumbColor = thumbColor,
                activeTrackColor = playedTrackColor,           // played part
                inactiveTrackColor = Color.Transparent,        // so buffered bar shows under it
                activeTickColor = Color.Transparent,
                inactiveTickColor = Color.Transparent
            )
        )
    }
}
