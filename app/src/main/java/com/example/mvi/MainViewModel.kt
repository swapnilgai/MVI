package com.example.mvi

import com.example.nav.Navigator
import com.example.core.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

sealed interface MainEvent{
    object Back: MainEvent
}

@HiltViewModel
class MainViewModel @Inject constructor(
    val navigator: Navigator
): BaseViewModel<Unit, MainEvent>(Unit) {
    override fun handleEvent(event: MainEvent) {
        when {
            event is MainEvent.Back -> navigator.goBack()
        }
    }
}
