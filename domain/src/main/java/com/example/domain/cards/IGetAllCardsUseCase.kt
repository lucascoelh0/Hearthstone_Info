package com.example.domain.cards

import com.example.domain.models.AllCardsModel
import kotlinx.coroutines.flow.Flow

fun interface IGetAllCardsUseCase {
    fun invoke(): Flow<com.example.core.models.Resource<AllCardsModel>>
}
