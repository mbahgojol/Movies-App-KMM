plugins {
    id("mbahgojol.library")
    id("mbahgojol.kotlin.android")
}

android {
    namespace = "com.mbahgojol.designsystem"
}

dependencies {
    implementation(libs.androidx.core)
}
