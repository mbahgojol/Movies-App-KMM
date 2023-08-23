@file:Suppress("unused")

import com.mbahgojol.convention.cocoapods
import com.mbahgojol.convention.configureKotlin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.configurationcache.extensions.capitalized
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType

@OptIn(ExperimentalKotlinGradlePluginApi::class)
class KotlinMultiplatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("org.jetbrains.kotlin.multiplatform")
            apply("org.jetbrains.kotlin.native.cocoapods")
        }

        extensions.configure<KotlinMultiplatformExtension> {
            targetHierarchy.default()

            android {
                compilations.all {
                    kotlinOptions {
                        jvmTarget = JavaVersion.VERSION_17.toString()
                    }
                }
            }

            iosX64()
            iosArm64()
            iosSimulatorArm64()

            cocoapods {
                summary = "Some description for the Shared Module"
                homepage = "Link to the Shared Module homepage"
                version = "1.0"
                ios.deploymentTarget = "14.1"
                podfile = project.file("../iosApp/Podfile")
                framework {
                    baseName = "crossplatform"
                }
            }

            configureKotlin()
        }
    }
}

fun Project.addKspDependencyForAllTargets(dependencyNotation: Any) =
    addKspDependencyForAllTargets("", dependencyNotation)

fun Project.addKspTestDependencyForAllTargets(dependencyNotation: Any) =
    addKspDependencyForAllTargets("Test", dependencyNotation)

private fun Project.addKspDependencyForAllTargets(
    configurationNameSuffix: String,
    dependencyNotation: Any,
) {
    val kmpExtension = extensions.getByType<KotlinMultiplatformExtension>()
    dependencies {
        kmpExtension.targets.asSequence().filter { target ->
            // Don't add KSP for common target, only final platforms
            target.platformType != KotlinPlatformType.common
        }.forEach { target ->
            add(
                "ksp${target.targetName.capitalized()}$configurationNameSuffix",
                dependencyNotation,
            )
        }
    }
}
