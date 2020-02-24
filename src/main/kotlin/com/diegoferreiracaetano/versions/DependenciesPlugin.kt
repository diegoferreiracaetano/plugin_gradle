package com.diegoferreiracaetano.versions

import com.android.build.gradle.BaseExtension
import com.diegoferreiracaetano.versions.dependencies.AndroidTestExtension
import com.diegoferreiracaetano.versions.dependencies.Dependencies
import com.diegoferreiracaetano.versions.dependencies.LibsExtension
import com.diegoferreiracaetano.versions.dependencies.TestExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.io.FileInputStream
import java.util.*

class DependenciesPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        project.extensions.create("LIBS", Dependencies::class.java)
        project.extensions.create("LIB", LibsExtension::class.java)
        project.extensions.create("TEST", TestExtension::class.java)
        project.extensions.create("ANDROID_TEST", AndroidTestExtension::class.java)
        project.apply {

            it.plugin("jacoco")
            it.from("https://raw.githubusercontent.com/diegoferreiracaetano/plugin_gradle/master/tools/ktlint.gradle")
            it.from("https://raw.githubusercontent.com/diegoferreiracaetano/plugin_gradle/master/tools/jacoco.gradle")
            it.from("https://raw.githubusercontent.com/diegoferreiracaetano/plugin_gradle/master/tools/sonar.gradle")

            if (project.hasProperty("android")) {

                if (project.name == "app") {
                    it.plugin("com.android.application")
                } else {
                    it.plugin("com.android.library")
                }

                it.plugin("kotlin-android")
                it.plugin("kotlin-android-extensions")
                it.plugin("com.github.triplet.play")

                project.configure(listOf<BaseExtension>()) {
                    it.signingConfigs {

                        it.register("customDebug") {
                            it.storeFile = File("/debug.keystore")
                            it.storePassword = "android"
                            it.keyAlias = "androiddebugkey"
                            it.keyPassword = "android"
                        }

                        it.register("release") {
                            if (File("../signing.properties").canRead()) {
                                val properties = Properties()
                                properties.load(FileInputStream("../signing.properties"))

                                it.storeFile = File(properties.getProperty("STORE_FILE"))
                                it.storePassword = properties.getProperty("STORE_PASSWORD")
                                it.keyAlias = properties.getProperty("KEY_ALIAS")
                                it.keyPassword = properties.getProperty("KEY_PASSWORD")

                            } else {
                                it.storeFile = File("${project.rootDir}/debug.keystore")
                                it.storePassword = "android"
                                it.keyAlias = "androiddebugkey"
                                it.keyPassword = "android"
                            }
                        }
                    }
                }
            }
        }
    }

}
