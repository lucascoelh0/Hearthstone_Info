package com.luminay.hearthstoneinfo.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.luminay.hearthstoneinfo.features.cardlist.presentation.ui.CardsListScreen
import com.luminay.hearthstoneinfo.theme.HearthstoneInfoTheme

@ExperimentalGlideComposeApi
@Composable
fun MainScreen() {
    HearthstoneInfoTheme {
        CardsListScreen(
            modifier = Modifier
                .fillMaxSize(),
        )
    }
}
