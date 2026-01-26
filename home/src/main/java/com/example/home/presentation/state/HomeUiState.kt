package com.example.home.presentation.state

import androidx.compose.runtime.Stable
import com.example.home.domain.model.LatestNews

@Stable
data class HomeUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val data: List<LatestNews>? = null
)