package com.example.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


abstract class BaseViewModel<UiState, Event>(init: UiState): ViewModel(){

    private val _state = MutableStateFlow<UiState>(init)
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<Event>(replay = 0)


    init {
        viewModelScope.launch {
            _event.collect {
                handleEvent(it)
            }
        }
    }

    abstract fun handleEvent(event: Event)

    fun updateUiState(update: UiState.() -> UiState){
        _state.update { _state.value.update() }
    }

    fun setEvent(event: Event){
        viewModelScope.launch {
            _event.emit(event)
        }
    }

}