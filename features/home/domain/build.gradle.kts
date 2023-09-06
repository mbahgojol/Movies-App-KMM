import com.mbahgojol.convention.commonMain

plugins {
    id("mbahgojol.kotlin.multiplatform")
}

kotlin {
    commonMain {
        dependencies {
            implementation(projects.features.home.data)
            implementation(projects.features.home.models)
            implementation(projects.core.base)
        }
    }
}
