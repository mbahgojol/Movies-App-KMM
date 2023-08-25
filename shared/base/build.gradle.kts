import com.mbahgojol.convention.commonMain

plugins {
    id("mbahgojol.kotlin.multiplatform")
    id("mbahgojol.android.library")
}

kotlin {
    commonMain {
        dependencies {
            api(libs.kotlin.coroutines.core)
            api(libs.kotlininject.runtime)
        }
    }
}

android {
    namespace = "com.mbahgojol.base"
}
