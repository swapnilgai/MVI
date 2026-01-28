package com.example.detail.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.components.ErrorComponent
import com.example.core.components.LoadingComponent
import com.example.detail.presentation.components.DetailScreen
import com.example.detail.presentation.event.DetailEvent


@Composable
fun DetailScreenRoot(id: String) {
       val viewModel : DetailViewModel = hiltViewModel()

        val state = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.setEvent(DetailEvent.LoadDetail(id))
    }

    when {
            state.value.isLoading -> { LoadingComponent() }
            state.value.errorMessage!=null -> { ErrorComponent(state.value.errorMessage!!) }
            state.value.data != null -> { DetailScreen(article = state.value.data!!) }
        }

    BackHandler(true) {
        viewModel.setEvent(DetailEvent.Dismiss)
    }

}


