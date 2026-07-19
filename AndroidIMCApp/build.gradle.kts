// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Librerias por defecto de Android
    alias(libs.plugins.android.application) apply false

    // safeargs para pasar argumentos entre fragmentos
    alias(libs.plugins.androidx.navigation.safeargs) apply false

    // Generación de documentación con Dokka
    alias(libs.plugins.kotlin.dokka)

    // Ktlint para formatear el código
    alias(libs.plugins.ktlint)
}

ktlint {
    // Aplica las reglas de estilo de Android
    android.set(true)
    // Falla si se encuentran errores de estilo
    ignoreFailures.set(false)
    // Genera informes de errores en formato texto y HTML
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.HTML)
    }
}
