package com.luminay.hearthstoneinfo.data.remote.models

import com.luminay.hearthstoneinfo.domain.models.AllCardsModel

data class AllCardsDto(
    val cards: Map<String, CardDto>? = null,
)

fun AllCardsDto.toAllCardsModel(): AllCardsModel {
    return AllCardsModel(
        cards = cards?.mapValues {
            it.value.toCardModel()
        } ?: emptyMap(),
    )
}
