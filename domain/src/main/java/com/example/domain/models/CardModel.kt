package com.example.domain.models

data class CardModel(
    val cardId: String,
    val img: String,
    val imgGold: String,
    val name: String,
    val flavor: String,
    val text: String,
    val cardSet: String,
    val type: String,
    val faction: String,
    val rarity: String,
    val attack: Int,
    val cost: Int,
    val health: Int,
)
