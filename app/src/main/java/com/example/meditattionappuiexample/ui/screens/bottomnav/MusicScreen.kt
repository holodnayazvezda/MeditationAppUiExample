package com.example.meditattionappuiexample.ui.screens.bottomnav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.meditattionappuiexample.R
import com.example.meditattionappuiexample.ui.components.SelfMusicSeekBar
import com.example.meditattionappuiexample.ui.components.SimpleMusicSeekBar
import com.example.meditattionappuiexample.ui.screens.play_option_screen.PlayOptionScreenViewModel
import com.example.meditattionappuiexample.ui.theme.DarkButton
import com.example.meditattionappuiexample.ui.theme.DarkHeaderPrimary
import com.example.meditattionappuiexample.ui.theme.DarkSurface
import com.example.meditattionappuiexample.ui.theme.DarkText
import com.example.meditattionappuiexample.ui.theme.DarkTextPrimary
import com.example.meditattionappuiexample.ui.theme.GreyText
import com.example.meditattionappuiexample.ui.theme.HelveticaNeueFontFamily

@Composable
fun MusicScreen(
    playOptionScreenViewModel: PlayOptionScreenViewModel,
    bottomNavController: NavHostController

) {
    val selectedCardData = playOptionScreenViewModel.selectedCardDTO.collectAsState().value
    var isMusicPlayed by remember { mutableStateOf(true) }
    var position by remember { mutableStateOf(0.1f) }
    var buffered by remember { mutableStateOf(0.75f) }

    Box(
        Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.music_background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier.fillMaxSize().padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(40.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {
                        bottomNavController.popBackStack()
                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = DarkTextPrimary
                    ),
                    modifier = Modifier.size(55.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.close),
                        contentDescription = null,
                        Modifier.size(20.dp),
                        tint = DarkText
                    )
                }
                Row {
                    IconButton(
                        onClick = {
                        },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = DarkSurface
                        ),
                        modifier = Modifier
                            .size(55.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.heart),
                            contentDescription = null,
                            Modifier.size(20.dp),
                            tint = Color.White
                        )
                    }
                    Spacer(Modifier.width(15.dp))
                    IconButton(
                        onClick = {

                        },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = DarkSurface
                        ),
                        modifier = Modifier
                            .size(55.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.download),
                            contentDescription = null,
                            Modifier.size(20.dp),
                            tint = Color.White
                        )
                    }
                }
            }
            Spacer(Modifier.height(250.dp))
            Text(
                text = selectedCardData.name,
                style = TextStyle(
                    fontFamily = HelveticaNeueFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 34.sp,
                    color = DarkHeaderPrimary
                )
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = selectedCardData.category,
                style = TextStyle(
                    fontFamily = HelveticaNeueFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = GreyText
                )
            )
            Spacer(Modifier.height(70.dp))
            Row(
                Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        position = (position - 0.05f).coerceAtLeast(0f)
                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.back_15),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                        tint = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(110.dp)
                        .clip(CircleShape)
                        .background(DarkHeaderPrimary.copy(alpha = 0.3f)),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape)
                            .background(DarkHeaderPrimary),
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(
                            onClick = {
                                isMusicPlayed = !isMusicPlayed
                            },
                            colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Transparent)
                        ) {
                            Icon(
                                painter = painterResource(
                                    if (isMusicPlayed) {
                                        R.drawable.pause
                                    } else {
                                        R.drawable.outline_autoplay_24
                                    }
                                ),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                tint = DarkText
                            )
                        }

                    }
                }

                IconButton(
                    onClick = {
                        position = (position + 0.05f)
                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.forward_15),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                        tint = Color.White
                    )
                }
            }
            Spacer(Modifier.height(55.dp))
//            Column(
//                Modifier.fillMaxWidth().padding(horizontal = 20.dp)
//            ) {
//                SimpleMusicSeekBar(
//                    progress = position,
//                    buffered = buffered,
//                    onValueChange = { new ->
//                        position = new
//                    },
//                    modifier = Modifier.fillMaxWidth()
//                )
//
//            }
            Row(
                Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth().background(Color.White).height(2.dp).weight(0.12f)
                )
                Box(
                    modifier = Modifier.clip(CircleShape).background(DarkButton.copy(alpha = 0.35f)).size(17.dp).weight(0.05f),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier.clip(CircleShape).background(DarkButton).size(13.dp),
                    )
                }
                Box(
                    modifier = Modifier.fillMaxWidth().alpha(0.5f).background(Color(0xFF47557E)).height(2.dp).weight(0.83f)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "01:30",
                    style = TextStyle(
                        color = DarkHeaderPrimary,
                        fontFamily = HelveticaNeueFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                    )
                )
                Text(
                    text = "45:00",
                    style = TextStyle(
                        color = DarkHeaderPrimary,
                        fontFamily = HelveticaNeueFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}