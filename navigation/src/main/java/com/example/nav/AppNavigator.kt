package com.example.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.collectLatest


@Composable
fun AppNavigator(navigator: Navigator, homeScreen : @Composable () -> Unit, detailScreen: @Composable (String) -> Unit ) {
    val navController = rememberNavController()

    LaunchedEffect(Unit) {
            navigator.navActions.collectLatest { action ->
                when(action){
                    is Navigator.NavAction.GoBack -> navController.popBackStack()
                    is Navigator.NavAction.Navigate -> {
                        navController.navigate(action.route, action.navOptionBuilder)
                    }
                }
            }
    }


    NavHost(navController, startDestination = Destination.home.route) {
        composable(Destination.home.route){
            homeScreen()
        }
        composable(Destination.detail.route, Destination.detail.arguments){ it ->
            val id = Destination.detail.getDetailId(it)
            detailScreen(id)
        }
    }
}