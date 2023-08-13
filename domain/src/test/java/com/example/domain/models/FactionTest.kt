package com.example.domain.models

import junit.framework.TestCase.assertEquals
import org.junit.Test

class FactionTest {

    @Test
    fun `get returns correct Faction for valid strings`() {
        assertEquals(Faction.ALLIANCE, Faction.get(VALID_FACTION))
    }

    @Test
    fun `get returns correct Faction ignoring case`() {
        assertEquals(Faction.ALLIANCE, Faction.get(LOWERCASE_FACTION))
    }

    @Test
    fun `get returns UNKNOWN for invalid strings`() {
        assertEquals(Faction.UNKNOWN, Faction.get(INVALID_FACTION))
    }

    companion object {
        private const val VALID_FACTION = "ALLIANCE"
        private const val LOWERCASE_FACTION = "ALLIANCE"
        private const val INVALID_FACTION = "INVALID_FACTION"
    }
}
