import com.mbahgojol.convention.androidMain

plugins {
    id("mbahgojol.kotlin.multiplatform")
    id("mbahgojol.android.library.compose")
}

kotlin {
    androidMain {
        dependencies {
            implementation(projects.data.models)
            implementation(projects.domain)
            implementation(projects.data.movies)

            implementation(libs.androidx.core)
            implementation(libs.androidx.appcompat)
            implementation(libs.google.android.material)

            implementation(libs.kotlininject.runtime)
        }
    }
}




