package com.example.core.ext

import com.example.core.constants.EMPTY
import junit.framework.TestCase.assertEquals
import org.junit.Test

class StringExtTest {

    @Test
    fun `formatCardText removes unwanted characters`() {
        assertEquals(FORMATTED_TEXT, UNWANTED_TAGS.formatCardText())
    }

    @Test
    fun `capitalizeFirstLetter capitalizes the first letter`() {
        assertEquals(EXPECTED_TEST_STRING, TEST_STRING.capitalizeFirstLetter())
        assertEquals(EMPTY, EMPTY.capitalizeFirstLetter())
    }

    companion object {
        private const val UNWANTED_TAGS = "<tag>This is [test] string \$with unwanted characters."
        private const val FORMATTED_TEXT = "This is  string with unwanted characters."
        private const val TEST_STRING = "test"
        private const val EXPECTED_TEST_STRING = "Test"
    }
}
