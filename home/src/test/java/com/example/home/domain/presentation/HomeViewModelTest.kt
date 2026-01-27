package com.example.home.domain.presentation

import com.example.core.navigation.NavigationService
import com.example.home.domain.model.LatestNews
import com.example.home.domain.usecase.GetInitialHomeUseCase
import com.example.home.presentation.HomeViewModel
import com.example.home.presentation.event.HomeEvent
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class HomeViewModelTest {

    private lateinit var navigator: NavigationService

    private lateinit var getInitialHomeUseCase: GetInitialHomeUseCase

    private lateinit var homeViewModel: HomeViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp(){
        Dispatchers.setMain(testDispatcher)
        navigator = mockk<NavigationService>()
        getInitialHomeUseCase = mockk<GetInitialHomeUseCase>()
        homeViewModel = HomeViewModel(navigator, getInitialHomeUseCase)
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state emits null data`() {
        val initailState = homeViewModel.state.value
        assertEquals(null, initailState.data)
        assertEquals(false, initailState.isLoading)
        assertEquals(null, initailState.errorMessage)
    }

    @Test
    fun `get initial state of HomeViewModel is correct`() = runTest {
        val response: List<LatestNews> = mockk()

        coEvery { getInitialHomeUseCase.getInitialHome() } returns flowOf(response)

        homeViewModel.setEvent(HomeEvent.LoadHomeData)

        advanceUntilIdle()

        val finalState = homeViewModel.state.value
        assertEquals(response, finalState.data)
    }
}