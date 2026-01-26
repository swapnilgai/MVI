package com.example.nav.utils

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry

interface NavScreen {
    val route: String
    val arguments: List<NamedNavArgument>
}