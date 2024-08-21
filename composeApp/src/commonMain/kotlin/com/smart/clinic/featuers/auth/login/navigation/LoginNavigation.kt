package com.smart.clinic.featuers.auth.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.smart.clinic.featuers.auth.login.LoginScreen

const val LOGIN_ROUTE = "login_route"

fun NavGraphBuilder.loginScreen(navController: NavController) {
    composable(route = LOGIN_ROUTE) {
        LoginScreen(navController =navController )
    }
}
