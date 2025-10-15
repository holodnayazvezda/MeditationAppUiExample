package com.example.meditattionappuiexample.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditattionappuiexample.R
import com.example.meditattionappuiexample.ui.theme.DarkHighlight
import com.example.meditattionappuiexample.ui.theme.DarkText
import com.example.meditattionappuiexample.ui.theme.DarkTextPrimary
import com.example.meditattionappuiexample.ui.theme.HelveticaNeueFontFamily

@Composable
fun OceanMoonBlock() {
    Box(
        Modifier.fillMaxWidth().padding(horizontal = 15.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.background_oceanmoon_block),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp))
            )
        }
        Column(
            modifier = Modifier.wrapContentSize().padding(horizontal = 15.dp)
        ) {
            Spacer(Modifier.height(15.dp))
            LockButton()
            Spacer(Modifier.height(15.dp))
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.oceanmoon),
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontFamily = HelveticaNeueFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = DarkHighlight
                    )
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.oceanmoon_info1) + "\n" + stringResource(R.string.oceanmoon_info2),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = HelveticaNeueFontFamily,
                        color = DarkTextPrimary
                    )
                )
                Spacer(Modifier.height(10.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = DarkTextPrimary)
                ) {
                    Text(
                        text = "START",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = HelveticaNeueFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = DarkText
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun OceanMoonBlockPreview() {
    OceanMoonBlock()
}