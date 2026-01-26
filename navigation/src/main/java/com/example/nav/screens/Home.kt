package com.example.nav.screens

import androidx.navigation.NamedNavArgument
import com.example.nav.utils.NavScreen

object Home : NavScreen {
    override val route: String = "home"
    override val arguments: List<NamedNavArgument> = emptyList()
}