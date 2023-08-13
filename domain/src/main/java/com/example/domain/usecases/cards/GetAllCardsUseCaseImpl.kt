package com.example.domain.usecases.cards

import com.example.core.models.Resource
import com.example.domain.models.CardModel
import com.example.domain.repositories.ICardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCardsUseCaseImpl @Inject constructor(
    private val cardRepository: ICardRepository,
) : IGetAllCardsUseCase {
    override fun invoke(): Flow<Resource<Map<String, List<CardModel>>>> {
        return cardRepository.getAllCards()
    }
}
