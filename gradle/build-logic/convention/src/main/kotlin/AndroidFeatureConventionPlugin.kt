@file:Suppress("unused")

import com.mbahgojol.convention.libsExt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("mbahgojol.android.library")
                apply("mbahgojol.kotlin.android")
                apply("mbahgojol.android.hilt")
            }

            dependencies {
                add("implementation", libsExt.findLibrary("timber").get())
                add("implementation", libsExt.findLibrary("androidx.core").get())
                add("implementation", libsExt.findLibrary("androidx.appcompat").get())
                add("implementation", libsExt.findLibrary("google.android.material").get())

                add("implementation", project(":core:model"))
                add("implementation", project(":core:designsystem"))
                add("implementation", project(":core:common"))
                add("implementation", project(":core:domain"))

                add("implementation", libsExt.findLibrary("coil.coil").get())
                add("implementation", libsExt.findLibrary("coil.compose").get())
                add("implementation", libsExt.findLibrary("coil.gif").get())

                add("implementation", libsExt.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libsExt.findLibrary("androidx.lifecycle.runtime.ktx").get())
                add("implementation", libsExt.findLibrary("androidx.lifecycle.viewmodel.ktx").get())
                add(
                    "implementation",
                    libsExt.findLibrary("androidx.lifecycle.runtimeCompose").get(),
                )
                add(
                    "implementation",
                    libsExt.findLibrary("androidx.lifecycle.viewModelCompose").get(),
                )
                add(
                    "implementation",
                    libsExt.findLibrary("androidx.constraintlayout.compose").get(),
                )

                add("implementation", libsExt.findLibrary("kotlinx.coroutines.android").get())
                add("implementation", libsExt.findLibrary("kotlinx.coroutines.core").get())
                add("implementation", platform(libsExt.findLibrary("kotlin.bom").get()))

                add("testImplementation", libsExt.findLibrary("junit").get())
                add("androidTestImplementation", libsExt.findLibrary("androidx.test.junit").get())
                add(
                    "androidTestImplementation",
                    libsExt.findLibrary("androidx.test.espresso").get(),
                )
            }
        }
    }

}
