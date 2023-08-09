package com.luminay.hearthstoneinfo.domain.usecases.cards

import com.luminay.hearthstoneinfo.core.models.Resource
import com.luminay.hearthstoneinfo.domain.models.AllCardsModel
import kotlinx.coroutines.flow.Flow

fun interface IGetAllCardsUseCase {
    fun invoke(): Flow<Resource<AllCardsModel>>
}
