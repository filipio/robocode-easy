plugins {
    id("net.sf.robocode.java-conventions")
    application
    `java-library`
}

application {
  mainClassName = "net.sf.robocode.main.Robocode"
}

description = "Robocode Main application"

dependencies {
    api(project(":robocode.api"))
    implementation(project(":robocode.battle"))
    implementation(project(":robocode.core"))
    implementation(project(":robocode.host"))
    implementation(project(":robocode.repository"))
    implementation(project(":robocode.roborumble"))
    implementation(project(":robocode.sound"))
    implementation(project(":robocode.ui"))
    implementation(project(":robocode.ui.editor"))
    implementation(project(":robocode.tests"))
    implementation(project(":robocode.samples"))
}

tasks {
    publishMavenJavaPublicationToSonatypeRepository {
        enabled = false
    }
}