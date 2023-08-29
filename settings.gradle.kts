pluginManagement {
    includeBuild("gradle/build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Movies-App-KMM"
include (":app")
include(":crossplatform")
include(":features")
include(":features:home")
include(":shared")
include(":shared:designsystem")
include(":core")
include(":shared:base")
include(":core:models")
include(":core:domain")
include(":core:data")
include(":core:network")
