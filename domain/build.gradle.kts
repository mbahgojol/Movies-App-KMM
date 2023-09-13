import com.mbahgojol.convention.commonMain

plugins {
    id("mbahgojol.kotlin.multiplatform")
}

kotlin {
    commonMain {
        dependencies {
            implementation(projects.data.movies)
            implementation(projects.data.models)
            implementation(projects.core.base)
        }
    }
}
