package com.example.data.remote.models

import com.example.domain.models.CardModel
import com.example.domain.models.CardSet
import com.example.domain.models.Faction
import com.example.domain.models.PlayerClass
import com.example.domain.models.Rarity
import com.example.domain.models.Type

data class CardDto(
    val cardId: String? = null,
    val playerClass: String? = null,
    val img: String? = null,
    val name: String? = null,
    val flavor: String? = null,
    val text: String? = null,
    val cardSet: String? = null,
    val type: String? = null,
    val faction: String? = null,
    val rarity: String? = null,
    val attack: Int? = null,
    val cost: Int? = null,
    val health: Int? = null,
)

fun CardDto.toCardModel(): CardModel {
    return CardModel(
        cardId = cardId.orEmpty(),
        playerClass = PlayerClass.get(playerClass.orEmpty()),
        img = img.orEmpty(),
        name = name.orEmpty(),
        flavor = flavor.orEmpty(),
        text = text.orEmpty(),
        cardSet = CardSet.get(cardSet.orEmpty()),
        type = Type.get(type.orEmpty()),
        faction = Faction.get(faction.orEmpty()),
        rarity = Rarity.get(rarity.orEmpty()),
        attack = attack ?: 0,
        cost = cost ?: 0,
        health = health ?: 0,
    )
}

fun Map<String, List<CardDto>>.toModel(): Map<String, List<CardModel>> {
    return mapValues {
        it.value.toCardModel()
    }
}

fun List<CardDto>.toCardModel(): List<CardModel> {
    return map {
        it.toCardModel()
    }
}
