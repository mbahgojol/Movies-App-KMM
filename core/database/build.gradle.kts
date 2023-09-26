import com.mbahgojol.convention.commonMain

plugins {
    id("mbahgojol.kotlin.multiplatform")
}

kotlin {
    commonMain {
        dependencies {
            implementation(projects.core.base)
            implementation(libs.kotlininject.runtime)
        }
    }
}
