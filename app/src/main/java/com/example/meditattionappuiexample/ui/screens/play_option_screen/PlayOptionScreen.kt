package com.example.meditattionappuiexample.ui.screens.play_option_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.meditattionappuiexample.R
import com.example.meditattionappuiexample.domain.navigation.NavRoutes
import com.example.meditattionappuiexample.ui.components.SleepScreenCard
import com.example.meditattionappuiexample.ui.components.cards
import com.example.meditattionappuiexample.ui.screens.bottomnav.sleep_screen.SleepScreenViewModel
import com.example.meditattionappuiexample.ui.theme.DarkButtonText
import com.example.meditattionappuiexample.ui.theme.DarkHeaderPrimary
import com.example.meditattionappuiexample.ui.theme.DarkText
import com.example.meditattionappuiexample.ui.theme.DarkTextPrimary
import com.example.meditattionappuiexample.ui.theme.GreyText
import com.example.meditattionappuiexample.ui.theme.HelveticaNeueFontFamily

@Composable
fun PlayOptionScreen(
    navController: NavHostController,
    sleepScreenViewModel: SleepScreenViewModel,
    playOptionScreenViewModel: PlayOptionScreenViewModel,
    nextScreen: () -> Unit
) {
    val selectedCard = cards.find { it.cardID == sleepScreenViewModel.selectedItemId.value }
    if (selectedCard != null) {
        playOptionScreenViewModel.updateSelectedCardDTO(selectedCard)
        Column(
            Modifier.fillMaxWidth()
        ) {
            Box(
                Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(selectedCard.imageResId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(50.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = DarkTextPrimary
                            ),
                            modifier = Modifier.size(55.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.arrow_back),
                                contentDescription = null,
                                Modifier.size(25.dp),
                                tint = DarkText
                            )
                        }
                        Row {
                            IconButton(
                                onClick = {
                                    navController.navigate(NavRoutes.MAIN_SCREEN.route)
                                },
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = DarkText
                                ),
                                modifier = Modifier
                                    .size(55.dp)
                                    .alpha(0.6f)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.heart),
                                    contentDescription = null,
                                    Modifier.size(25.dp),
                                    tint = Color.White
                                )
                            }
                            Spacer(Modifier.width(15.dp))
                            IconButton(
                                onClick = {

                                },
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = DarkText
                                ),
                                modifier = Modifier
                                    .size(55.dp)
                                    .alpha(0.6f)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.download),
                                    contentDescription = null,
                                    Modifier.size(25.dp),
                                    tint = Color.Unspecified
                                )
                            }
                        }
                    }
                }
            }

            Column(
                Modifier.fillMaxWidth().padding(horizontal = 18.dp)
            ) {
                // блок с информацией о треке
                Box(
                    Modifier.fillMaxWidth().weight(0.4f)
                ) {
                    Column(
                        Modifier.fillMaxWidth()
                    ) {
                        Spacer(Modifier.height(35.dp))
                        Text(
                            text = selectedCard.name,
                            style = TextStyle(
                                color = DarkHeaderPrimary,
                                fontWeight = FontWeight.Bold,
                                fontFamily = HelveticaNeueFontFamily,
                                fontSize = 34.sp
                            )
                        )
                        Spacer(Modifier.height(17.dp))
                        Text(
                            text = "${selectedCard.durationMinutes} MIN  •  ${selectedCard.category}",
                            style = TextStyle(
                                color = GreyText,
                                fontFamily = HelveticaNeueFontFamily,
                                fontSize = 16.sp
                            )
                        )
                        Spacer(Modifier.height(17.dp))
                        Text(
                            text = selectedCard.description,
                            style = TextStyle(
                                color = GreyText,
                                fontFamily = HelveticaNeueFontFamily,
                                fontSize = 16.sp
                            )
                        )
                        Spacer(Modifier.height(35.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painterResource(R.drawable.heart_filled),
                                contentDescription = null,
                                modifier = Modifier.size(23.dp)
                            )
                            Spacer(Modifier.width(5.dp))
                            Text(
                                text = "${
                                    "%,d".format(selectedCard.favourites).replace(",", ".")
                                } Favorits",
                                style = TextStyle(
                                    color = DarkTextPrimary,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                    fontFamily = HelveticaNeueFontFamily
                                )
                            )
                            Spacer(Modifier.width(80.dp))
                            Icon(
                                painterResource(R.drawable.headphones_filled),
                                contentDescription = null,
                                modifier = Modifier.size(23.dp)
                            )
                            Spacer(Modifier.width(5.dp))
                            Text(
                                text = "${
                                    "%,d".format(selectedCard.listenings)
                                        .replace(",", ".")
                                } Lestening",
                                style = TextStyle(
                                    color = DarkTextPrimary,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                    fontFamily = HelveticaNeueFontFamily
                                )
                            )
                        }
                        Spacer(Modifier.height(30.dp))
                        Box(
                            Modifier.fillMaxWidth().height(1.dp).background(Color(0xFF98A1BD))
                                .alpha(0.85f)
                        )
                    }
                }
                Spacer(Modifier.height(20.dp))
                // блок с ранее прослушиваемыми треками
                Box(
                    Modifier.fillMaxWidth().weight(0.45f)
                ) {
                    Column(
                        Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Related",
                            style = TextStyle(
                                color = DarkHeaderPrimary,
                                fontWeight = FontWeight(400),
                                fontFamily = HelveticaNeueFontFamily,
                                fontSize = 24.sp
                            )
                        )
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
                                            globalNavController = navController,
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
//              // блок с кнопкой "проиграть"
                Box(
                    Modifier
                        .fillMaxWidth()
                        .weight(0.18f)
                ) {
                    Column(
                        Modifier.fillMaxWidth()
                    ) {
                        Spacer(Modifier.height(10.dp))
                        Button(
                            onClick = {
                                nextScreen()
                                navController.popBackStack()
                            },
                            modifier = Modifier.fillMaxWidth().height(60.dp),
                        ) {
                            Text(
                                text = "PLAY",
                                style = TextStyle(
                                    fontFamily = HelveticaNeueFontFamily,
                                    fontWeight = FontWeight(500),
                                    fontSize = 14.sp,
                                    color = DarkButtonText
                                ),
                            )
                        }
                    }
                }
            }
        }
    }
}