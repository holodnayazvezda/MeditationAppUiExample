package com.example.meditattionappuiexample.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditattionappuiexample.R
import com.example.meditattionappuiexample.ui.theme.DarkAccent

@Composable
fun SleepScreenRow() {
    val cardsData = listOf(
        SleepScreenRowItem(stringResId = R.string.all, iconResId = R.drawable.all),
        SleepScreenRowItem(stringResId = R.string.my, iconResId = R.drawable.my),
        SleepScreenRowItem(stringResId = R.string.anxious, iconResId = R.drawable.anxious),
        SleepScreenRowItem(stringResId = R.string.sleep, iconResId = R.drawable.sleep),
        SleepScreenRowItem(stringResId = R.string.kids, iconResId = R.drawable.kids)
    )

    var selectedIndex by remember { mutableStateOf(0) }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        itemsIndexed(cardsData) { index, item ->
            val isSelected = index == selectedIndex

            SleepScreenRowElement(
                stringResId = item.stringResId,
                iconResId = item.iconResId,
                backgroundColor = if (isSelected) DarkAccent else Color(0xFF98A1BD),
                modifier = Modifier
                    .clickable { selectedIndex = index }
            )
        }
    }
}


@Preview
@Composable
private fun SleepScreenRowPreview() {
    SleepScreenRow()
}