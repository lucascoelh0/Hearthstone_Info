package com.luminay.hearthstoneinfo.data.remote.models

import com.luminay.hearthstoneinfo.domain.models.CardModel

data class CardDto(
    val cardId: String? = null,
    val img: String? = null,
    val imgGold: String? = null,
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
        img = img.orEmpty(),
        imgGold = imgGold.orEmpty(),
        name = name.orEmpty(),
        flavor = flavor.orEmpty(),
        text = text.orEmpty(),
        cardSet = cardSet.orEmpty(),
        type = type.orEmpty(),
        faction = faction.orEmpty(),
        rarity = rarity.orEmpty(),
        attack = attack ?: 0,
        cost = cost ?: 0,
        health = health ?: 0,
    )
}
