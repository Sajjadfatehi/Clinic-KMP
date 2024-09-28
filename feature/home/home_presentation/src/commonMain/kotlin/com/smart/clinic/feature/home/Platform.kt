package com.smart.clinic.feature.home

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform