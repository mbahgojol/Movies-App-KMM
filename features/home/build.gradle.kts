plugins {
    id("mbahgojol.android.library")
    id("mbahgojol.kotlin.android")
    id("mbahgojol.android.library.compose")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.mbahgojol.home"
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.android.material)

    implementation(libs.kotlininject.runtime)
    ksp(libs.kotlininject.compiler)
}
