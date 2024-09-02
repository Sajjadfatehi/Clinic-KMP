package com.smart.clinic.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.awt.ComposeWindow
import java.io.File
import javax.swing.JFileChooser

actual class ImagePicker(
    private val window: ComposeWindow
) {
    private var onImagePicked: ((ByteArray) -> Unit)? = null

    @Composable
    actual fun registerPicker(onImagePicked: (ByteArray) -> Unit) {
        // Save the callback for later use in pickImage()
        this.onImagePicked = onImagePicked
    }

    actual fun pickImage() {
        val fileChooser = JFileChooser().apply {
            fileSelectionMode = JFileChooser.FILES_ONLY
            isMultiSelectionEnabled = false
            dialogTitle = "Select an Image"
            fileFilter = javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "png", "jpeg")
        }

        val result = fileChooser.showOpenDialog(window)
        if (result == JFileChooser.APPROVE_OPTION) {
            val selectedFile: File? = fileChooser.selectedFile
            selectedFile?.let {
                val imageBytes = it.readBytes()
                onImagePicked?.invoke(imageBytes)  // Invoke the callback with the selected image as ByteArray
            }
        }
    }
}