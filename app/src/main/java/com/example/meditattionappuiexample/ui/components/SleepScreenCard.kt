package com.example.meditattionappuiexample.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.meditattionappuiexample.R
import com.example.meditattionappuiexample.data.models.SleepScreenCardDTO
import com.example.meditattionappuiexample.domain.navigation.NavRoutes
import com.example.meditattionappuiexample.ui.theme.DarkTextPrimary
import com.example.meditattionappuiexample.ui.theme.GreyText
import com.example.meditattionappuiexample.ui.theme.HelveticaNeueFontFamily

@Composable
fun SleepScreenCard(
    sleepScreenCardDTO: SleepScreenCardDTO,
    globalNavController: NavHostController
) {
    Column(
        Modifier.wrapContentSize().clickable {
            globalNavController.previousBackStackEntry?.savedStateHandle?.set("cardDTO", sleepScreenCardDTO)
            globalNavController.navigate(NavRoutes.PLAY_OPTION_SCREEN.route)
        }
    ) {
        Image(
            painter = painterResource(sleepScreenCardDTO.imageResId),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .width(170.dp)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = sleepScreenCardDTO.name,
            style = TextStyle(
                color = DarkTextPrimary,
                fontFamily = HelveticaNeueFontFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = sleepScreenCardDTO.durationMinutes.toString() + " MIN  •  " + sleepScreenCardDTO.category,
            style = TextStyle(
                color = GreyText,
                fontFamily = HelveticaNeueFontFamily,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
            )
        )
    }
}


@Preview
@Composable
private fun SleepScreenCardPreview() {
    SleepScreenCard(
        SleepScreenCardDTO(
            imageResId = R.drawable.image_night_sleep,
            name = "Night Island",
            durationMinutes = 45,
            category = "SLEEP MUSIC",
            description = "Ease the mind into a restful night’s sleep  with\n" +
                    "these deep, amblent tones.",
            favourites = 24234,
            listenings = 34234
        ),
        rememberNavController()
    )
}