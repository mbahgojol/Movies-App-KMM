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

            export(projects.features.home.models)
            export(projects.features.home.data)
            export(projects.features.home.domain)
            export(projects.core.network)
        }
    }

    commonMain {
        dependencies {
            api(projects.core.base)
            api(projects.core.network)
            api(projects.features.home.models)
            api(projects.features.home.data)
            api(projects.features.home.domain)
            api(projects.features.home.ui)
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
