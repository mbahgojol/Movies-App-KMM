@file:Suppress("unused")

import com.mbahgojol.convention.libsExt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.kapt")
                apply("com.google.dagger.hilt.android")
            }

            dependencies {
                "implementation"(libsExt.findLibrary("hilt.android").get())
                "kapt"(libsExt.findLibrary("hilt.compiler").get())
                "kaptAndroidTest"(libsExt.findLibrary("hilt.compiler").get())
            }

        }
    }

}
