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
include(":app")
include(":crossplatform")

include(
    ":core:base",
    ":core:designsystem",
    ":core:network",
)

include(
    ":features:home:ui",
    ":features:home:models",
    ":features:home:domain",
    ":features:home:data",
)
