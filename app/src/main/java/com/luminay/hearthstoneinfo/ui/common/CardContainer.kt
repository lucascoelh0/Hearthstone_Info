package com.luminay.hearthstoneinfo.ui.common

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.domain.models.CardModel
import com.luminay.hearthstoneinfo.R
import com.luminay.hearthstoneinfo.features.cardlist.presentation.mocks.getMockCard

@ExperimentalGlideComposeApi
@Composable
fun CardContainer(
    cardModel: CardModel,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                Log.e("CardContainer", "CardContainer: " + cardModel.img)
            },
    ) {
        GlideImage(
            model = cardModel.img,
            contentDescription = stringResource(id = R.string.card_content_description),
            contentScale = ContentScale.Crop,
        )
    }
}

@ExperimentalGlideComposeApi
@Preview
@Composable
fun CardContainerPreview() {
    CardContainer(
        cardModel = getMockCard(),
    )
}
