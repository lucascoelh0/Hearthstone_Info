package com.example.data.api

import com.example.data.ID_1
import com.example.data.KEY_1
import com.example.data.STATUS_OK
import com.example.data.remote.api.CardApi
import com.example.data.remote.models.CardDto
import com.haroldadmin.cnradapter.NetworkResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class CardApiTest {

    @MockK
    private lateinit var mockApi: CardApi

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `getAllCards invokes expected endpoint and returns response`() = runTest {
        val mockedResponse = NetworkResponse.Success(
            mapOf(KEY_1 to listOf(CardDto(cardId = ID_1))),
            code = STATUS_OK,
        )
        coEvery { mockApi.getAllCards() } returns mockedResponse

        val result = mockApi.getAllCards()

        assertEquals(mockedResponse, result)
        coVerify { mockApi.getAllCards() }
    }
}
