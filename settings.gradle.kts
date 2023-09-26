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
        mavenCentral()
        google()
        mavenLocal()

        // Prerelease versions of Compose Multiplatform
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
// https://docs.gradle.org/7.6/userguide/configuration_cache.html#config_cache:stable
enableFeaturePreview("STABLE_CONFIGURATION_CACHE")

rootProject.name = "Movies-App-KMM"
include(":app")
//include(":crossplatform")

/*include(
    ":core:base",
    ":core:designsystem",
    ":core:database",
)

include(":data")
include(":domain")
include(":ui")
include(":ui:dashboard")
include(":data:movies")
include(":data:models")*/
