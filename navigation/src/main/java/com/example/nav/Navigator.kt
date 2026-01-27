package com.example.nav

import androidx.navigation.NavOptionsBuilder
import com.example.core.navigation.NavigationService
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
        _navActions.tryEmit(NavAction.GoBack)
    }

    override fun navigate(
        route: String,
        navOptions: NavOptionsBuilder.() -> Unit
    ) {
       _navActions.tryEmit(NavAction.Navigate(route, navOptions))
    }

    sealed class NavAction {
        object GoBack : NavAction()
        data class Navigate(val route: String, val navOptionBuilder: NavOptionsBuilder.() -> Unit): NavAction()
    }
}