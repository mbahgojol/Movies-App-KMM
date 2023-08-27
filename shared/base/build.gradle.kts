import com.mbahgojol.convention.commonMain

plugins {
    id("mbahgojol.kotlin.multiplatform")
}

kotlin {
    commonMain {
        dependencies {
            api(libs.kotlin.coroutines.core)
            api(libs.kotlininject.runtime)
        }
    }
}
