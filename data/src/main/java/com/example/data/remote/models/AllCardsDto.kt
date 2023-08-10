package com.example.data.remote.models

import com.example.domain.models.AllCardsModel

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
