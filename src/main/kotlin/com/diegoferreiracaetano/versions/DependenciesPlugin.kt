package com.diegoferreiracaetano.versions

import com.diegoferreiracaetano.versions.dependencies.AndroidTestExtension
import com.diegoferreiracaetano.versions.dependencies.Dependencies
import com.diegoferreiracaetano.versions.dependencies.LibsExtension
import com.diegoferreiracaetano.versions.dependencies.TestExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.create("LIBS", Dependencies::class.java)
        project.extensions.create("LIB", LibsExtension::class.java)
        project.extensions.create("TEST", TestExtension::class.java)
        project.extensions.create("ANDROID_TEST", AndroidTestExtension::class.java)
        project.apply {
            it.from("https://raw.githubusercontent.com/diegoferreiracaetano/plugin_gradle/master/tools/ktlint.gradle")
            it.from("https://raw.githubusercontent.com/diegoferreiracaetano/plugin_gradle/master/tools/jacoco.gradle")
            it.from("https://raw.githubusercontent.com/diegoferreiracaetano/plugin_gradle/master/tools/sonar.gradle")
            it.plugin("jacoco")

            if (project.hasProperty("android")) {
                it.plugin("kotlin-android")
                it.plugin("kotlin-android-extensions")

                if (project.name == "driver.app") {

                    it.plugin("com.android.application")
                    it.plugin("com.github.triplet.play")

                }
            }
        }
    }
}
