plugins {
    id("mbahgojol.android.library")
    id("mbahgojol.kotlin.android")
    id("mbahgojol.android.library.compose")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.mbahgojol.home.ui"
}

dependencies {
    implementation(projects.features.home.models)
    implementation(projects.features.home.domain)
    implementation(projects.features.home.data)

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.android.material)

    implementation(libs.kotlininject.runtime)
    ksp(libs.kotlininject.compiler)
}
