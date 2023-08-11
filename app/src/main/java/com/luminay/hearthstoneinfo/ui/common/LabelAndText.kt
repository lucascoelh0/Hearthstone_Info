package com.luminay.hearthstoneinfo.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LabelAndText(
    label: String,
    text: String,
    modifier: Modifier = Modifier,
    labelColor: Color = Color.White,
    textColor: Color = Color.White,
) {
    Row(
        modifier = modifier,
    ) {
        Text(
            text = "$label: ",
            color = labelColor,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = text,
            color = textColor,
        )
    }
}

@Preview
@Composable
fun PreviewLabelAndText() {
    LabelAndText(
        label = "Nome",
        text = "Fogo Fátuo",
    )
}
