package com.example.core.navigation

import androidx.navigation.NavOptionsBuilder

interface NavigationService {
    fun goBack()

    fun navigate(route: String, navOptions: NavOptionsBuilder.() -> Unit = {})
}