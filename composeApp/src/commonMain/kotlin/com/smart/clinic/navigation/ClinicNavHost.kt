package com.smart.clinic.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.smart.clinic.core.designsystem.ImagePicker
import com.smart.clinic.featuers.auth.login.navigation.loginScreen
import com.smart.clinic.featuers.auth.otp.navigation.otpScreen
import com.smart.clinic.featuers.auth.register.navigation.registerScreen
import com.smart.clinic.featuers.auth.registerTermsAndCondition.navigation.registerScreenTermsAndConditionScreen
import com.smart.clinic.featuers.auth.role.navigation.ROLE_ROUTE
import com.smart.clinic.featuers.auth.role.navigation.roleScreen
import com.smart.clinic.featuers.onboarding.navigation.ONBOARDING_ROUTE
import com.smart.clinic.featuers.onboarding.navigation.onboardingScreen

/**
 * Top-level navigation graph. Navigation is organized as explained at
 * https://d.android.com/jetpack/compose/nav-adaptive
 *
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 */
@Composable
fun ClinicNavHost(
    navController: NavController,
    imagePicker: ImagePicker
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = ONBOARDING_ROUTE,
    ) {
        loginScreen(navController)
        roleScreen(navController)
        registerScreen(navController,imagePicker)
        registerScreenTermsAndConditionScreen(navController)
        otpScreen(navController)
        onboardingScreen(navController)
    }
}
