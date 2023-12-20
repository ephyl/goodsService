plugins {
    id("java")
}

group = "ru.ephyl"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-aop:3.2.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.1")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.5")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:3.1.2")

}

tasks.test {
    useJUnitPlatform()
}