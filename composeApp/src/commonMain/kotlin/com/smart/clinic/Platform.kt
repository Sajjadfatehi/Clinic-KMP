package com.smart.clinic

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform