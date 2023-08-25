@file:Suppress("unused")

import com.mbahgojol.convention.cocoapods
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
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        this.podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "crossplatform"
        }
    }

    commonMain {
        dependencies {
            // database
            implementation(libs.realm.base)
            implementation(libs.realm.sync)

            // core
            api(projects.shared.base)
            api(projects.shared.models)

            // features
//            api(projects.shared.designsystem)
//            api(projects.features.home)
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
