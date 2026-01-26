package com.example.home.presentation

import androidx.lifecycle.viewModelScope
import com.example.core.navigation.NavigationService
import com.example.core.presentation.BaseViewModel
import com.example.home.domain.usecase.GetInitialHomeUseCase
import com.example.home.presentation.event.HomeEvent
import com.example.home.presentation.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(val navigator: NavigationService, val useCase: GetInitialHomeUseCase): BaseViewModel<HomeUiState, HomeEvent>(HomeUiState()) {
    override fun handleEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.LoadHomeData -> loadInitialData()
            is HomeEvent.Dismiss -> navigator.goBack()
            is HomeEvent.NavigateToDetail -> {}
        }
    }

    private fun loadInitialData(){

        viewModelScope.launch {
            useCase.getInitialHome()
                .onStart {
                    updateUiState{ copy(isLoading = true) }
                }
                .catch {
                    updateUiState { copy(errorMessage = it.message, isLoading = false) }
                }
                .collect {
                    updateUiState { copy(data = it, isLoading = false) }
                }
        }
    }
}