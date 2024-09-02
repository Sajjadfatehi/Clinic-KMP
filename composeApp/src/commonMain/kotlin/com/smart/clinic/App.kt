package com.smart.clinic

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.smart.clinic.core.ImagePicker
import com.smart.clinic.core.designsystem.theme.ClinicTheme
import com.smart.clinic.navigation.ClinicNavHost
import org.koin.compose.KoinContext

@Composable
//@Preview
fun App(
    imagePicker: ImagePicker
) {
    ClinicTheme {
        KoinContext {
            val navController = rememberNavController()
            Scaffold(
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                containerColor = ClinicTheme.colorScheme.backgroundBase
            ) { padding ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .windowInsetsPadding(WindowInsets.systemBars)
                ) {
                    //TODO: make it cleaner and pass image picker via state class
                    ClinicNavHost(navController,imagePicker)
                }
            }
        }
    }
}