package com.example.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun AppNavigator(navigator: Navigator, homeScreen : @Composable () -> Unit) {
    val navController = rememberNavController()

    LaunchedEffect(Unit) {
            navigator.navActions.collectLatest { action ->
                when(action){
                    is Navigator.NavAction.GoBack -> navController.popBackStack()
                }
            }
    }



    NavHost(navController, startDestination = Destination.home.route) {
        composable(Destination.home.route){
            homeScreen()
        }
    }
}