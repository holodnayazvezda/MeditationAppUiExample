package com.example.meditattionappuiexample.ui.screens.bottomnav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditattionappuiexample.R
import com.example.meditattionappuiexample.ui.components.OceanMoonBlock
import com.example.meditattionappuiexample.ui.components.SleepScreenList
import com.example.meditattionappuiexample.ui.components.SleepScreenRow
import com.example.meditattionappuiexample.ui.theme.DarkHeaderPrimary
import com.example.meditattionappuiexample.ui.theme.DarkTextPrimary
import com.example.meditattionappuiexample.ui.theme.HelveticaNeueFontFamily

@Composable
fun SleepScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(R.drawable.top_sleep_screen),
            contentDescription = "верхний фон экрана Screen",
            contentScale = ContentScale.Crop
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(65.dp))
        Text(
            text = stringResource(R.string.sleep_stories),
            style = TextStyle(
                fontSize = 25.sp,
                color = DarkHeaderPrimary,
                fontWeight = FontWeight.Bold,
                fontFamily = HelveticaNeueFontFamily,
                textAlign = TextAlign.Center
            )
        )
        Spacer(Modifier.height(15.dp))
        Text(
            text = stringResource(R.string.soothing_bedtime_1) +
                    "\n" + stringResource(R.string.soothing_bedtime_2),
            style = TextStyle(
                fontSize = 16.sp,
                color = DarkTextPrimary,
                fontFamily = HelveticaNeueFontFamily,
                textAlign = TextAlign.Center
            )
        )
        Spacer(Modifier.height(25.dp))
        SleepScreenRow()
        Spacer(Modifier.height(20.dp))
        OceanMoonBlock()
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SleepScreenList()
        }
    }
}