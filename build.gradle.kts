buildscript {

}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version "7.1.3" apply false
    id ("com.android.library") version "7.1.3" apply false
    id ("org.jetbrains.kotlin.android") version Kotlin.version apply false
    id ("org.jetbrains.kotlin.jvm") version Kotlin.version apply false
    id ("com.google.dagger.hilt.android") version DaggerHilt.version apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}