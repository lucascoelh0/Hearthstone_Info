package com.example.data.repositories

import com.example.core.models.Status
import com.example.data.NETWORK_ERROR
import com.example.data.STATUS_OK
import com.example.data.remote.api.CardApi
import com.example.data.remote.models.CardDto
import com.example.data.remote.models.toModel
import com.example.data.remote.repositories.CardRepositoryImpl
import com.example.data.remote.utils.handleNetworkResponse
import com.haroldadmin.cnradapter.NetworkResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
class CardRepositoryImplTest {

    @MockK
    private lateinit var cardApi: CardApi
    private lateinit var repository: CardRepositoryImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = CardRepositoryImpl(cardApi)
    }

    @Test
    fun `getAllCards emits success when API call is successful`() = runTest {
        val mockResponse = NetworkResponse.Success(emptyMap<String, List<CardDto>>(), code = STATUS_OK)
        val handledResponse = handleNetworkResponse(mockResponse) { it.toModel() }
        coEvery { cardApi.getAllCards() } returns mockResponse

        val resource = repository.getAllCards().first()

        assert(resource.status == Status.SUCCESS)
        assert(resource.data == handledResponse.data)
    }

    @Test
    fun `getAllCards emits error when API call fails`() = runTest {
        coEvery { cardApi.getAllCards() } returns NetworkResponse.NetworkError(IOException(NETWORK_ERROR))

        repository.getAllCards().collect { resource ->
            assertEquals(Status.ERROR, resource.status)
        }
    }
}
