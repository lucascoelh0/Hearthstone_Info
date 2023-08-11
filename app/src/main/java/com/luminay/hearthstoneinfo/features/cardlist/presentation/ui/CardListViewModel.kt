package com.luminay.hearthstoneinfo.features.cardlist.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.models.Resource
import com.example.domain.cards.IGetAllCardsUseCase
import com.example.domain.models.CardModel
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

    fun getCardsFlatMap(cards: Map<String, List<CardModel>>) = cards.entries
        .filter { (_, cardList) ->
            cardList.all { card ->
                card.img.isNotEmpty()
            }
        }.flatMap { entry ->
            listOf(entry.key) + entry.value
        }
}
