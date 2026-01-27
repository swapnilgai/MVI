package com.example.nav.screens

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.nav.utils.NavScreen

object Detail: NavScreen {
    override val route: String = "detail/{id}"
    override val arguments: List<NamedNavArgument> = listOf(navArgument("id"){ type = NavType.StringType})

    fun getDetailId(entry: NavBackStackEntry): String{
       return entry.arguments!!.getString("id")!!
    }
}