package com.example.meditattionappuiexample.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max

/**
 * Музыкальный scrubber / seek bar.
 *
 * @param progress 0f..1f текущая позиция
 * @param buffered 0f..1f buffered позиция (опционально)
 * @param onValueChange вызывается во время drag/tap с новым значением 0f..1f
 * @param modifier стиль
 * @param trackHeight высота фоновой полосы
 * @param playedTrackHeight высота прогресс-полосы (может совпадать с trackHeight)
 * @param thumbRadius радиус большого круга
 * @param innerDotRadius радиус маленькой внутренней точки
 * @param colors настройки цветов
 */
@Composable
fun MusicSeekBar(
    progress: Float,
    buffered: Float = 0f,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth(),
    trackHeight: Dp = 4.dp,
    playedTrackHeight: Dp = 4.dp,
    thumbRadius: Dp = 12.dp,
    innerDotRadius: Dp = 5.dp,
    colors: SeekBarColors = SeekBarColors()
) {
    // clamp inputs
    val safeProgress = progress.coerceIn(0f, 1f)
    val safeBuffered = buffered.coerceIn(0f, 1f)

    // animate thumb position for smooth movement when progress changes externally
    val animatedProgress by animateFloatAsState(targetValue = safeProgress)

    val density = LocalDensity.current
    val trackHeightPx = with(density) { trackHeight.toPx() }
    val playedTrackHeightPx = with(density) { playedTrackHeight.toPx() }
    val thumbRadiusPx = with(density) { thumbRadius.toPx() }
    val innerDotRadiusPx = with(density) { innerDotRadius.toPx() }

    Box(
        modifier = modifier
            .height(max(thumbRadius * 2, trackHeight))
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { offset ->
                        // handle immediate jump to touch point on start
                        val x = offset.x
                        val w = size.width
                        val new = (x / w).coerceIn(0f, 1f)
                        onValueChange(new)
                    },
                    onDrag = { change, _ ->
                        val x = change.position.x
                        val w = size.width
                        val new = (x / w).coerceIn(0f, 1f)
                        onValueChange(new)
                        change.consume()
                    }
                )
            }
            .pointerInput(Unit) { // tap to seek
                detectTapGestures { offset ->
                    val new = (offset.x / size.width).coerceIn(0f, 1f)
                    onValueChange(new)
                }
            },
        contentAlignment = Alignment.CenterStart
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val centerY = size.height / 2f

            // background track (full length)
            drawRoundRect(
                color = colors.trackColor,
                topLeft = Offset(0f, centerY - trackHeightPx / 2f),
                size = androidx.compose.ui.geometry.Size(width, trackHeightPx),
                cornerRadius = CornerRadius(trackHeightPx / 2f, trackHeightPx / 2f)
            )

            // buffered track (secondary)
            if (safeBuffered > 0f) {
                val bufferedW = width * safeBuffered
                drawRoundRect(
                    color = colors.bufferedColor,
                    topLeft = Offset(0f, centerY - trackHeightPx / 2f),
                    size = androidx.compose.ui.geometry.Size(bufferedW, trackHeightPx),
                    cornerRadius = CornerRadius(trackHeightPx / 2f, trackHeightPx / 2f)
                )
            }

            // played track (primary progress)
            val playedW = width * animatedProgress
            val playedTop = centerY - playedTrackHeightPx / 2f
            drawRoundRect(
                brush = Brush.horizontalGradient(colors.playedGradient),
                topLeft = Offset(0f, playedTop),
                size = androidx.compose.ui.geometry.Size(playedW, playedTrackHeightPx),
                cornerRadius = CornerRadius(playedTrackHeightPx / 2f, playedTrackHeightPx / 2f)
            )

            // thumb center position
            val cx = (width * animatedProgress).coerceIn(0f, width)
            val cy = centerY

            // draw outer thumb (circle with subtle shadow)
            drawCircle(
                color = colors.thumbBorderColor,
                radius = thumbRadiusPx + 2f, // border
                center = Offset(cx, cy),
                alpha = 0.08f
            )
            drawCircle(
                color = colors.thumbOuterColor,
                radius = thumbRadiusPx,
                center = Offset(cx, cy)
            )

            // inner small dot
            drawCircle(
                color = colors.thumbInnerColor,
                radius = innerDotRadiusPx,
                center = Offset(cx, cy)
            )
        }
    }
}

/** simple holder for color customization */
data class SeekBarColors(
    val trackColor: Color = Color(0xFF2B2B3A), // background thin track
    val bufferedColor: Color = Color(0x55121212), // translucent
    val playedGradient: List<Color> = listOf(Color(0xFF7C4DFF), Color(0xFF6A3BFF)), // purple-ish gradient
    val thumbOuterColor: Color = Color(0xFF7C4DFF),
    val thumbInnerColor: Color = Color.White,
    val thumbBorderColor: Color = Color.Black
)
