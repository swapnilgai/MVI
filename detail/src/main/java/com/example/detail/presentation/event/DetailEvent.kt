package com.example.detail.presentation.event

sealed interface DetailEvent {
    object Dismiss: DetailEvent
    data class LoadDetail(val id: String): DetailEvent
}