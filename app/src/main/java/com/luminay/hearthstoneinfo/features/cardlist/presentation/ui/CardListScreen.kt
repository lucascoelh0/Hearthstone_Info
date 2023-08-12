package com.luminay.hearthstoneinfo.features.cardlist.presentation.ui

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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
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
import com.luminay.hearthstoneinfo.theme.Yellow20
import com.luminay.hearthstoneinfo.ui.common.BottomSheet
import com.luminay.hearthstoneinfo.ui.common.ButtonWithDownArrow
import com.luminay.hearthstoneinfo.ui.common.CardContainer
import com.luminay.hearthstoneinfo.ui.common.HorizontalFullTextContainer

@ExperimentalMaterial3Api
@Composable
fun CardsListScreen(
    modifier: Modifier = Modifier,
    viewModel: CardListViewModel = hiltViewModel(),
) {
    val allCards by viewModel.allCards.collectAsStateWithLifecycle(initialValue = null)
    var searchTerm by remember { mutableStateOf(EMPTY) }
    var showDetailsBottomSheet by remember { mutableStateOf(false) }
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
        modifier = modifier,
        topBar = {
            TopBar(
                searchTerm = searchTerm,
                onQueryChange = {
                    searchTerm = it
                },
                onSearch = {
                    viewModel.fetchData()
                },
                onClickCardSet = {
                    TODO()
                },
            )
        },
        content = { padding ->
            CardsStatus(
                padding = padding,
                allCards = allCards,
                onRetry = {
                    viewModel.fetchData()
                },
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
                    color = Yellow20,
                )
            }

            Status.SUCCESS -> {

                CardsList(
                    cards = allCards.data,
                    onRetry = onRetry,
                    onCardClick = onCardClick,
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
    onSearch: (String) -> Unit,
    onClickCardSet: (CardSet) -> Unit,
    modifier: Modifier = Modifier,
) {
    var showCardSetDialog by remember { mutableStateOf(false) }
    var active by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        ButtonWithDownArrow(
            onClick = {
                showCardSetDialog = !showCardSetDialog
            },
            leftIcon = ImageVector.vectorResource(id = R.drawable.ic_card_set),
        )

        SearchBar(
            query = searchTerm,
            onQueryChange = onQueryChange,
            onSearch = onSearch,
            active = active,
            onActiveChange = { active = it },
            trailingIcon = {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_search
                    ),
                    contentDescription = stringResource(id = R.string.search),
                )
            },
        ) {

        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun TopBarPreview() {
    HearthstoneInfoTheme {
        TopBar(
            searchTerm = EMPTY,
            onSearch = {},
            onQueryChange = {},
            onClickCardSet = {},
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun CardsList(
    cards: Map<String, List<CardModel>>?,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
    onCardClick: (CardModel) -> Unit,
) {
    if (cards == null) {
        ErrorMessage(
            onRetry = { onRetry() }
        )
    } else {
        val flattenedCards = cards.flatMap { entry ->
            listOf(entry.key) + entry.value.filter { it.img.isNotEmpty() }
        }
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
        )

        Button(
            onClick = onRetry,
            modifier = Modifier.padding(top = 16.dp),
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
            )
        }

        is CardModel -> {
            if (item.img.isNotEmpty() &&
                item.name.isNotEmpty()
            ) {
                CardContainer(
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
        onCardClick = {},
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
