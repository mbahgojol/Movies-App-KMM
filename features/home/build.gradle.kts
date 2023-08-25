plugins {
    id("mbahgojol.android.library")
    id("mbahgojol.kotlin.android")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.mbahgojol.home"
}

dependencies {
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlininject.runtime)
    ksp(libs.kotlininject.compiler)
}
