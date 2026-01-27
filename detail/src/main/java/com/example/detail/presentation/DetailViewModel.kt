package com.example.detail.presentation

import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigator
import com.example.core.navigation.NavigationService
import com.example.core.presentation.BaseViewModel
import com.example.detail.domain.usecase.GetDetailUseCase
import com.example.detail.presentation.event.DetailEvent
import com.example.detail.presentation.state.DetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val navigator: NavigationService, val getDetailUseCase: GetDetailUseCase): BaseViewModel<DetailState, DetailEvent>(DetailState()) {


    override fun handleEvent(event: DetailEvent) {
        when(event){
            is  DetailEvent.Dismiss -> navigator.goBack()
            is  DetailEvent.LoadDetail -> { loadDetailPage(event.id) }
        }
    }

    private fun loadDetailPage(id: String) {
        viewModelScope.launch {
            getDetailUseCase.getDetails(id)
                .onStart { updateUiState { copy(isLoading = true) } }
                .catch { updateUiState { copy(errorMessage = it.message,  isLoading = false) } }
                .collectLatest { result ->
                    if(result == null){
                        updateUiState { copy( errorMessage = "No Data Found", isLoading = false) }
                    } else updateUiState { copy( data = result, isLoading = false, errorMessage = null) }
                }
    }
    }
}