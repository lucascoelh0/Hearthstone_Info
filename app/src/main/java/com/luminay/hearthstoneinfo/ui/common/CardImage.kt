package com.luminay.hearthstoneinfo.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.domain.models.CardModel
import com.luminay.hearthstoneinfo.R
import com.luminay.hearthstoneinfo.features.cardlist.presentation.mocks.getMockCard
import com.luminay.hearthstoneinfo.utils.debugPlaceholder

@Composable
fun CardImage(
    cardModel: CardModel,
    modifier: Modifier = Modifier,
    onCardClick: (CardModel) -> Unit = {},
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .crossfade(true)
            .data(cardModel.img)
            .diskCacheKey("${cardModel.name} ${cardModel.img}")
            .networkCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .build(),
        contentDescription = stringResource(id = R.string.card_content_description),
        modifier = modifier
            .clickable {
                onCardClick(cardModel)
            },
        placeholder = debugPlaceholder(debugPreview = R.drawable.card_placeholder),
        contentScale = ContentScale.Fit,
    )
}

@Preview
@Composable
private fun CardImagePreview() {
    CardImage(
        cardModel = getMockCard(),
    )
}
