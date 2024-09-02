package com.smart.clinic

import androidx.compose.ui.interop.LocalUIViewController
import androidx.compose.ui.window.ComposeUIViewController
import com.smart.clinic.core.ImagePickerFactory
import com.smart.clinic.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure =  {
        initKoin()
    }
) {
    App(imagePicker = ImagePickerFactory(LocalUIViewController.current).createPicker())
}