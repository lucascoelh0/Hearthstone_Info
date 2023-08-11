package com.luminay.hearthstoneinfo.ui.common

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.domain.models.CardModel
import com.luminay.hearthstoneinfo.R
import com.luminay.hearthstoneinfo.features.cardlist.presentation.mocks.getMockCard
import com.luminay.hearthstoneinfo.utils.debugPlaceholder

@Composable
fun CardContainer(
    cardModel: CardModel,
    modifier: Modifier = Modifier,
    onCardClick: (CardModel) -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                Log.e("CardContainer", "CardContainer: " + cardModel.img)
                onCardClick(cardModel)
            },
    ) {
        Log.e("CardContainer", "CardContainer: ${cardModel.name} " + cardModel.img)
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
            modifier = Modifier.fillMaxSize(),
            placeholder = debugPlaceholder(debugPreview = R.drawable.card_placeholder),
            contentScale = ContentScale.Crop,
            onError = {
                Log.e("CardContainer Porra", "CardContainer: " + it)
            },
        )
    }
}

@Preview
@Composable
fun CardContainerPreview() {
    CardContainer(
        cardModel = getMockCard(),
    )
}
