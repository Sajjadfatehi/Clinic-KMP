package com.smart.clinic.featuers.auth.register

sealed interface RegisterAction {
    data class OnFullNameChanged(val name: String) : RegisterAction
    data class OnMedicalNumberChanged(val medicalNumber: String) : RegisterAction
    data object OnRegisterInfoButtonClicked : RegisterAction
    data class OnTermsAndConditionClicked(val title: String, val text: String) : RegisterAction
    data object OnNavigateBack : RegisterAction
}