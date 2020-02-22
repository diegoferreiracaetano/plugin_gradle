package com.diegoferreiracaetano.versions

import com.diegoferreiracaetano.versions.dependencies.AndroidTestExtension
import com.diegoferreiracaetano.versions.dependencies.Dependencies
import com.diegoferreiracaetano.versions.dependencies.LibsExtension
import com.diegoferreiracaetano.versions.dependencies.TestExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {

    private val root = Project.GRADLE_PROPERTIES

    override fun apply(project: Project) {
        project.extensions.create("LIBS", Dependencies::class.java)
        project.extensions.create("LIB", LibsExtension::class.java)
        project.extensions.create("TEST", TestExtension::class.java)
        project.extensions.create("ANDROID_TEST", AndroidTestExtension::class.java)

        project.apply {
            it.from("${project.parent?.rootDir}/tools/ktlint.gradle")
            it.from("${project.parent?.rootDir}/tools/base.gradle")
        }
    }
}
