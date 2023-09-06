@file:Suppress("UnstableApiUsage")

plugins {
    id("mbahgojol.android.application")
    id("mbahgojol.kotlin.android")
    id("mbahgojol.android.application.compose")
    id("mbahgojol.android.application.flavors")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.mbahgojol.movies"

    defaultConfig {
        applicationId = "com.mbahgojol.movies"
    }

    buildFeatures {
        buildConfig = true
    }

    lint {
        baseline = file("lint-baseline.xml")
        checkReleaseBuilds = false
        ignoreTestSources = true
        abortOnError = true
    }
}

dependencies {
    implementation(projects.crossplatform)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlininject.runtime)
    ksp(libs.kotlininject.compiler)

    implementation(projects.features.home.ui)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
}
