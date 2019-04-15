package com.diegoferreiracaetano.versions

import com.diegoferreiracaetano.versions.dependencies.AndroidTestExtension
import com.diegoferreiracaetano.versions.dependencies.LibsExtension
import com.diegoferreiracaetano.versions.dependencies.TestExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("libs", LibsExtension::class.java)
        project.extensions.create("test", TestExtension::class.java)
        project.extensions.create("androidTest", AndroidTestExtension::class.java)
    }
}
