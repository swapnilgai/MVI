package com.example.detail.presentation

import com.example.core.navigation.NavigationService
import com.example.detail.domain.model.Article
import com.example.detail.domain.usecase.GetDetailUseCase
import com.example.detail.presentation.event.DetailEvent
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class DetailViewModelTest {


    private lateinit var navigator: NavigationService

    private lateinit var getDetailUseCase: GetDetailUseCase

    private lateinit var detailViewModel: DetailViewModel

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp(){
        Dispatchers.setMain(testDispatcher)
        navigator = mockk()
        getDetailUseCase= mockk()
        detailViewModel = DetailViewModel(navigator, getDetailUseCase)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun `loadDetailPage will be trigger on LoadDetail event`() = runTest{

       val article = mockk<Article>(relaxed = true)
        coEvery { getDetailUseCase.getDetails("id") } returns flowOf(article)

        detailViewModel.setEvent(DetailEvent.LoadDetail("id"))

        advanceUntilIdle()

        val state = detailViewModel.state.value.data

        Assert.assertEquals(article, state)

    }


}