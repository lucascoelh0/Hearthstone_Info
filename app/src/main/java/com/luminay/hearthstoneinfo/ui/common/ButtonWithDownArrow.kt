package com.luminay.hearthstoneinfo.ui.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminay.hearthstoneinfo.R
import com.luminay.hearthstoneinfo.theme.Orange20
import com.luminay.hearthstoneinfo.theme.Orange80
import com.luminay.hearthstoneinfo.theme.Red90
import com.luminay.hearthstoneinfo.theme.Yellow30
import com.luminay.hearthstoneinfo.theme.Yellow90

@Composable
fun ButtonWithDownArrow(
    onClick: () -> Unit,
    leftIcon: ImageVector,
    modifier: Modifier = Modifier,
    leftIconColor: Color = Yellow90,
    leftIconBackgroundColor: Color = Red90,
    rightIconColor: Color = Red90,
    borderColor: Color = Orange80,
    borderActiveColor: Color = Color.White,
    backgroundColor: Color = Orange20,
    backgroundActiveColor: Color = Yellow30,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState().value

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPressed) backgroundActiveColor else backgroundColor,
            contentColor = Color.Transparent,
        ),
        border = BorderStroke(
            2.dp,
            if (isPressed) borderActiveColor else borderColor
        ),
        modifier = modifier
            .height(32.dp)
            .width(64.dp),
        contentPadding = PaddingValues(0.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .size(32.dp)
                    .background(
                        color = leftIconBackgroundColor,
                        shape = CircleShape,
                    )
                    .border(
                        width = 2.dp,
                        color = if (isPressed) borderActiveColor else borderColor,
                        shape = CircleShape,
                    ),
            ) {
                Icon(
                    imageVector = leftIcon,
                    tint = leftIconColor,
                    modifier = Modifier
                        .padding(8.dp)
                        .heightIn(min = 16.dp),
                    contentDescription = null,
                )
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 4.dp),
                tint = rightIconColor,
            )
        }
    }
}

@Preview
@Composable
private fun ButtonWithDownArrowPreview() {
    ButtonWithDownArrow(
        onClick = {},
        leftIcon = ImageVector.vectorResource(id = R.drawable.ic_card_set),
    )
}
