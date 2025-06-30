plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.testecosystemalpha"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.testecosystemalpha"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation(libs.converter.gson)

    // room
    implementation ("androidx.room:room-runtime:2.7.2")
    implementation ("androidx.room:room-ktx:2.7.2")
    kapt ("androidx.room:room-compiler:2.7.2")

    // navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:2.9.0")
    implementation ("androidx.navigation:navigation-ui-ktx:2.9.0")
    implementation ("androidx.navigation:navigation-safe-args-gradle-plugin:2.9.0")

    // coroutine
    implementation (libs.kotlinx.coroutines.core)
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

    // recycler
    implementation("androidx.recyclerview:recyclerview:1.4.0")


    //viewModel compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.1")

    //activity
    implementation ("androidx.activity:activity-ktx:1.10.1")

    //dagger2
    implementation ("com.google.dagger:dagger:2.55")
    implementation ("com.google.dagger:dagger-android-support:2.55")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.55")
}