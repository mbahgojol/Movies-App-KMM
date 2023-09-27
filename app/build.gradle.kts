@file:Suppress("UnstableApiUsage")

plugins {
    id("mbahgojol.application")
    id("mbahgojol.kotlin.android")
    id("mbahgojol.library.compose")
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

    implementation(compose.foundation)
    implementation(compose.material)
    implementation(compose.material3)

    implementation(libs.kotlin.coroutines.android)
    implementation(libs.androidx.activity.activity)
    implementation(libs.androidx.activity.compose)

    implementation(libs.kotlininject.runtime)
    ksp(libs.kotlininject.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
}
