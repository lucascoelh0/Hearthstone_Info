package com.luminay.hearthstoneinfo.domain.usecases.cards

import com.luminay.hearthstoneinfo.core.models.Resource
import com.luminay.hearthstoneinfo.domain.models.AllCardsModel
import com.luminay.hearthstoneinfo.domain.repositories.ICardRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetAllCardsUseCaseImpl @Inject constructor(
    private val cardRepository: ICardRepository,
) : IGetAllCardsUseCase {
    override fun invoke(): Flow<Resource<AllCardsModel>> {
        return cardRepository.getAllCards()
    }
}
