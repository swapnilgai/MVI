package com.example.home.presentation.event

sealed interface HomeEvent {
    object Dismiss: HomeEvent
    object LoadHomeData: HomeEvent
    data class NavigateToDetail(val id: String): HomeEvent
}