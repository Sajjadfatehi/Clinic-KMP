package com.smart.clinic.common.commonUi.imagePicker

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap


@Composable
expect fun rememberBitmapFromBytes(bytes: ByteArray?): ImageBitmap?