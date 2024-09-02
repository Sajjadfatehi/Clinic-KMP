package com.smart.clinic.common.commonData

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform