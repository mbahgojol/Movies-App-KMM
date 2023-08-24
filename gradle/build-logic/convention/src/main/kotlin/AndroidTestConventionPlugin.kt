@file:Suppress("unused")

import com.android.build.gradle.TestExtension
import com.mbahgojol.convention.libsExt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.test")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<TestExtension> {
                dependencies {
                    add("testImplementation", libsExt.findLibrary("junit").get())
                    add("androidTestImplementation", libsExt.findLibrary("androidx.test.junit").get())
                    add(
                        "androidTestImplementation",
                        libsExt.findLibrary("androidx.test.espresso").get()
                    )
                    add(
                        "androidTestImplementation",
                        platform(libsExt.findLibrary("compose.bom").get())
                    )
                    add("androidTestImplementation", libsExt.findLibrary("compose.ui.test").get())
                    add("debugImplementation", libsExt.findLibrary("compose.ui.tooling").get())
                    add("debugImplementation", libsExt.findLibrary("compose.ui.test.manifest").get())
                }
            }
        }
    }

}
