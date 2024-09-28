package com.smart.clinic.feature.home.home_data

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform