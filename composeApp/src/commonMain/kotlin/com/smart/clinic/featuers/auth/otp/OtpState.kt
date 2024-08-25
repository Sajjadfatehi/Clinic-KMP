package com.smart.clinic.featuers.auth.otp

data class OtpState(
    val otp: List<String> = List(4) { "" },
    val desc:String=""
)
