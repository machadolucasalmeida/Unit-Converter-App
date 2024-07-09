@file:OptIn(ExperimentalAnimationApi::class, ExperimentalAnimationApi::class)

package com.lucas.unitconverterp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lucas.unitconverterp.ui.screens.bookmarks_screen.BookmarksLayoutScreen
import com.lucas.unitconverterp.ui.screens.calculator_screen.CalculatorLayout
import com.lucas.unitconverterp.ui.screens.home_screen.HomeViewModel
import com.lucas.unitconverterp.ui.screens.home_screen.MainScreenUnitCategory
import com.lucas.unitconverterp.ui.screens.search_screen.SearchScreenLayout
import com.lucas.unitconverterp.ui.screens.setting_screen.SettingsScreenLayout
import com.lucas.unitconverterp.ui.screens.unitconverter_screen.UnitCalculatorDesign
import com.lucas.unitconverterp.ui.screens.unitconverter_screen.UnitConverterViewModel
import com.lucas.unitconverterp.ui.theme.UnitConverterPTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel : HomeViewModel by viewModels()
            val viewModelUnit : UnitConverterViewModel by viewModels()
            UnitConverterPTheme {

                val navController = rememberAnimatedNavController()
                AnimatedNavHost(navController = navController, startDestination = "MainScreen", modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    composable(
                        route = "MainScreen",
                        enterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700)) },
                        exitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700)) },
                        popEnterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700)) },
                        popExitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700)) }
                    ) {
                        MainScreenUnitCategory(navController, viewModel)
                    }
                    composable(
                        route = "UnitCalculator",
                        enterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700)) },
                        exitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700)) },
                        popEnterTransition = { fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700)) },
                        popExitTransition = { fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700)) }
                    ) {
                        UnitCalculatorDesign(navController, viewModelUnit)
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
                        CalculatorLayout(navController)
                    }

                }
            }
        }
    }
}