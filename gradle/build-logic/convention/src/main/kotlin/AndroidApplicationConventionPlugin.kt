@file:Suppress("unused")

import com.android.build.api.dsl.ApplicationExtension
import com.mbahgojol.convention.configureAndroid
import com.mbahgojol.convention.configureBuildTypes
import com.mbahgojol.convention.configureDefaultConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.gradle.android.cache-fix")
            }

            extensions.configure<ApplicationExtension> {
                configureAndroid()
                configureDefaultConfig(this)
                configureBuildTypes(this)
            }
        }
    }

}
