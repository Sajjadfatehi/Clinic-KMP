package com.smart.clinic.feature.auth.data

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform