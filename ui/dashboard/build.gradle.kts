import com.mbahgojol.convention.androidMain

plugins {
    id("mbahgojol.kotlin.multiplatform")
    id("mbahgojol.library.compose")
}

kotlin {
    androidMain {
        dependencies {
            implementation(projects.data.models)
            implementation(projects.domain)
            implementation(projects.data.movies)

            implementation(libs.androidx.core)
            implementation(libs.kotlininject.runtime)

            implementation(libs.androidx.activity.compose)
            implementation(libs.compose.material3.windowsizeclass)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.animation)
        }
    }
}




