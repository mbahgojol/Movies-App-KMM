import com.mbahgojol.convention.commonMain

plugins {
    id("mbahgojol.kotlin.multiplatform")
}

kotlin {
    commonMain {
        dependencies {
            implementation(projects.core.data)
            implementation(projects.core.models)
            implementation(projects.shared.base)
        }
    }
}
