@file:Suppress("unused")

import com.mbahgojol.convention.cocoapods
import com.mbahgojol.convention.commonMain
import com.mbahgojol.convention.commonTest

plugins {
    id("mbahgojol.kotlin.multiplatform")
    kotlin("native.cocoapods")
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
//            api(projects.shared.base)
//            api(projects.shared.models)
            api(projects.core)
        }
    }

    commonTest {
        dependencies {
            implementation(kotlin("test"))
        }
    }
}

ksp {
    arg("me.tatarka.inject.generateCompanionExtensions", "true")
}

addKspDependencyForAllTargets(libs.kotlininject.compiler)
