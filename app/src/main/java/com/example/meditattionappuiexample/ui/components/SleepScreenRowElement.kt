package com.example.meditattionappuiexample.ui.components

import com.example.meditattionappuiexample.R
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditattionappuiexample.ui.theme.DarkTextPrimary
import com.example.meditattionappuiexample.ui.theme.HelveticaNeueFontFamily

@Composable
fun SleepScreenRowElement(
    modifier: Modifier,
    @StringRes stringResId: Int,
    @DrawableRes iconResId: Int,
    backgroundColor: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .size(60.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(iconResId),
                contentDescription = "icon",
                modifier = modifier.size(25.dp),
                tint = Color.White
            )
        }
        Spacer(Modifier.height(10.dp))
        Text(
            text = stringResource(stringResId),
            style = TextStyle(
                color = DarkTextPrimary,
                fontSize = 16.sp,
                fontFamily = HelveticaNeueFontFamily
            )
        )
    }

}


@Preview
@Composable
private fun SleepScreenRowElementPreview() {
    SleepScreenRowElement(
        Modifier,
        R.string.home,
        R.drawable.ic_home,
        Color(0xFF8E97FD)
    )
}