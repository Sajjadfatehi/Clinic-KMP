package com.smart.clinic.featuers.auth.login

sealed interface LoginAction {
    data class OnPhoneNumberChanges(val phoneNumber: String) : LoginAction
    data object OnSendOtpClicked : LoginAction
}