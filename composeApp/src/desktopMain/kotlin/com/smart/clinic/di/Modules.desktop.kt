package com.smart.clinic.di

import com.smart.clinic.data.DbClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


actual val platformModule = module {
    singleOf(::DbClient)
}