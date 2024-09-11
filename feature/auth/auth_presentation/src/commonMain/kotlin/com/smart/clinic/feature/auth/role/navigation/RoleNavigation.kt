package com.smart.clinic.feature.auth.role.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.smart.clinic.feature.auth.role.RoleScreen

const val ROLE_ROUTE = "role_route"

fun NavGraphBuilder.roleScreen(navController: NavController) {
    composable(route = ROLE_ROUTE) {
        RoleScreen(navController = navController)
    }
}
