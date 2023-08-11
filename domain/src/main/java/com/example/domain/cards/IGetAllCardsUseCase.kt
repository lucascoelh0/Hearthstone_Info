package com.example.domain.cards

import com.example.core.models.Resource
import com.example.domain.models.CardModel
import kotlinx.coroutines.flow.Flow

fun interface IGetAllCardsUseCase {
    operator fun invoke(): Flow<Resource<Map<String, List<CardModel>>>>
}
