package com.smart.clinic.featuers.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun OnboardingScreen(navController: NavController) {
    val viewModel = viewModel { OnboardingViewModel() }
}

@Composable
fun OnboardingScreen(viewModel: OnboardingViewModel, onAction: (OnboardingAction) -> Unit) {

    val viewState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.effect.onEach {

        }.launchIn(this)
    }
}
