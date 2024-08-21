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

//        google {
//            content {
//                includeGroupByRegex("com\\.android.*")
//                includeGroupByRegex("com\\.google.*")
//                includeGroupByRegex("androidx.*")
//            }
//        }
//        mavenCentral()
//        gradlePluginPortal()
//
//        maven {
//            // google()
//            url = uri("https://repo.snapp.tech/repository/android-repo-google/")
//        }
//        maven {
//            // url "https://maven.google.com/"
//            url= uri("https://repo.snapp.tech/repository/android-repo-maven-google/")
//        }
//
//        maven {
//            // mavenCentral()
//            url =uri("https://repo.snapp.tech/repository/android-repo-maven/")
//        }
//        maven {
//            // url "https://plugins.gradle.org/m2/"
//            url=uri( "https://repo.snapp.tech/repository/android-repo-plugins/")
//        }
//        maven {
//            // jcenter()
//            url=uri( "https://repo.snapp.tech/repository/android-repo-jcenter-bintray/")
//        }
//
//        // support HMS in Snapp LocationKit Module
//        maven { url = uri("https://repo.snapp.tech/repository/android-repo-huawei/") }
//
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