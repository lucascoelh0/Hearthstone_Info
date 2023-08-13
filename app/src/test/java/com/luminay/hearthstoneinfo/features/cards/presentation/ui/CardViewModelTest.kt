package com.luminay.hearthstoneinfo.features.cards.presentation.ui

import com.example.core.constants.HYPHEN
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CardViewModelTest {

    private lateinit var viewModel: CardViewModel

    @Before
    fun setUp() {
        viewModel = CardViewModel()
    }

    @Test
    fun `handleStat returns hyphen for -1`() {
        val result = viewModel.handleStat(-1)
        assertEquals(HYPHEN, result)
    }

    @Test
    fun `handleStat returns string representation of stat for valid integers`() {
        val result = viewModel.handleStat(FIVE)
        assertEquals(FIVE.toString(), result)
    }

    companion object {
        private const val FIVE = 5
    }
}
