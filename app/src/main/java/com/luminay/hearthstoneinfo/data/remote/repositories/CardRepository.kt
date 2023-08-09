package com.luminay.hearthstoneinfo.data.remote.repositories

import com.luminay.hearthstoneinfo.core.models.Resource
import com.luminay.hearthstoneinfo.data.remote.api.CardApi
import com.luminay.hearthstoneinfo.data.remote.models.toAllCardsModel
import com.luminay.hearthstoneinfo.data.remote.utils.handleNetworkResponse
import com.luminay.hearthstoneinfo.domain.models.AllCardsModel
import com.luminay.hearthstoneinfo.domain.repositories.ICardRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CardRepositoryImpl @Inject constructor(
    private val cardApi: CardApi,
) : ICardRepository {

    override fun getAllCards(): Flow<Resource<AllCardsModel>> {
        return flow {
            val response = cardApi.getAllCards()
            val resource = handleNetworkResponse(response) {
                it.toAllCardsModel()
            }
            emit(resource)
        }
    }
}
