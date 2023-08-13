package com.example.domain.models

import junit.framework.TestCase.assertEquals
import org.junit.Test

class PlayerClassTest {

    @Test
    fun `get returns correct PlayerClass for valid strings`() {
        assertEquals(PlayerClass.DRUID, PlayerClass.get(VALID_CLASS))
    }

    @Test
    fun `get returns correct PlayerClass ignoring case`() {
        assertEquals(PlayerClass.DRUID, PlayerClass.get(LOWERCASE_CLASS))
    }

    @Test
    fun `get returns UNKNOWN for invalid strings`() {
        assertEquals(PlayerClass.UNKNOWN, PlayerClass.get(INVALID_CLASS))
    }

    companion object {
        private const val VALID_CLASS = "Druid"
        private const val LOWERCASE_CLASS = "druid"
        private const val INVALID_CLASS = "INVALID_CLASS"
    }
}
