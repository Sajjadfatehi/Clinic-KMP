package com.smart.clinic.featuers.auth.otp

sealed interface OtpAction {
    data object OnNavigateBack : OtpAction
    data class OnSendOtpClicked(val otp: String) : OtpAction
}