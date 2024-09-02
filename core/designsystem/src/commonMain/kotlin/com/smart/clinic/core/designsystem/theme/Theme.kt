package com.smart.clinic.core.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.layout.BeyondBoundsLayout
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.LayoutDirection

val DefaultFontFamily = FontFamily.Default

val LocalCustomColors = staticCompositionLocalOf { AppColorScheme() }
val LocalCustomTypography = staticCompositionLocalOf { AppTypography(DefaultFontFamily) }
val LocalCustomShape = staticCompositionLocalOf { AppShape() }
val LocalCustomStroke = staticCompositionLocalOf { AppStroke() }

@Composable
fun ClinicTheme(
    colors: AppColorScheme = LocalCustomColors.current,
    fontFamily: FontFamily = ClinicFontFamily(),
    typography: AppTypography = AppTypography(fontFamily = fontFamily),
    shape: AppShape = LocalCustomShape.current,
    stroke: AppStroke = LocalCustomStroke.current,
    content: @Composable () -> Unit
) {
    val materialTypography = Typography(
        displayLarge = typography.headingH1.copy(fontFamily = fontFamily),
        displayMedium = typography.headingH2.copy(fontFamily = fontFamily),
        displaySmall = typography.headingH3.copy(fontFamily = fontFamily),
        headlineLarge = typography.headingH4.copy(fontFamily = fontFamily),
        headlineMedium = typography.headingH5.copy(fontFamily = fontFamily),
        headlineSmall = typography.headingH6.copy(fontFamily = fontFamily),
        titleLarge = typography.paragraphLarge.copy(fontFamily = fontFamily),
        titleMedium = typography.paragraphMedium.copy(fontFamily = fontFamily),
        titleSmall = typography.paragraphSmall.copy(fontFamily = fontFamily),
        bodyLarge = typography.paragraphLarge.copy(fontFamily = fontFamily),
        bodyMedium = typography.paragraphMedium.copy(fontFamily = fontFamily),
        bodySmall = typography.paragraphSmall.copy(fontFamily = fontFamily),
        labelLarge = typography.paragraphLarge.copy(fontFamily = fontFamily),
        labelMedium = typography.paragraphMedium.copy(fontFamily = fontFamily),
        labelSmall = typography.paragraphSmall.copy(fontFamily = fontFamily)
    )

    CompositionLocalProvider(
        LocalCustomColors provides colors,
        LocalCustomTypography provides typography,
        LocalCustomShape provides shape,
        LocalCustomStroke provides stroke,
        LocalLayoutDirection provides LayoutDirection.Rtl
    ) {
        MaterialTheme(content = content, typography = materialTypography)
    }
}

object ClinicTheme {
    /**
     * Retrieves the current [ColorScheme] at the call site's position in the hierarchy.
     */
    val colorScheme: AppColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomColors.current

    /**
     * Retrieves the current [Typography] at the call site's position in the hierarchy.
     */
    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomTypography.current

    /**
     * Retrieves the current [Shapes] at the call site's position in the hierarchy.
     */
    val shapes: AppShape
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomShape.current

    /**
     * Retrieves the current [Stroke] at the call site's position in the hierarchy.
     */
    val strokes: AppStroke
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomStroke.current
}