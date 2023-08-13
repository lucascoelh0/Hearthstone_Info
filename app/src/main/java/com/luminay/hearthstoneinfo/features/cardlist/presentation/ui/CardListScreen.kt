package com.luminay.hearthstoneinfo.features.cardlist.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.constants.EMPTY
import com.example.core.models.Resource
import com.example.core.models.Status
import com.example.domain.models.CardModel
import com.example.domain.models.CardSet
import com.luminay.hearthstoneinfo.R
import com.luminay.hearthstoneinfo.features.cardlist.presentation.mocks.getMockCardMap
import com.luminay.hearthstoneinfo.features.cards.presentation.ui.CardDetails
import com.luminay.hearthstoneinfo.theme.HearthstoneInfoTheme
import com.luminay.hearthstoneinfo.theme.Orange100
import com.luminay.hearthstoneinfo.theme.Orange20
import com.luminay.hearthstoneinfo.theme.Red100
import com.luminay.hearthstoneinfo.theme.Red90
import com.luminay.hearthstoneinfo.theme.Yellow20
import com.luminay.hearthstoneinfo.ui.common.BottomSheet
import com.luminay.hearthstoneinfo.ui.common.ButtonWithDownArrow
import com.luminay.hearthstoneinfo.ui.common.CardImage
import com.luminay.hearthstoneinfo.ui.common.HorizontalFullTextContainer
import com.luminay.hearthstoneinfo.ui.common.SearchBarWithBorder

