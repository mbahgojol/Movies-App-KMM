import com.mbahgojol.convention.commonMain

plugins {
    id("mbahgojol.kotlin.multiplatform")
    alias(libs.plugins.realm) apply false
}

kotlin {
    commonMain {
        dependencies {
            implementation(libs.realm.base)
            implementation(libs.realm.sync)

            implementation(projects.core.base)
            implementation(libs.kotlininject.runtime)
        }
    }
}
