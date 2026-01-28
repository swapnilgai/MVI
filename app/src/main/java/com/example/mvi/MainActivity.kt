package com.example.mvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import com.example.detail.presentation.DetailScreenRoot
import com.example.home.presentation.HomeScreenRoot
import com.example.nav.AppNavigator
import com.example.nav.Navigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                AppNavigator(
                    navigator = navigator,
                    homeScreen = {
                        HomeScreenRoot()
                    },
                    detailScreen = { id ->
                        DetailScreenRoot(id)
                    }
                )
            }
        }
    }
}
