plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm("desktop")


    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "commonUi"
            isStatic = true
        }
    }

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            api(compose.preview)
            api(libs.androidx.activity.compose)

            api(libs.koin.android)
            api(libs.koin.androidx.compose)
        }
        commonMain.dependencies {

            api(project(":core:designsystem"))

            api(libs.androidx.lifecycle.viewmodel)
            api(libs.jetbrains.androidx.navigation.compose)
            api(libs.jetbrains.kotlin.serialization)

            api(libs.koin.core)
            api(libs.koin.compose)
            api(libs.koin.compose.viewmodel)

        }

        desktopMain.dependencies {
            api(compose.desktop.currentOs)
            api(libs.kotlinx.coroutines.swing)
        }
    }
}

android {
    namespace = "com.smart.clinic.common.commonUi"
    compileSdk = 34
    defaultConfig {
        minSdk = 23
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
dependencies {
    api(libs.androidx.navigation.compose)
    api(libs.androidx.navigation.runtime.ktx)
}
