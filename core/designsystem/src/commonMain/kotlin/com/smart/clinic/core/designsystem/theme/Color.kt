package com.smart.clinic.core.designsystem.theme

import androidx.compose.ui.graphics.Color


internal val Gray0 = Color(0xFFFFFFFF)
internal val Gray50 = Color(0xFFF5F7FA)
internal val Gray100 = Color(0xFFF2F5F8)
internal val Gray200 = Color(0xFFE1E4EA)
internal val Gray300 = Color(0xFFCACFD8)
internal val Gray400 = Color(0xFF99A0AD)
internal val Gray500 = Color(0xFF717784)
internal val Gray600 = Color(0xFF525866)
internal val Gray700 = Color(0xFF2B303B)
internal val Gray800 = Color(0xFF222530)
internal val Gray900 = Color(0xFF181B25)
internal val Gray950 = Color(0xFF0E121B)
internal val GrayScrim = Gray950.copy(alpha = .24f)
internal val GrayAlpha8 = Gray400.copy(alpha = .8f)
internal val GrayAlpha16 = Gray400.copy(alpha = .16f)
internal val GrayAlpha24 = Gray400.copy(alpha = .24f)
internal val GrayShadowMedium = Gray950.copy(alpha = .10f)
internal val GrayShadowXSmall = Gray950.copy(alpha = .3f)

internal val Blue50 = Color(0xFFF0FAFF)
internal val Blue100 = Color(0xFFD6E3FF)
internal val Blue200 = Color(0xFFC2D6FF)
internal val Blue300 = Color(0xFF99BBFF)
internal val Blue400 = Color(0xFF6694FF)
internal val Blue500 = Color(0xFF335CFF)
internal val Blue600 = Color(0xFF3559E9)
internal val Blue700 = Color(0xFF2547D0)
internal val Blue800 = Color(0xFF1F3BAD)
internal val Blue900 = Color(0xFF182F8C)
internal val Blue950 = Color(0xFF122368)

internal val Purple50 = Color(0xFFEFEBFF)
internal val Purple200 = Color(0xFFCCC2FF)
internal val Purple500 = Color(0xFF7E52F4)
internal val Purple700 = Color(0xFF5B2CC9)

internal val Green50 = Color(0xFFE0FAEC)
internal val Green100 = Color(0xFFE0FAEC)
internal val Green200 = Color(0xFFC2F5DA)
internal val Green500 = Color(0xFF1FC16B)
internal val Green700 = Color(0xFF178C4E)

internal val Yellow100 = Color(0xFFFFF9EB)
internal val Yellow500 = Color(0xFFF6B51E)

internal val Red50 = Color(0xFFFFEBEC)
internal val Red400 = Color(0xFFFF6673)
internal val Red500 = Color(0xFFFB3747)
internal val RedAlpha8 = Red400.copy(alpha = .8f)
internal val RedAlpha16 = Red400.copy(alpha = .16f)
internal val RedAlpha24 = Red400.copy(alpha = .24f)

internal val Sky200 = Color(0xFFC2EBFF)
internal val Sky400 = Color(0xFF99A0AD)


data class AppColorScheme(
    val primaryPatientBase: Color = Blue500,
    val primaryPatientHover: Color = Blue700,
    val primaryPatientSubtle: Color = Blue50,
    val primaryDoctorBase: Color = Purple500,
    val primaryDoctorHover: Color = Purple700,
    val primaryDoctorSubtle: Color = Purple50,
    val primaryProviderBase: Color = Green500,
    val primaryProviderHover: Color = Green700,
    val primaryProviderSubtle: Color = Green50,
    val backgroundBase: Color = Gray0,
    val backgroundVariant: Color = Gray50,
    val backgroundDisabled: Color = Gray100,
    val backgroundInverse: Color = Gray950,
    val backgroundInverseHover: Color = Gray900,
    val backgroundModal: Color = Gray0,
    val backgroundScrim: Color = GrayScrim,
    val backgroundLight: Color = Gray0,
    val backgroundDark: Color = Gray950,
    val backgroundGhostHover: Color = GrayAlpha8,
    val divider: Color = GrayAlpha24,
    val foregroundStrong: Color = Gray950,
    val foregroundBase: Color = Gray700,
    val foregroundSoft: Color = Gray500,
    val foregroundWeak: Color = Gray400,
    val foregroundDisable: Color = Gray300,
    val foregroundInverse: Color = Gray0,
    val foregroundWhite: Color = Gray0,
    val foregroundStar: Color = Yellow500,
    val stateNeutralBase: Color = Gray500,
    val stateNeutralSubtle: Color = Gray100,
    val stateInformationBase: Color = Blue500,
    val stateInformationSubtle: Color = Blue50,
    val stateErrorBase: Color = Red500,
    val stateErrorSubtle: Color = Red50,
    val stateSuccessBase: Color = Green500,
    val stateSuccessSubtle: Color = Green100,
    val stateWarningBase: Color = Yellow500,
    val stateWarningSubtle: Color = Yellow100,
    val effectNeutral: Color = Gray200,
    val effectPrimaryPatient: Color = Blue200,
    val effectPrimaryDoctor: Color = Purple200,
    val effectPrimaryProvider: Color = Green200,
    val effectError: Color = RedAlpha16,
    val effectScrim: Color = GrayScrim,
    val effectShadowMedium: Color = Gray200,
    val effectShadowXSmall: Color = Gray200,
    val otherComponentsChip: Color = GrayAlpha16,
    val otherIllustrationShine: Color = Sky400,
    val otherIllustrationSubtle: Color = Sky200,
    val textWhite: Color = Gray0,
)