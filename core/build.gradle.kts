import com.mbahgojol.convention.commonMain

plugins {
    id("mbahgojol.kotlin.multiplatform")
    id("mbahgojol.android.library")
}

kotlin {
    commonMain {
        dependencies {

        }
    }
}

android {
    namespace = "com.mbahgojol.core"
}
