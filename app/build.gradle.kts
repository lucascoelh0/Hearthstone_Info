import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(Plugin.Android.application)
    id(Plugin.Kotlin.android)
    id(Plugin.Jetbrains.kotlin)
    id(Plugin.Hilt.android)
    kotlin(Plugin.Kotlin.kapt)
}

android {
    namespace = "com.luminay.hearthstoneinfo"
    compileSdk = 34
    val apiKey: String = gradleLocalProperties(rootDir).getProperty("API_KEY")
    val apiHost: String = gradleLocalProperties(rootDir).getProperty("API_HOST")

    defaultConfig {
        applicationId = "com.luminay.hearthstoneinfo"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        all {
            buildConfigField("String", "API_KEY", apiKey)
            buildConfigField("String", "API_HOST", apiHost)
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kapt {
        javacOptions {
            option("-Adagger.hilt.android.internal.disableAndroidSuperclassValidation=true")
        }
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.lifecycleRuntimeKtx)
    implementation(Dependencies.Compose.activityCompose)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.coilCompose)
    implementation(Dependencies.Hilt.hiltAndroid)
    kapt(Dependencies.Hilt.hiltCompiler)
    implementation(Dependencies.Hilt.hiltPlugin)
    implementation(Dependencies.Hilt.hiltNavigationCompose)
    implementation(Dependencies.SquareUp.okhttp)
    implementation(Dependencies.SquareUp.okhttpLoggingInterceptor)
    implementation(Dependencies.SquareUp.retrofit)
    implementation(Dependencies.SquareUp.retrofitConverterGson)
    implementation(Dependencies.Google.gson)
    implementation(Dependencies.Libraries.networkResponseAdapter)
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.androidxTestExtJunit)
    androidTestImplementation(Dependencies.Test.espressoCore)
    androidTestImplementation(Dependencies.Test.uiTestJunit4)
    debugImplementation(Dependencies.Compose.uiTooling)
}
