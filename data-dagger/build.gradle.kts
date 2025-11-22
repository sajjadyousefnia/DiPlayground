plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.kapt)
}

group = "com.sajjady.di"
version = "1.0"

kotlin {
    jvmToolchain(11)
}

dependencies {
    implementation(project(":core"))
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.hilt.core)
    kapt(libs.hilt.compiler)
}

kapt {
    correctErrorTypes = true
}
