package com.example.meditattionappuiexample.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.meditattionappuiexample.R
import com.example.meditattionappuiexample.data.models.SleepScreenCardDTO
import com.example.meditattionappuiexample.ui.screens.bottomnav.sleep_screen.SleepScreenViewModel

val cards = listOf(
    SleepScreenCardDTO(
        cardID = 1,
        imageResId = R.drawable.image_night_sleep,
        name = "Night Island",
        durationMinutes = 45,
        category = "SLEEP MUSIC",
        description = "Ease the mind into a restful night’s sleep  with\n" +
                "these deep, amblent tones.",
        favourites = 24234,
        listenings = 34234
    ),
    SleepScreenCardDTO(
        cardID = 2,
        imageResId = R.drawable.image_sweet_sleep,
        name = "Sweet Sleep",
        durationMinutes = 45,
        category = "SLEEP MUSIC",
        description = "Ease the mind into a restful night’s sleep  with\n" +
                "these deep, amblent tones.",
        favourites = 24234,
        listenings = 34234
    ),
    SleepScreenCardDTO(
        cardID = 3,
        imageResId = R.drawable.image_moon_clouds,
        name = "Moon Clouds",
        durationMinutes = 30,
        category = "SLEEP MUSIC",
        description = "Ease the mind into a restful night’s sleep  with\n" +
                "these deep, amblent tones.",
        favourites = 24234,
        listenings = 34234
    ),
    SleepScreenCardDTO(
        cardID = 4,
        imageResId = R.drawable.image_sweet_wleep,
        name = "Good Night",
        durationMinutes = 30,
        category = "SLEEP MUSIC",
        description = "Ease the mind into a restful night’s sleep  with\n" +
                "these deep, amblent tones.",
        favourites = 24234,
        listenings = 34234
    )
)

@Composable
fun SleepScreenList(
    globalNavController: NavHostController,
    sleepScreenViewModel: SleepScreenViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
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
                        SleepScreenCard(
                            sleepScreenCardDTO = card,
                            globalNavController = globalNavController,
                            sleepScreenViewModel = sleepScreenViewModel
                        )
                    }

                    if (rowCards.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
private fun SleepScreenListPreview() {
    SleepScreenList(
        globalNavController = rememberNavController(),
        sleepScreenViewModel = SleepScreenViewModel()
    )
}
