package com.example.detail

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.components.ErrorComponent
import com.example.core.components.LoadingComponent
import com.example.detail.presentation.DetailViewModel
import com.example.detail.presentation.components.DetailScreen
import com.example.detail.presentation.event.DetailEvent


@Composable
fun DetailScreenRoot(id: String) {
       val viewModel : DetailViewModel = hiltViewModel()

        val state = viewModel.state.collectAsState()

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


