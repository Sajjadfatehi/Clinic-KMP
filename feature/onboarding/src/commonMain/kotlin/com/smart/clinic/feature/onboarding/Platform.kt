package com.smart.clinic.feature.onboarding

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform