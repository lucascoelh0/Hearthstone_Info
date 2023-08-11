package com.luminay.hearthstoneinfo.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luminay.hearthstoneinfo.features.cardlist.presentation.ui.CardsListScreen
import com.luminay.hearthstoneinfo.theme.HearthstoneInfoTheme

@ExperimentalMaterial3Api
@Composable
fun MainScreen() {
    HearthstoneInfoTheme {
        CardsListScreen(
            modifier = Modifier.fillMaxSize(),
        )
    }
}
