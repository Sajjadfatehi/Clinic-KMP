package com.smart.clinic.featuers.auth.registerTermsAndCondition.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.smart.clinic.featuers.auth.registerTermsAndCondition.RegisterScreenTermsAndConditionScreen

internal const val TERMS_AND_CONDITION_TITLE_ARG = "TERMS_AND_CONDITION_TITLE_ARG"
internal const val TERMS_AND_CONDITION_TEXT_ARG = "TERMS_AND_CONDITION_TEXT_ARG"
const val REGISTER_TC_ROUTE = "register_terms_and_condition_route"

fun NavGraphBuilder.registerScreenTermsAndConditionScreen(navController: NavController) {
    composable(
        route = "$REGISTER_TC_ROUTE/{${TERMS_AND_CONDITION_TITLE_ARG}}/{${TERMS_AND_CONDITION_TEXT_ARG}}",
        arguments = listOf(
            navArgument(TERMS_AND_CONDITION_TITLE_ARG) { type = NavType.StringType },
            navArgument(TERMS_AND_CONDITION_TEXT_ARG) { type = NavType.StringType },
        ),
    ) { backStackEntry ->
        val termsAndConditionTitle =
            backStackEntry.arguments?.getString(TERMS_AND_CONDITION_TITLE_ARG).orEmpty()
        val termsAndConditionText =
            backStackEntry.arguments?.getString(TERMS_AND_CONDITION_TEXT_ARG).orEmpty()
        RegisterScreenTermsAndConditionScreen(
            navController = navController,
            termsAndConditionTitle = termsAndConditionTitle,
            termsAndConditionText = termsAndConditionText
        )
    }
}
