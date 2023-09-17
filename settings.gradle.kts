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
    ":core:database",
)

include(":data")
include(":domain")
include(":ui")
include(":ui:dashboard")
include(":data:movies")
include(":data:models")
