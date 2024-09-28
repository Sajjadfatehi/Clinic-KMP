rootProject.name = "Clinic"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":feature:auth:auth_presentation")
include(":feature:auth:auth_domain")
include(":feature:auth:auth_data")
include(":feature:onboarding")
include(":common:commonUi")
include(":common:commonData")
include(":core:designsystem")
include(":core:database")
include(":core:datastore")
include(":feature:home:home_presentation")
include(":feature:home:home_domain")
include(":feature:home:home_data")
