package com.example.home.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.components.ErrorComponent
import com.example.core.components.LoadingComponent
import com.example.home.presentation.event.HomeEvent
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.home.presentation.components.HomeScreen

@Composable
fun HomeScreenRoot() {

    val viewModel: HomeViewModel = hiltViewModel()
    val state = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.setEvent(HomeEvent.LoadHomeData)
    }

    when{
        state.value.isLoading -> { LoadingComponent() }
        state.value.errorMessage != null -> {
            ErrorComponent( state.value.errorMessage!!)
        }
        state.value.data?.isNotEmpty() == true -> { HomeScreen(state.value.data!!,
            { id : String -> viewModel.setEvent(HomeEvent.NavigateToDetail(id)) }
        ) }
    }

    BackHandler(true) {
        viewModel.setEvent(HomeEvent.Dismiss)
    }
}
