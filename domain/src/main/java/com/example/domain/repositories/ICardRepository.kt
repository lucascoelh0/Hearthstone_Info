package com.example.domain.repositories

import com.example.core.models.Resource
import com.example.domain.models.CardModel
import kotlinx.coroutines.flow.Flow

fun interface ICardRepository {
    fun getAllCards(): Flow<Resource<Map<String, List<CardModel>>>>
}
