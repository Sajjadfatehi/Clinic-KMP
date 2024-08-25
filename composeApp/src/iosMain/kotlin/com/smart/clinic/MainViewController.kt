package com.smart.clinic

import androidx.compose.ui.window.ComposeUIViewController
import com.smart.clinic.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure =  {
        initKoin()
    }
) {
    App()
}