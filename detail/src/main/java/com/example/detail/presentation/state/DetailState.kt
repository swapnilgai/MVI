package com.example.detail.presentation.state

import com.example.detail.domain.model.Article

data class DetailState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val data: Article? = null
)