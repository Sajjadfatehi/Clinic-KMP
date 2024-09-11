package com.smart.clinic.feature.auth.otp

sealed interface OtpAction {
    data object OnNavigateBack : OtpAction
    data class OnSendOtpClicked(val otp: String) : OtpAction
    data class OnOtpCompleted(val otp: String) : OtpAction
    data class OnOtpChanged(val otp: List<String>) : OtpAction
}