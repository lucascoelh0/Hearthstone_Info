package com.luminay.hearthstoneinfo.domain.repositories

import com.luminay.hearthstoneinfo.core.models.Resource
import com.luminay.hearthstoneinfo.domain.models.AllCardsModel
import kotlinx.coroutines.flow.Flow

fun interface ICardRepository {
    fun getAllCards(): Flow<Resource<AllCardsModel>>
}
