package com.luminay.hearthstoneinfo.features.cards.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.constants.HYPHEN
import com.example.core.ext.capitalizeFirstLetter
import com.example.core.ext.formatCardText
import com.example.domain.models.CardModel
import com.luminay.hearthstoneinfo.R
import com.luminay.hearthstoneinfo.features.cardlist.presentation.mocks.getMockCard
import com.luminay.hearthstoneinfo.theme.Gray80
import com.luminay.hearthstoneinfo.theme.HearthstoneInfoTheme
import com.luminay.hearthstoneinfo.ui.common.BulletPointLabelAndText
import com.luminay.hearthstoneinfo.ui.common.CardContainer

@Composable
fun CardDetails(
    card: CardModel,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(top = 100.dp)
            .fillMaxHeight()
            .fillMaxWidth()
            .background(
                Gray80,
                shape = RoundedCornerShape(
                    topEnd = 16.dp,
                    topStart = 16.dp,
                ),
            )
    ) {
        Column(
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(y = (-100).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardContainer(
                cardModel = card,
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp)
            )

            CardInfo(
                card = card,
            )
        }
    }
}

@Composable
private fun CardInfo(
    card: CardModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(
                top = 4.dp,
                end = 16.dp,
                bottom = 0.dp,
                start = 16.dp,
            ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = card.name,
            style = TextStyle(
                fontFamily = FontFamily(
                    Font(
                        R.font.belwe_bold,
                        FontWeight.Normal,
                    ),
                ),
                color = Color.White,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
            ),
        )

        if (card.flavor.isNotEmpty()) {
            Text(
                text = card.flavor,
                color = Color.Black,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                ),
            )
        }

        if (card.text.isNotEmpty()) {
            Text(
                text = card.text.formatCardText(),
                color = Color.White,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            BulletPointLabelAndText(
                label = stringResource(id = R.string.cost),
                text = card.cost.toString().ifEmpty { HYPHEN },
            )

            BulletPointLabelAndText(
                label = stringResource(id = R.string.attack),
                text = card.attack.toString().ifEmpty { HYPHEN },
            )

            BulletPointLabelAndText(
                label = stringResource(id = R.string.health),
                text = card.health.toString().ifEmpty { HYPHEN },
            )
        }

        card.apply {
            mapOf(
                stringResource(id = R.string.set) to cardSet.value,
                stringResource(id = R.string.type) to type.name.capitalizeFirstLetter(),
                stringResource(id = R.string.faction) to faction.name.capitalizeFirstLetter(),
                stringResource(id = R.string.rarity) to rarity.name.capitalizeFirstLetter(),
                stringResource(id = R.string.player_class) to playerClass.value,
            ).forEach {
                if (it.value.isNotEmpty()) {
                    BulletPointLabelAndText(
                        label = it.key,
                        text = it.value,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun CardDetailsPreview() {
    HearthstoneInfoTheme {
        Surface(
            color = Color.Transparent,
        ) {
            CardDetails(
                card = getMockCard()
            )
        }
    }
}

@Preview
@Composable
fun CardInfoPreview() {
    HearthstoneInfoTheme {
        Surface {
            CardInfo(
                card = getMockCard()
            )
        }
    }
}