@ExperimentalMaterial3Api
@Composable
fun CardsListScreen(
    modifier: Modifier = Modifier,
    viewModel: CardListViewModel = hiltViewModel(),
) {
    val allCards by viewModel.allCards.collectAsStateWithLifecycle(initialValue = null)
    var searchTerm by remember { mutableStateOf(EMPTY) }
    var showDetailsBottomSheet by remember { mutableStateOf(false) }
    var chosenCardSet by remember { mutableStateOf(CardSet.ALL) }
    if (showDetailsBottomSheet) {
        BottomSheet(
            onDismiss = { showDetailsBottomSheet = false },
            content = {
                CardDetails(
                    card = viewModel.pressedCard
                )
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }
    Scaffold(
        modifier = modifier.background(color = Orange20),
        topBar = {
            TopBar(
                searchTerm = searchTerm,
                onQueryChange = {
                    searchTerm = it
                },
                onClickCardSet = {
                    chosenCardSet = it
                },
                chosenCardSet = chosenCardSet,
                isSearchBarEnabled = allCards?.data is Map<*, *>,
            )
        },
        content = { padding ->
            CardsStatus(
                padding = padding,
                allCards = allCards,
                onRetry = {
                    viewModel.fetchData()
                },
                searchTerm = searchTerm,
                chosenCardSet = chosenCardSet,
                modifier = Modifier.fillMaxSize(),
                onCardClick = {
                    viewModel.pressedCard = it
                    showDetailsBottomSheet = true
                }
            )
        }
    )
}

@ExperimentalMaterial3Api
@Composable
fun CardsStatus(
    padding: PaddingValues,
    allCards: Resource<Map<String, List<CardModel>>>?,
    onRetry: () -> Unit,
    searchTerm: String,
    chosenCardSet: CardSet,
    modifier: Modifier = Modifier,
    onCardClick: (CardModel) -> Unit,
) {
    Column(
        modifier = modifier.padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (allCards?.status) {
            Status.LOADING -> {
                CircularProgressIndicator(
                    color = Red90,
                )
            }

            Status.SUCCESS -> {
                CardsList(
                    cards = allCards.data,
                    onRetry = onRetry,
                    searchTerm = searchTerm,
                    onCardClick = onCardClick,
                    chosenCardSet = chosenCardSet,
                )
            }

            else -> {
                ErrorMessage(
                    onRetry = onRetry,
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
private fun TopBar(
    searchTerm: String,
    onQueryChange: (String) -> Unit,
    onClickCardSet: (CardSet) -> Unit,
    chosenCardSet: CardSet,
    isSearchBarEnabled: Boolean,
    modifier: Modifier = Modifier,
) {
    var showCardSetDialog by remember { mutableStateOf(false) }

    if (showCardSetDialog) {
        CardSetDialog(
            showDialog = showCardSetDialog,
            chosenCardSet = chosenCardSet,
            onDismiss = {
                showCardSetDialog = false
            },
            onSetSelected = onClickCardSet,
            modifier = Modifier.background(color = Orange100)
        )
    }

    Column {
        Row(
            modifier = modifier
                .background(color = Red90)
                .padding(
                    top = 24.dp,
                    end = 8.dp,
                    bottom = 8.dp,
                    start = 8.dp,
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ButtonWithDownArrow(
                onClick = {
                    showCardSetDialog = showCardSetDialog.not()
                },
                leftIcon = ImageVector.vectorResource(id = R.drawable.ic_card_set),
            )

            SearchBarWithBorder(
                searchTerm = searchTerm,
                onQueryChange = onQueryChange,
                isEnabled = isSearchBarEnabled,
            )
        }
        Divider(
            color = Yellow20,
            thickness = 1.dp,
        )
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun TopBarPreview() {
    HearthstoneInfoTheme {
        TopBar(
            searchTerm = EMPTY,
            onQueryChange = {},
            onClickCardSet = {},
            chosenCardSet = CardSet.ALL,
            isSearchBarEnabled = true,
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun CardsList(
    cards: Map<String, List<CardModel>>?,
    onRetry: () -> Unit,
    searchTerm: String,
    chosenCardSet: CardSet,
    onCardClick: (CardModel) -> Unit,
    modifier: Modifier = Modifier,
    cardListViewModel: CardListViewModel = hiltViewModel(),
) {
    if (cards == null) {
        ErrorMessage(
            onRetry = { onRetry() }
        )
    } else {
        val flattenedCards = cardListViewModel.getCardsFlattenedMap(
            cards,
            searchTerm,
            chosenCardSet,
        )
        val state = rememberLazyGridState()
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            state = state,
            modifier = modifier,
        ) {
            itemsIndexed(
                items = flattenedCards,
                key = { _, item -> getGridItemKey(item) },
                span = { _, item -> getGridItemSpan(item) }
            ) { index, item ->
                CardGridItem(
                    index = index,
                    item = item,
                    onCardClick = onCardClick,
                )
            }
        }
    }
}

@Composable
fun ErrorMessage(
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(id = R.string.loading_error),
            color = Red90,
        )

        Button(
            onClick = onRetry,
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Red90,
            ),
        ) {
            Text(
                text = stringResource(id = R.string.try_again),
            )
        }
    }
}

private fun getGridItemKey(item: Any): Any {
    return when (item) {
        is String -> item
        is CardModel -> item.cardId
        else -> error("Unknown item type")
    }
}

private fun getGridItemSpan(item: Any): GridItemSpan {
    return when (item) {
        is String -> GridItemSpan(4)
        is CardModel -> GridItemSpan(1)
        else -> error("Unknown item type")
    }
}

@Composable
private fun CardGridItem(
    index: Int,
    item: Any,
    onCardClick: (CardModel) -> Unit,
) {
    when (item) {
        is String -> {
            HorizontalFullTextContainer(
                text = item,
                modifier = Modifier
                    .padding(
                        top = if (index == 0) 0.dp else 8.dp,
                        bottom = 8.dp,
                    )
                    .fillMaxWidth(),
                color = Red100,
            )
        }

        is CardModel -> {
            if (item.img.isNotEmpty() &&
                item.name.isNotEmpty()
            ) {
                CardImage(
                    cardModel = item,
                    modifier = Modifier
                        .padding(
                            top = 8.dp,
                            bottom = 8.dp,
                        )
                        .fillMaxWidth(),
                    onCardClick = onCardClick,
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewCardsList() {
    CardsList(
        cards = getMockCardMap(),
        onRetry = {},
        searchTerm = EMPTY,
        onCardClick = {},
        chosenCardSet = CardSet.ALL,
    )
}

@Preview
@Composable
fun PreviewErrorMessage() {
    HearthstoneInfoTheme {
        Surface {
            ErrorMessage(
                onRetry = {},
            )
        }
    }
}
