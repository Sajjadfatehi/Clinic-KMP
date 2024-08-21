package com.smart.clinic.featuers.auth.register.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.smart.clinic.featuers.auth.register.RegisterScreen

internal const val ROLE_TYPE_ARG = "roleType"
const val REGISTER_ROUTE = "register_route"

fun NavGraphBuilder.registerScreen(navController: NavController) {
    composable(
        route = "$REGISTER_ROUTE/{${ROLE_TYPE_ARG}}",
        arguments = listOf(
            navArgument(ROLE_TYPE_ARG) { type = NavType.IntType },
        ),
    ) { backStackEntry ->
        val roleType = backStackEntry.arguments?.getInt(ROLE_TYPE_ARG) ?: 0
        RegisterScreen(navController = navController, roleType = roleType)
    }
}
