plugins {
    id("mbahgojol.android.library")
    id("mbahgojol.android.library.jacoco")
    id("mbahgojol.android.hilt")
}

android {
    namespace = "com.mbahgojol.core.domain"
}

dependencies {
    implementation(libs.androidx.paging.runtime.ktx)
    implementation(projects.core.common)
    implementation(projects.core.model)
    implementation(projects.core.data)
    implementation(libs.kotlinx.atomicfu)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
}
