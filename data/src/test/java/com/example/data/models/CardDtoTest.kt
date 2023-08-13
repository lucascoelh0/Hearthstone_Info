package com.example.data.models

import com.example.data.ID_1
import com.example.data.ID_2
import com.example.data.ID_3
import com.example.data.IMAGE
import com.example.data.KEY_1
import com.example.data.KEY_2
import com.example.data.TWO
import com.example.data.remote.models.CardDto
import com.example.data.remote.models.toCardModel
import com.example.data.remote.models.toModel
import com.example.domain.models.CardSet
import com.example.domain.models.Faction
import com.example.domain.models.PlayerClass
import com.example.domain.models.Rarity
import com.example.domain.models.Type
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CardDtoTest {

    @Test
    fun `toCardModel correctly maps CardDto to CardModel`() {
        val dto = CardDto(
            cardId = ID_1,
            playerClass = PlayerClass.WARRIOR.value,
            img = IMAGE,
        )

        val model = dto.toCardModel()

        assertEquals(model.cardId, dto.cardId)
        assertEquals(model.playerClass, PlayerClass.get(dto.playerClass.orEmpty()))
        assertEquals(model.img, dto.img)
        assertEquals(model.name, dto.name.orEmpty())
        assertEquals(model.flavor, dto.flavor.orEmpty())
        assertEquals(model.text, dto.text.orEmpty())
        assertEquals(model.cardSet, CardSet.get(dto.cardSet.orEmpty()))
        assertEquals(model.type, Type.get(dto.type.orEmpty()))
        assertEquals(model.faction, Faction.get(dto.faction.orEmpty()))
        assertEquals(model.rarity, Rarity.get(dto.rarity.orEmpty()))
        assertEquals(model.attack, dto.attack ?: -1)
        assertEquals(model.cost, dto.cost ?: -1)
        assertEquals(model.health, dto.health ?: -1)
    }

    @Test
    fun `Map toModel extension function works correctly`() {
        val dtoMap = mapOf(
            KEY_1 to listOf(
                CardDto(cardId = ID_1),
                CardDto(cardId = ID_2)
            ),
            KEY_2 to listOf(
                CardDto(cardId = ID_3)
            )
        )

        val modelMap = dtoMap.toModel()

        assertEquals(modelMap[KEY_1]?.size, TWO)
        assertEquals(modelMap[KEY_1]?.get(0)?.cardId, ID_1)
        assertEquals(modelMap[KEY_2]?.get(0)?.cardId, ID_3)
    }

    @Test
    fun `List toCardModel extension function works correctly`() {
        val dtoList = listOf(
            CardDto(cardId = ID_1),
            CardDto(cardId = ID_2)
        )

        val modelList = dtoList.toCardModel()

        assertEquals(modelList.size, TWO)
        assertEquals(modelList[0].cardId, ID_1)
        assertEquals(modelList[1].cardId, ID_2)
    }
}
