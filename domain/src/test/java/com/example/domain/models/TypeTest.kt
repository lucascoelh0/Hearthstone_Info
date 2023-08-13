package com.example.domain.models

import junit.framework.TestCase.assertEquals
import org.junit.Test

class TypeTest {

    @Test
    fun `get returns correct Type for valid strings`() {
        assertEquals(Type.MINION, Type.get(MINION_VALID))
    }

    @Test
    fun `get returns correct Type ignoring case`() {
        assertEquals(Type.MINION, Type.get(MINION_LOWERCASE))
    }

    @Test
    fun `get returns UNKNOWN for invalid strings`() {
        assertEquals(Type.UNKNOWN, Type.get(INVALID_TYPE))
    }

    companion object {
        private const val MINION_VALID = "Minion"
        private const val MINION_LOWERCASE = "minion"
        private const val INVALID_TYPE = "INVALID_TYPE"
    }
}
