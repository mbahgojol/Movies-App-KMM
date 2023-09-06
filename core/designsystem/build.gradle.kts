import com.mbahgojol.convention.libsExt

plugins {
    id("mbahgojol.android.library")
    id("mbahgojol.kotlin.android")
}

android {
    namespace = "com.mbahgojol.designsystem"
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.android.material)
}
