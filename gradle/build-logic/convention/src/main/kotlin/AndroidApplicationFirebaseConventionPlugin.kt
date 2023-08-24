@file:Suppress("unused")

import com.android.build.api.dsl.ApplicationExtension
import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension
import com.mbahgojol.convention.libsExt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationFirebaseConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.gms.google-services")
                apply("com.google.firebase.firebase-perf")
                apply("com.google.firebase.crashlytics")
            }

            dependencies {
                val bom = libsExt.findLibrary("firebase-bom").get()
                add("implementation", platform(bom))
                "implementation"(libsExt.findLibrary("firebase.analytics").get())
                "implementation"(libsExt.findLibrary("firebase.perf").get())
                "implementation"(libsExt.findLibrary("firebase.crashlytics").get())
            }

            extensions.configure<ApplicationExtension> {
                buildTypes.configureEach {
                    // Disable the Crashlytics mapping file upload. This feature should only be
                    // enabled if a Firebase backend is available and configured in
                    // google-services.json.
                    configure<CrashlyticsExtension> {
                        mappingFileUploadEnabled = false
                    }
                }
            }
        }
    }
}
