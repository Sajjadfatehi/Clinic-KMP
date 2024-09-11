package com.smart.clinic.common.commonUi.imagePicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.awt.ComposeWindow
import java.awt.Window

actual class ImagePickerFactory(
    private val window: Window
) {
    @Composable
    actual fun createPicker(): ImagePicker {
        return remember {
            ImagePicker((window as? ComposeWindow) ?: ComposeWindow())
        }
    }
}