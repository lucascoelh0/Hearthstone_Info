package com.luminay.hearthstoneinfo.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.luminay.hearthstoneinfo.theme.Yellow20

@Composable
fun BulletPointLabelAndText(
    label: String,
    text: String,
    modifier: Modifier = Modifier,
    labelColor: Color = Yellow20,
    textColor: Color = Color.White,
) {
    Row(
        modifier = modifier,
    ) {
        LabelAndText(
            label = "• $label",
            text = text,
            labelColor = labelColor,
            textColor = textColor,
        )
    }
}

@Preview
@Composable
fun PreviewBulletPointLabelAndText() {
    BulletPointLabelAndText(
        label = "Nome",
        text = "Fogo Fátuo",
    )
}
