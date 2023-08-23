plugins {
    id("mbahgojol.android.application")
    id("mbahgojol.kotlin.android")
    id("mbahgojol.android.application.compose")
    id("mbahgojol.android.application.flavors")
}

android {
    buildFeatures {
        buildConfig = true
    }

    namespace = "com.mbahgojol.cleanarchitecture"

    defaultConfig {
        applicationId = "com.mbahgojol.cleanarchitecture"
    }
}

dependencies {
    implementation(projects.crossplatform)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
}
