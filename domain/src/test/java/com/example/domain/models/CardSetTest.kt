package com.example.domain.models

import junit.framework.TestCase.assertEquals
import org.junit.Test

class CardSetTest {

    @Test
    fun `get returns correct CardSet for valid strings`() {
        assertEquals(CardSet.BASIC, CardSet.get(VALID_CARD_SET))
    }

    @Test
    fun `get returns correct CardSet ignoring case`() {
        assertEquals(CardSet.BASIC, CardSet.get(LOWERCASE_CARD_SET))
    }

    @Test
    fun `get returns UNKNOWN for invalid strings`() {
        assertEquals(CardSet.UNKNOWN, CardSet.get(INVALID_CARD_SET))
    }

    private companion object {
        private const val VALID_CARD_SET = "Basic"
        private const val LOWERCASE_CARD_SET = "basic"
        private const val INVALID_CARD_SET = "INVALID_SET"
    }
}