import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    id("org.jetbrains.compose") version "0.4.0"
}

group = "de.jan"
version = "1.0"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
}

dependencies {
    implementation("org.pushing-pixels:aurora-skin:0.0.40-SNAPSHOT")
    implementation("org.pushing-pixels:aurora-icon-icon:0.0.40-SNAPSHOT")
    implementation("org.pushing-pixels:aurora-component:0.0.40-SNAPSHOT")
    implementation("org.pushing-pixels:aurora-window:0.0.40-SNAPSHOT")
    implementation(compose.desktop.currentOs)
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Jet"
            packageVersion = "1.0.0"
        }
    }
}