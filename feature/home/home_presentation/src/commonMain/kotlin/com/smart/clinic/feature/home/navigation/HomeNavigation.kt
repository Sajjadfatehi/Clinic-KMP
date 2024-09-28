package com.smart.clinic.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.smart.clinic.feature.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

const val HOME_ROUTE = "home_route"


fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable(route = HOME_ROUTE) {
        HomeScreen(navController = navController)
    }
}
