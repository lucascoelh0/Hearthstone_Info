package com.luminay.hearthstoneinfo.features.cardlist.presentation.mocks

import com.example.domain.models.CardModel

fun getMockCard() = CardModel(
    cardId = "TTN_487",
    img = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/84cb60a7f27839c678762f16fb10c509d0dd538a4013d692fd8e551cd7cc16be.png",
    imgGold = "",
    name = "Loken, Carcereiro de Yogg-Saron",
    flavor = "Muito bom no trabalho dele! - Yogg-Saron",
    text = "<b>Grito de Guerra:</b> <b>Descubra</b> um lacaio do seu deck. Evoque um Tentáculo com os atributos dele e <b>Provocar</b>.",
    cardSet = "TITANS",
    type = "Minion",
    faction = "Neutral",
    rarity = "Legendary",
    attack = 3,
    cost = 6,
    health = 3
)

fun getMockCardList() = listOf(
    CardModel(
        cardId = "TTN_487",
        img = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/84cb60a7f27839c678762f16fb10c509d0dd538a4013d692fd8e551cd7cc16be.png",
        imgGold = "",
        name = "Loken, Carcereiro de Yogg-Saron",
        flavor = "Muito bom no trabalho dele! - Yogg-Saron",
        text = "<b>Grito de Guerra:</b> <b>Descubra</b> um lacaio do seu deck. Evoque um Tentáculo com os atributos dele e <b>Provocar</b>.",
        cardSet = "TITANS",
        type = "Minion",
        faction = "Neutral",
        rarity = "Legendary",
        attack = 3,
        cost = 6,
        health = 3
    ),
    CardModel(
        cardId = "TTN_466",
        img = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/7ff545f16bfd3c75ce3310d60bababd9fd59efa4d37b202968535d82f86a144b.png",
        imgGold = "",
        name = "Minotauren",
        flavor = "\"Por que ele está tão bravo?\" \"Já está preso em um dos labirintos secretos de Hearthstone há ANOS.\"",
        text = "<b>Rapidez.</b> Sempre que este lacaio causar dano, receba o equivalente de Armadura.",
        cardSet = "TITANS",
        type = "Minion",
        faction = "Neutral",
        rarity = "Rare",
        attack = 5,
        cost = 6,
        health = 5
    ),
    CardModel(
        cardId = "TTN_075",
        img = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/840d7944ef4d00c777090bc7bc7d7e4c7eb0f50bdb03efff072e53638d585050.png",
        imgGold = "",
        name = "Norgannon",
        flavor = "A tremenda magia arcana dele foi suficientemente forte para salvar todos os espíritos dos titãs depois que Sargeras destruiu as formas físicas deles.",
        text = "<b>Titã</b>\nDepois que este lacaio usar uma habilidade, dobre o poder das outras habilidades.",
        cardSet = "TITANS",
        type = "Minion",
        faction = "Neutral",
        rarity = "Legendary",
        attack = 3,
        cost = 6,
        health = 8
    ),
    CardModel(
        cardId = "TTN_481",
        img = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/4dd0dcf902e0e82b65620d5fa9dca8b598b95ed4de2a85c40f54240c5d543fcb.png",
        imgGold = "",
        name = "Ra-den",
        flavor = "Participa regularmente de Imortal Combate.",
        text = "<b>Último Suspiro:</b> Evoque cada lacaio que você tiver jogado nesta partida que não estava no seu deck inicial.",
        cardSet = "TITANS",
        type = "Minion",
        faction = "Neutral",
        rarity = "Legendary",
        attack = 5,
        cost = 6,
        health = 5
    )
)

fun getMockCardMap() = mapOf(
    "Basic" to getMockCardList().subList(0, 1),
    "Classic" to getMockCardList().subList(2, 3),
)

fun getMockCardFlatMap() = getMockCardMap().flatMap { it.value }
