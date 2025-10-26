package com.example.meditattionappuiexample.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditattionappuiexample.R
import com.example.meditattionappuiexample.ui.theme.DarkButtonText
import com.example.meditattionappuiexample.ui.theme.DarkHeaderPrimary
import com.example.meditattionappuiexample.ui.theme.DarkHeaderSecondary
import com.example.meditattionappuiexample.ui.theme.DarkTextPrimary
import com.example.meditattionappuiexample.ui.theme.HelveticaNeueFontFamily

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    nextScreen: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.welcome_background),
            modifier = Modifier.matchParentSize(),
            contentDescription = "background image",
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(150.dp))
            Text(
                text = stringResource(R.string.welcome_to_sleep),
                style = TextStyle(
                    color = DarkHeaderPrimary,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = HelveticaNeueFontFamily,
                    shadow = Shadow(
                        color = DarkHeaderSecondary,
                        offset = Offset(2f, 2f),
                        blurRadius = 3f
                    )
                )
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Explore the new king of sleep. It uses sound\n" +
                        "and visualization to create perfect conditions\n" +
                        "for refreshing sleep.",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = DarkTextPrimary,
                    fontFamily = HelveticaNeueFontFamily,
                    textAlign = TextAlign.Center
                )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize().weight(0.5f),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    painter = painterResource(R.drawable.birds),
                    contentDescription = "птички",
                    contentScale = ContentScale.Fit
                )
            }

            Column(
                modifier = Modifier.fillMaxSize().weight(0.4f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(150.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp)
                        .height(60.dp),
                    onClick = {
                        nextScreen()
                    }
                ) {
                    Text(
                        text = stringResource(R.string.get_started),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = DarkButtonText,
                            fontFamily = HelveticaNeueFontFamily
                        )
                    )
                }
                Spacer(Modifier.height(100.dp))

            }
        }
    }
}