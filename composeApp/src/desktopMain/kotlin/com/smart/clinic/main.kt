package com.smart.clinic

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.smart.clinic.core.designsystem.ImagePickerFactory
import com.smart.clinic.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Clinic",
        ) {
            App(ImagePickerFactory(window).createPicker())
        }
    }
}