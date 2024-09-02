package com.smart.clinic.core.designsystem

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform