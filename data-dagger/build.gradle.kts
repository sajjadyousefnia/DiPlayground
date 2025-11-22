plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

group = "com.sajjady.di"
version = "1.0"

android {
    namespace = "com.sajjady.di.data"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":core"))
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.hilt.core)
    kapt(libs.hilt.compiler)
}
