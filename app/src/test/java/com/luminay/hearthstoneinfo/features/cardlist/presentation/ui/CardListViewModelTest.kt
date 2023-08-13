package com.luminay.hearthstoneinfo.features.cardlist.presentation.ui

import com.example.core.constants.EMPTY
import com.example.core.models.Resource
import com.example.domain.cards.IGetAllCardsUseCase
import com.example.domain.models.CardModel
import com.example.domain.models.CardSet
import com.example.domain.models.Faction
import com.example.domain.models.PlayerClass
import com.example.domain.models.Rarity
import com.example.domain.models.Type
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CardListViewModelTest {

    @MockK
    lateinit var getAllCardsUseCase: IGetAllCardsUseCase

    private lateinit var viewModel: CardListViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = CardListViewModel(getAllCardsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchData updates allCards stateflow`() = runTest {
        val expectedData = mapOf(TEST_STRING to listOf<CardModel>())
        every { getAllCardsUseCase() } returns flowOf(Resource.success(expectedData))

        viewModel.fetchData()

        val result = viewModel.allCards.first()
        assertEquals(Resource.success(expectedData), result)
    }

    @Test
    fun `getCardsFlattenedMap filters and flattens the map`() {
        val card1 = CardModel(
            ID_1,
            PlayerClass.MAGE,
            IMG_1,
            FIREBALL,
            FLAVOR_1,
            TEXT_1,
            CardSet.BASIC,
            Type.SPELL,
            Faction.NEUTRAL,
            Rarity.COMMON,
            ATTACK_1,
            COST_1,
            0
        )
        val card2 = CardModel(
            ID_2,
            PlayerClass.PALADIN,
            IMG_2,
            HEAL,
            FLAVOR_2,
            TEXT_2,
            CardSet.CLASSIC,
            Type.SPELL,
            Faction.NEUTRAL,
            Rarity.FREE,
            0,
            COST_2,
            0
        )
        val cards = mapOf(
            MAGE to listOf(card1),
            PALADIN to listOf(card2)
        )

        // Verify filtering by search term
        val result1 = viewModel.getCardsFlattenedMap(cards, FIREBALL, CardSet.ALL)
        assertTrue(result1.contains(MAGE))
        assertTrue(result1.contains(card1))
        assertFalse(result1.contains(PALADIN))
        assertFalse(result1.contains(card2))

        // Verify filtering by card set
        val result2 = viewModel.getCardsFlattenedMap(cards, EMPTY, CardSet.BASIC)
        assertTrue(result2.contains(MAGE))
        assertTrue(result2.contains(card1))
        assertFalse(result2.contains(PALADIN))
        assertFalse(result2.contains(card2))

        // Verify the flattened structure
        val result3 = viewModel.getCardsFlattenedMap(cards, EMPTY, CardSet.ALL)
        assertEquals(listOf(MAGE, card1, PALADIN, card2), result3)
    }

    companion object {
        private const val TEST_STRING = "Test"
        private const val MAGE = "Mage"
        private const val PALADIN = "Paladin"
        private const val FIREBALL = "Fireball"
        private const val HEAL = "Heal"
        private const val ID_1 = "id1"
        private const val ID_2 = "id2"
        private const val IMG_1 = "http://image1.jpg"
        private const val IMG_2 = "http://image1.jpg"
        private const val FLAVOR_1 = "Flavor1"
        private const val FLAVOR_2 = "Flavor2"
        private const val TEXT_1 = "Deals 6 damage"
        private const val TEXT_2 = "Restore 4 health"
        private const val ATTACK_1 = 6
        private const val COST_1 = 4
        private const val COST_2 = 2
    }
}
