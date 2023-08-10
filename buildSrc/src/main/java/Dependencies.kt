object Dependencies {

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleRuntimeKtx}"
        const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    }

    object Compose {
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Version.hiltNavigationCompose}"
        const val activityCompose = "androidx.activity:activity-compose:${Version.activityCompose}"
        const val ui = "androidx.compose.ui:ui"
        const val uiGraphics = "androidx.compose.ui:ui-graphics"
        const val uiTooling = "androidx.compose.ui:ui-tooling"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val material3 = "androidx.compose.material3:material3"
        const val coilCompose = "io.coil-kt:coil-compose:${Version.coil}"
    }

    object Google {
        const val material = "com.google.android.material:material:${Version.material}"
        const val gson = "com.google.code.gson:gson:${Version.gson}"
    }

    object Hilt {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
        const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
    }

    object Libraries {
        const val networkResponseAdapter = "com.github.haroldadmin:NetworkResponseAdapter:${Version.networkResponseAdapter}"
    }

    object SquareUp {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Version.okhttp}"
        const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    }

    object Test {
        const val junit = "junit:junit:${Version.junit}"
        const val androidxTestExtJunit = "androidx.test.ext:junit:${Version.androidxTestExtJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"
        const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4"
    }
}
