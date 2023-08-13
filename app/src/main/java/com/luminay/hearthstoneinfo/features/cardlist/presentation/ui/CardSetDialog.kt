package com.luminay.hearthstoneinfo.features.cardlist.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.models.CardSet
import com.luminay.hearthstoneinfo.theme.Gray80
import com.luminay.hearthstoneinfo.theme.Orange80

@ExperimentalMaterial3Api
@Composable
fun CardSetDialog(
    showDialog: Boolean,
    chosenCardSet: CardSet,
    onDismiss: () -> Unit,
    onSetSelected: (CardSet) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                onDismiss()
            },
            modifier = modifier
                .background(Gray80),
        ) {
            LazyColumn {
                items(CardSet.values()) { cardSet ->
                    RadioButtonLabel(
                        cardSet = cardSet,
                        chosenCardSet = chosenCardSet,
                        onClick = {
                            onSetSelected(cardSet)
                            onDismiss()
                        },
                    )
                }
            }
        }
    }
}

@Composable
private fun RadioButtonLabel(
    cardSet: CardSet,
    chosenCardSet: CardSet,
    onClick: (CardSet) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick(cardSet)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = chosenCardSet == cardSet,
            onClick = {
                onClick(cardSet)
            },
            colors = RadioButtonDefaults.colors(
                selectedColor = Orange80,
                unselectedColor = Color.White,
            ),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = cardSet.value,
            color = Color.White,
        )
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun CardSetDialogPreview() {
    CardSetDialog(
        showDialog = true,
        chosenCardSet = CardSet.CLASSIC,
        onDismiss = {},
        onSetSelected = {},
    )
}

@Preview
@Composable
fun RadioButtonLabelPreview() {
    RadioButtonLabel(
        cardSet = CardSet.CLASSIC,
        chosenCardSet = CardSet.CLASSIC,
        onClick = {},
    )
}
