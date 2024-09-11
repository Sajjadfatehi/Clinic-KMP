package com.smart.clinic.feature.auth.register

data class RegisterState(
    val fullName: String = "",
    val medicalNumber: String? = null,
    val isRegisterButtonEnabled: Boolean = false,
    val image : ByteArray? = null
)