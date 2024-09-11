package com.smart.clinic.feature.auth.login

sealed interface LoginAction {
    data class OnPhoneNumberChanges(val phoneNumber: String) :
        com.smart.clinic.feature.auth.login.LoginAction
    data object OnSendOtpClicked : com.smart.clinic.feature.auth.login.LoginAction
}