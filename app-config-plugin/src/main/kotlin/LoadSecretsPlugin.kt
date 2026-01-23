package com.example.appconfigplugin

import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.extra
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.Properties

class LoadSecretsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            setApiProperties(loadLocalProperty())
        }
    }
}

internal fun Project.loadLocalProperty(file: String = "keystore.properties"): ProjectProperties {
    val projectProperties = Properties()
    val localProperties = File(file)
    if (localProperties.isFile) {
        FileInputStream(localProperties).use { fis ->
            val reader = InputStreamReader(fis, StandardCharsets.UTF_8)
            projectProperties.load(reader)
        }
    } else {
        throw GradleException("Missing $file")
    }
    return ProjectProperties(
        baseUrl = projectProperties.getProperty("BASE_URL"),
        apiKey = projectProperties.getProperty("API_KEY"),

    )
}

private fun Project.setApiProperties(projectProperties: ProjectProperties) {
    rootProject.extra.set("ProjectProperties", projectProperties)
}

fun Project.projectProperties(): Provider<ProjectProperties> = provider {
    rootProject.extra.get("ProjectProperties") as ProjectProperties
}