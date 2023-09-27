plugins {
    `kotlin-dsl`
    alias(libs.plugins.spotless)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.spotless.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
}

gradlePlugin {
    plugins {
        create(PluginInfo.name) {
            id = PluginInfo.group
            implementationClass = PluginInfo.implementationClass
            displayName = PluginInfo.displayName
            description = PluginInfo.description
        }

        register("androidTest") {
            id = "mbahgojol.test"
            implementationClass = "AndroidTestConventionPlugin"
        }

        register("androidLibraryJacoco") {
            id = "mbahgojol.library.jacoco"
            implementationClass = "AndroidLibraryJacocoConventionPlugin"
        }

        register("androidApplicationJacoco") {
            id = "mbahgojol.application.jacoco"
            implementationClass = "AndroidApplicationJacocoConventionPlugin"
        }

        register("androidApplication") {
            id = "mbahgojol.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = "mbahgojol.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("kotlinAndroid") {
            id = "mbahgojol.kotlin.android"
            implementationClass = "KotlinAndroidConventionPlugin"
        }

        register("kotlinMultiplatform") {
            id = "mbahgojol.kotlin.multiplatform"
            implementationClass = "KotlinMultiplatformConventionPlugin"
        }

        register("compose") {
            id = "mbahgojol.library.compose"
            implementationClass = "ComposeMultiplatformConventionPlugin"
        }
    }
}

object PluginInfo {
    const val description = "A Gradle plugin for providing secrets securely to an Android project."
    const val displayName = "Secrets Gradle Plugin for Android"
    const val group = "com.mbahgojol.secrets_gradle_plugin"
    const val implementationClass =
        "com.mbahgojol.secrets_gradle_plugin.SecretsPlugin"
    const val name = "secretsGradlePlugin"
}
