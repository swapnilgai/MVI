package com.example.nav

import com.example.nav.navigation.NavigationService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor(): NavigationService {

    private val _navActions = MutableSharedFlow<NavAction>(replay = 0, extraBufferCapacity = 3)

    val navActions : Flow<NavAction> = _navActions.asSharedFlow()


    override fun goBack() {
        val result = _navActions.tryEmit(NavAction.GoBack)
    }



    sealed class NavAction {
        object GoBack : NavAction()
    }
}