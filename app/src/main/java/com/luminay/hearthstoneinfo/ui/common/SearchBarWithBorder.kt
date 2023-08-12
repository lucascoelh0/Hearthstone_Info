package com.luminay.hearthstoneinfo.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminay.hearthstoneinfo.R
import com.luminay.hearthstoneinfo.theme.Brown20
import com.luminay.hearthstoneinfo.theme.Gray80
import com.luminay.hearthstoneinfo.theme.HearthstoneInfoTheme
import com.luminay.hearthstoneinfo.theme.Orange80
import com.luminay.hearthstoneinfo.theme.Red90

@Composable
fun SearchBarWithBorder(
    searchTerm: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    borderColor: Color = Orange80,
    isEnabled: Boolean = true,
) {
    Box(
        modifier = modifier
            .scale(scaleY = 0.9F, scaleX = 1F)
            .background(Color.Transparent)
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(32.dp),
            )
    ) {
        TextField(
            value = searchTerm,
            onValueChange = {
                onQueryChange(it)
            },
            enabled = isEnabled,
            modifier = Modifier
                .padding(vertical = 0.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(
                color = Color.White,
                fontFamily = FontFamily(
                    Font(R.font.belwe_bold)
                ),
                fontSize = 16.sp,
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Red90,
                unfocusedContainerColor = Red90,
                disabledContainerColor = Gray80,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(32.dp),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search),
                    color = Brown20
                )
            },
            singleLine = true,
        )
    }
}

@Preview
@Composable
fun PreviewSearchBarWithBorder() {
    HearthstoneInfoTheme {
        SearchBarWithBorder(
            searchTerm = "",
            onQueryChange = {},
        )
    }
}
