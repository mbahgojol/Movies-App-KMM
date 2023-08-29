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

            export(projects.core.models)
            export(projects.core.data)
            export(projects.core.domain)
            export(projects.core.network)
        }
    }

    commonMain {
        dependencies {
            api(projects.shared.base)
            api(projects.core.models)
            api(projects.core.data)
            api(projects.core.domain)
            api(projects.core.network)
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
