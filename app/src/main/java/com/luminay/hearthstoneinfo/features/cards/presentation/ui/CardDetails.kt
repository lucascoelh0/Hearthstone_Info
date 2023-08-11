package com.luminay.hearthstoneinfo.features.cards.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.domain.models.CardModel
import com.luminay.hearthstoneinfo.features.cardlist.presentation.mocks.getMockCard
import com.luminay.hearthstoneinfo.ui.common.CardContainer

@Composable
fun CardDetails(
    card: CardModel,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardContainer(
                cardModel = card,
                modifier = Modifier
                    .offset(y = (-50).dp)
                    .height(100.dp)
                    .width(100.dp),
            )

            if (card.flavor.isNotEmpty()) {
                Text(
                    text = card.name
                )
            }

            if (card.text.isNotEmpty()) {
                Text(
                    text = card.text
                )
            }

            if (card.cardSet.isNotEmpty()) {
                Text(
                    text = card.cardSet
                )
            }

            if (card.type.isNotEmpty()) {
                Text(
                    text = card.type
                )
            }

            if (card.faction.isNotEmpty()) {
                Text(
                    text = card.faction
                )
            }

            if (card.rarity.isNotEmpty()) {
                Text(
                    text = card.rarity
                )
            }

            Text(
                text = card.attack.toString()
            )

            Text(
                text = card.cost.toString()
            )

            Text(
                text = card.health.toString()
            )
        }
    }
}

@Preview
@Composable
fun CardDetailsPreview() {
    CardDetails(
        card = getMockCard()
    )
}