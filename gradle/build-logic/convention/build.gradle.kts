plugins {
    `kotlin-dsl`
}

group = "mbahgojol.buildlogic.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
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
            id = "mbahgojol.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("androidLibraryJacoco") {
            id = "mbahgojol.android.library.jacoco"
            implementationClass = "AndroidLibraryJacocoConventionPlugin"
        }
        register("androidApplicationJacoco") {
            id = "mbahgojol.android.application.jacoco"
            implementationClass = "AndroidApplicationJacocoConventionPlugin"
        }
        register("androidFlavors") {
            id = "mbahgojol.android.application.flavors"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }
        register("androidApplication") {
            id = "mbahgojol.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "mbahgojol.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidFeature") {
            id = "mbahgojol.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidLibrary") {
            id = "mbahgojol.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "mbahgojol.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("kotlinAndroid") {
            id = "mbahgojol.kotlin.android"
            implementationClass = "KotlinAndroidConventionPlugin"
        }
        register("kotlinMultiplatform") {
            id = "mbahgojol.kotlin.multiplatform"
            implementationClass = "KotlinMultiplatformConventionPlugin"
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
