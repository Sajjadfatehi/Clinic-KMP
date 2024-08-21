package com.smart.clinic.featuers.auth.otp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.smart.clinic.featuers.auth.otp.OtpScreen


const val OTP_ROUTE = "otp_route"

fun NavGraphBuilder.otpScreen(navController: NavController) {
    composable(route = OTP_ROUTE) {
        OtpScreen(navController = navController)
    }
}
