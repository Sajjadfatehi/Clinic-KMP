package com.smart.clinic.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import javax.imageio.ImageIO

@Composable
actual fun rememberBitmapFromBytes(bytes: ByteArray?): ImageBitmap? {
    //TODO: find way to get bitmap in desktop
    return remember(bytes) {
        if(bytes != null) {
            byteArrayToImageBitmap(bytes)
        } else {
            null
        }
    }
}

fun byteArrayToImageBitmap(byteArray: ByteArray): ImageBitmap {
    // Convert ByteArray to InputStream
    val inputStream = ByteArrayInputStream(byteArray)

    // Use ImageIO to read the image
    val bufferedImage = ImageIO.read(inputStream)

    // Convert BufferedImage to ImageBitmap (Compose friendly format)
    return bufferedImage.toComposeImageBitmap()
}

fun BufferedImage.toComposeImageBitmap(): ImageBitmap {
    // Convert BufferedImage to ImageBitmap using AWT -> Compose graphics conversion
    return this.toComposeImageBitmap()
}