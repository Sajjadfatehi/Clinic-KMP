package com.smart.clinic.di

import com.smart.clinic.data.TestProvideImpl
import com.smart.clinic.data.TestProvider
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val shareModule = module {
    singleOf(::TestProvideImpl).bind<TestProvider>()
}
