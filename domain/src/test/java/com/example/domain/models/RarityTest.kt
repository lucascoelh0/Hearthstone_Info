package com.example.domain.models

import org.junit.Assert.assertEquals
import org.junit.Test

class RarityTest {

    @Test
    fun `get returns correct Rarity for valid strings`() {
        assertEquals(Rarity.COMMON, Rarity.get(VALID_RARITY))
    }

    @Test
    fun `get returns correct Rarity ignoring case`() {
        assertEquals(Rarity.COMMON, Rarity.get(LOWERCASE_RARITY))
    }

    @Test
    fun `get returns UNKNOWN for invalid strings`() {
        assertEquals(Rarity.UNKNOWN, Rarity.get(INVALID_RARITY))
    }

    companion object {
        private const val VALID_RARITY = "COMMON"
        private const val LOWERCASE_RARITY = "common"
        private const val INVALID_RARITY = "INVALID_RARITY"
    }
}
