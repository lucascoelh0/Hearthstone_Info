package com.luminay.hearthstoneinfo.features.cardlist.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.models.Resource
import com.example.domain.cards.IGetAllCardsUseCase
import com.example.domain.models.CardModel
import com.example.domain.models.CardSet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardListViewModel @Inject constructor(
    private val getAllCardsUseCase: IGetAllCardsUseCase,
) : ViewModel() {

    private val _allCards = MutableStateFlow<Resource<Map<String, List<CardModel>>>>(Resource.loading(null))
    val allCards: Flow<Resource<Map<String, List<CardModel>>>> = _allCards.asStateFlow()

    lateinit var pressedCard: CardModel

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            flow {
                emit(Resource.loading(null))
                emitAll(getAllCardsUseCase())
            }.catch {
                Log.e("CardListViewModel", "fetchData: ", it)
            }.collect { result ->
                _allCards.value = result
            }
        }
    }

    fun getCardsFlattenedMap(
        cards: Map<String, List<CardModel>>,
        searchTerm: String,
    ): List<Any> {
        val filteredCards = cards.mapValues { (_, value) ->
            value.filter { card ->
                card.img.isNotEmpty() && (card.name.contains(searchTerm, ignoreCase = true) ||
                        (card.text.contains(searchTerm, ignoreCase = true) ||
                                card.cardSet.value.contains(searchTerm, ignoreCase = true)))
            }
        }.filter { (_, value) ->
            value.isNotEmpty()
        }

        return filteredCards.flatMap { entry ->
            listOf(entry.key) + entry.value
        }
    }

    fun filterCard(
        card: CardModel,
        searchTerm: String,
    ): Boolean {
        return card.img.isNotEmpty() &&
                card.cardSet != CardSet.UNKNOWN &&
                (card.name.contains(searchTerm, ignoreCase = true) ||
                        card.text.contains(searchTerm, ignoreCase = true))
    }
}
