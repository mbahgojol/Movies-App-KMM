import com.mbahgojol.convention.androidMain
import com.mbahgojol.convention.commonMain
import com.mbahgojol.convention.iosMain

plugins {
    id("mbahgojol.kotlin.multiplatform")
    alias(libs.plugins.realm) apply false
}

kotlin {
    androidMain {
        dependencies {
            implementation(libs.ktor.client.okhttp)
        }
    }

    commonMain {
        dependencies {
            implementation(libs.realm.base)
            implementation(libs.realm.sync)

            implementation(libs.ktor.client.core)
            implementation(projects.shared.base)
            implementation(libs.kotlininject.runtime)
        }
    }

    iosMain {
        dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}
