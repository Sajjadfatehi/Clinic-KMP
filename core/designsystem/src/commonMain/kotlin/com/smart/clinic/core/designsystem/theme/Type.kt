package com.smart.clinic.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import clinic.core.designsystem.generated.resources.Peyda_Black
import clinic.core.designsystem.generated.resources.Peyda_Bold
import clinic.core.designsystem.generated.resources.Peyda_ExtraBold
import clinic.core.designsystem.generated.resources.Peyda_ExtraLight
import clinic.core.designsystem.generated.resources.Peyda_Light
import clinic.core.designsystem.generated.resources.Peyda_Medium
import clinic.core.designsystem.generated.resources.Peyda_Regular
import clinic.core.designsystem.generated.resources.Peyda_SemiBold
import clinic.core.designsystem.generated.resources.Peyda_Thin
import clinic.core.designsystem.generated.resources.Res
import org.jetbrains.compose.resources.Font


data class AppTypography(
    val fontFamily: FontFamily,
    val headingH1: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 56.sp,
        lineHeight = 64.sp,
        letterSpacing = 0.sp,
    ),
    val headingH2: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 48.sp,
        lineHeight = 64.sp,
        letterSpacing = 0.sp,
    ),
    val headingH3: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 40.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.sp,
    ),
    val headingH4: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = (-0.5).sp,
    ),
    val headingH5: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),
    val headingH6: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
    ),

    val subHeadingXSmall: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp,
    ),

    val subHeadingSmall: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp,
    ),

    val subHeadingMedium: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp,
    ),
    val subHeadingLarge: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
    ),

    val labelXSmall: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp,
    ),

    val labelSmall: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp,
    ),

    val labelMedium: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp,
    ),
    val labelLarge: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
    ),

    val paragraphXSmall: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp,
    ),

    val paragraphSmall: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp,
    ),

    val paragraphMedium: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp,
    ),
    val paragraphLarge: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
    ),
    val paragraphXLarge: TextStyle = TextStyle(
         fontFamily = fontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
    )
)


@Composable
fun ClinicFontFamily() = FontFamily(
    Font(Res.font.Peyda_Medium, weight = FontWeight.Medium),
    Font(Res.font.Peyda_Regular, weight = FontWeight.W400),
    Font(Res.font.Peyda_Black, weight = FontWeight.Black),
    Font(Res.font.Peyda_Bold, weight = FontWeight.Bold),
    Font(Res.font.Peyda_ExtraBold, weight = FontWeight.ExtraBold),
    Font(Res.font.Peyda_ExtraLight, weight = FontWeight.ExtraLight),
    Font(Res.font.Peyda_Light, weight = FontWeight.Light),
    Font(Res.font.Peyda_SemiBold, weight = FontWeight.SemiBold),
    Font(Res.font.Peyda_Thin, weight = FontWeight.Thin),

)
