// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Librerias por defecto de Android
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false

    // safeargs para pasar argumentos entre fragmentos
    alias(libs.plugins.androidx.navigation.safeargs) apply false

    // Generación de documentación con Dokka
    alias(libs.plugins.kotlin.dokka) apply false

    // Ktlint para formatear el código
    alias(libs.plugins.ktlint)
}
