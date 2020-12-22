object App {
    val petproject = "com.android.com"
}

object Modules {
    val app = ":app"
    const val remote = ":remote"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object DefaultConfig {
    const val minSdk = 21
    const val targetSdk = 29
    const val compileSdk = 29
}

object Versions {
    const val gradle = "4.0.2"
    const val kotlin = "1.4.10"
    const val nav_version = "2.3.0-rc01"
    const val support = "1.1.0"
    const val constraint = "2.0.4"
    const val lifecycle = "2.2.0"
    const val lifecycleTesting = "2.1.0"
    const val glide = "4.11.0"
    const val junit = "4.13"
    const val mockk = "1.10.0"
    const val legacy = "1.0.0"
    const val timber = "4.7.1"
    const val junitTest = "1.1.2"
    const val espresso = "3.3.0"
    const val hilt = "2.28-alpha"
    const val hiltViewModel = "1.0.0-alpha01"
}

object Deps {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //Support Libraries
    val appcompat = "androidx.appcompat:appcompat:1.3.0-alpha01"
    val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    val core = "androidx.core:core-ktx:1.2.0"
    val core_utils = "androidx.legacy:legacy-support-core-utils:${Versions.legacy}"
    val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"

    val design = "com.google.android.material:material:1.3.0-alpha03"


    val junit = "junit:junit:${Versions.junit}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"


    //glide
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    //coroutines
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.6"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.6"
    val workCoroutines = "androidx.work:work-runtime-ktx:2.3.4"

    //lifecycle
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycleTesting}"

    // navigation
    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"


    val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    val junitTest = "androidx.test.ext:junit:${Versions.junitTest}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // hilt
    val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"
    val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltViewModel}"
}
