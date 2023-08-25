@file:Suppress("unused", "UNUSED_VARIABLE")

import com.mbahgojol.convention.commonMain
import com.mbahgojol.convention.commonTest

plugins {
    id("mbahgojol.kotlin.multiplatform")
    kotlin("native.cocoapods")
    id("mbahgojol.android.library")
    alias(libs.plugins.realm) apply false
    alias(libs.plugins.ksp)
}

kotlin {
    commonMain {
        dependencies {
            implementation(libs.realm.base)
            implementation(libs.realm.sync)

            implementation(libs.kotlin.coroutines.core)
            api(libs.kotlininject.runtime)
        }
    }

    commonTest {
        dependencies {
            implementation(kotlin("test"))
        }
    }
}

android {
    namespace = "com.mbahgojol.crossplatform"
}

ksp {
    arg("me.tatarka.inject.generateCompanionExtensions", "true")
}

addKspDependencyForAllTargets(libs.kotlininject.compiler)
