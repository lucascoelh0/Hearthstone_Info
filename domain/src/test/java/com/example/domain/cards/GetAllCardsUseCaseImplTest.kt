package com.example.domain.cards

import com.example.core.models.Resource
import com.example.domain.models.CardModel
import com.example.domain.repositories.ICardRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetAllCardsUseCaseImplTest {

    @MockK
    private lateinit var mockCardRepository: ICardRepository
    private lateinit var useCase: IGetAllCardsUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        useCase = GetAllCardsUseCaseImpl(mockCardRepository)
    }

    @Test
    fun `invoke returns data from cardRepository`() = runTest {
        val expectedData = flowOf(Resource.success(mapOf(KEY to listOf<CardModel>())))
        every { mockCardRepository.getAllCards() } returns expectedData

        val result = useCase.invoke()

        assertEquals(expectedData, result)
    }

    private companion object {
        private const val KEY = "key"
    }
}
