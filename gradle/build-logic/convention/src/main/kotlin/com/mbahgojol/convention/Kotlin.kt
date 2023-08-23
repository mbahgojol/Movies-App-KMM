@file:Suppress("unused", "HasPlatformType")

package com.mbahgojol.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.cocoapods.CocoapodsExtension

fun Project.configureKotlin() {
    configureJava()
}

fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}


fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.androidMain(block: KotlinSourceSet.() -> Unit) =
    sourceSets.getByName("androidMain", block)

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.commonMain(block: KotlinSourceSet.() -> Unit) =
    sourceSets.getByName("commonMain", block)

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.commonTest(block: KotlinSourceSet.() -> Unit) =
    sourceSets.getByName("commonTest", block)

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.iosMain(block: KotlinSourceSet.() -> Unit) =
    sourceSets.getByName("iosMain", block)

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.cocoapods(configure: Action<CocoapodsExtension>): Unit =
    (this as ExtensionAware).extensions.configure("cocoapods", configure)
