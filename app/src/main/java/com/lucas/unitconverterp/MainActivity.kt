@file:OptIn(ExperimentalAnimationApi::class, ExperimentalAnimationApi::class)

package com.lucas.unitconverterp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lucas.unitconverterp.ui.theme.UnitConverterPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterPTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val navController = rememberAnimatedNavController()
                AnimatedNavHost(navController = navController, startDestination = "MainScreen", modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    composable(
                        route = "MainScreen",
                        enterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700)) },
                        exitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700)) },
                        popEnterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700)) },
                        popExitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700)) }
                    ) {
                        MainScreenUnitCategory(navController)
                    }
                    composable(
                        route = "UnitCalculator",
                        enterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700)) },
                        exitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700)) },
                        popEnterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700)) },
                        popExitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700)) }
                    ) {
                        UnitCalculatorDesign(navController)
                    }
                    composable(
                        route = "SettingsScreen",
                        enterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700)) },
                        exitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700)) },
                        popEnterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700)) },
                        popExitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700)) }
                    ) {
                        SettingsScreenLayout(navController)
                    }
                    composable(
                        route = "Bookmarks",
                        enterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700)) },
                        exitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700)) },
                        popEnterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700)) },
                        popExitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700)) }
                    ) {
                        BookmarksLayoutScreen(navController)
                    }
                    composable(
                        route = "SearchScreen",
                        enterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700)) },
                        exitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700)) },
                        popEnterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700)) },
                        popExitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700)) }
                    ) {
                        SearchScreenLayout(navController)
                    }
                    composable(
                        route = "CalculatorScreen",
                        enterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700)) },
                        exitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700)) },
                        popEnterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700)) },
                        popExitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700)) }
                    ) {
                        CalculatorLayout(navController, state = state, onAction = viewModel::onAction)
                    }

                }
            }
        }
    }
}