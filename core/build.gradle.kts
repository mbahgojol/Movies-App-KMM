import com.mbahgojol.convention.commonMain
import com.mbahgojol.convention.iosMain

plugins {
    id("mbahgojol.kotlin.multiplatform")
    alias(libs.plugins.realm) apply false
}

kotlin {
    commonMain {
        dependencies {
            implementation(libs.realm.base)
            implementation(libs.realm.sync)

            implementation(libs.ktor.client.core)
            implementation(projects.shared.base)
        }
    }

    iosMain {
        dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}
