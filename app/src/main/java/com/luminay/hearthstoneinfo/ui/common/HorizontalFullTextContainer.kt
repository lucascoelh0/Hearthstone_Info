package com.luminay.hearthstoneinfo.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminay.hearthstoneinfo.theme.Gray40

@Composable
fun HorizontalFullTextContainer(
    text: String,
    modifier: Modifier = Modifier,
    textSize: TextUnit = 16.sp,
    textColor: Color = Color.White,
    color: Color = Gray40,
) {
    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = color,
            )
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp,
            ),
        fontSize = textSize,
        color = textColor,
    )
}

@Preview
@Composable
fun PreviewHorizontalFullTextContainer() {
    HorizontalFullTextContainer(
        text = "Leader skill",
    )
}
