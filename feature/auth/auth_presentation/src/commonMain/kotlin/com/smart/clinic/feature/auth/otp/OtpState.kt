package com.smart.clinic.feature.auth.otp

data class OtpState(
    val otp: List<String> = List(4) { "" },
    val desc:String=""
)
