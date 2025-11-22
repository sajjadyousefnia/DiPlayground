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
}

kapt {
    correctErrorTypes = true
}
