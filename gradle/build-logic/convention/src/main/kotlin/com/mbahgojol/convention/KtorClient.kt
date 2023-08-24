package com.mbahgojol.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureKtorClient(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    commonExtension.apply {
        dependencies {
            add("implementation", libsExt.findBundle("ktor").get())
            add("implementation", libsExt.findLibrary("kotlinx.coroutines.android").get())
            add("implementation", libsExt.findLibrary("kotlinx.coroutines.core").get())
        }
    }
}
