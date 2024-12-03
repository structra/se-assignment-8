plugins {
    id("java")
}

group = "org.structra"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<JavaCompile> {
    options.release.set(17)
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // JSON library
    implementation("com.google.code.gson:gson:2.10.1")

    // Lombok annotations
    implementation("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}

sourceSets.main {
    java.srcDirs("src/main/java")
}

tasks.register<JavaExec>("runMainMethod") {
    group = "application"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("structra.assignment.task.impl.Example")
}

tasks.named("build") {
    finalizedBy("runMainMethod")
}

tasks.test {
    useJUnitPlatform()
}
