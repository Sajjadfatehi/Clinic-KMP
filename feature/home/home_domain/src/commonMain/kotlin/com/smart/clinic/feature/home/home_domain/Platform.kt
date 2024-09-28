package com.smart.clinic.feature.home.home_domain

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform