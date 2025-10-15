package com.example.meditattionappuiexample.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditattionappuiexample.R
import com.example.meditattionappuiexample.data.models.SleepScreenCardDTO
import com.example.meditattionappuiexample.ui.screens.bottomnav.SleepScreen
import com.example.meditattionappuiexample.ui.theme.DarkTextPrimary
import com.example.meditattionappuiexample.ui.theme.HelveticaNeueFontFamily

@Composable
fun SleepScreenList() {
    val cards = listOf(
        SleepScreenCardDTO(
            imageResId = R.drawable.image_night_sleep,
            name = "Night Island",
            durationMinutes = 45,
            category = "SLEEP MUSIC"
        ),
        SleepScreenCardDTO(
            imageResId = R.drawable.image_sweet_sleep,
            name = "Sweet Sleep",
            durationMinutes = 45,
            category = "SLEEP MUSIC"
        ),
        SleepScreenCardDTO(
            imageResId = R.drawable.image_moon_clouds,
            name = "Moon Clouds",
            durationMinutes = 30,
            category = "SLEEP MUSIC"
        ),
        SleepScreenCardDTO(
            imageResId = R.drawable.image_sweet_wleep,
            name = "Good Night",
            durationMinutes = 30,
            category = "SLEEP MUSIC"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            itemsIndexed(cards.chunked(2)) { _, rowCards ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    rowCards.forEach { card ->
                        SleepScreenCard(sleepScreenCardDTO = card)
                    }

                    if (rowCards.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun SleepScreenListPreview() {
    SleepScreenList()
}
