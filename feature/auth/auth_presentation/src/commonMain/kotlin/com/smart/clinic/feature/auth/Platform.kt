package com.smart.clinic.feature.auth

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform