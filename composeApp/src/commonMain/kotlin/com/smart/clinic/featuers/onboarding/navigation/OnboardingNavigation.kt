package com.smart.clinic.featuers.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.smart.clinic.featuers.onboarding.OnboardingScreen

const val ONBOARDING_ROUTE = "onboarding_route"

fun NavGraphBuilder.onboardingScreen(navController: NavController) {
    composable(route = ONBOARDING_ROUTE) {
        OnboardingScreen(navController = navController)
    }
}
