package com.example.domain.models

data class CardModel(
    val cardId: String,
    val playerClass: PlayerClass,
    val img: String,
    val name: String,
    val flavor: String,
    val text: String,
    val cardSet: CardSet,
    val type: Type,
    val faction: Faction,
    val rarity: Rarity,
    val attack: Int,
    val cost: Int,
    val health: Int,
)
