package com.smart.clinic.core.designsystem.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppShape(
    val xSmall: Dp = 8.dp,
    val small: Dp = 10.dp,
    val medium: Dp = 12.dp,
    val large: Dp = 14.dp,
    val xLarge: Dp = 16.dp,
    val screen: Dp = 24.dp,
    val rounded: Dp = 1024.dp,
)

data class AppStroke(
    val thin: Dp = (0.5).dp,
    val base: Dp = 1.dp,
    val thick: Dp = 2.dp,
)