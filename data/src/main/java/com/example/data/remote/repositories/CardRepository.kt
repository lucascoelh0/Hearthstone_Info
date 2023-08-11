package com.example.data.remote.repositories

import com.example.core.models.Resource
import com.example.data.remote.api.CardApi
import com.example.data.remote.models.toModel
import com.example.data.remote.utils.handleNetworkResponse
import com.example.domain.models.CardModel
import com.example.domain.repositories.ICardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardApi: CardApi,
) : ICardRepository {

    override fun getAllCards(): Flow<Resource<Map<String, List<CardModel>>>> {
        return flow {
            val response = cardApi.getAllCards()
            val resource = handleNetworkResponse(response) {
                it.toModel()
            }
            emit(resource)
        }
    }
}
