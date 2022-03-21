plugins {
    id("com.github.johnrengelman.shadow") version "7.1.1"
    id("io.micronaut.application") version "3.2.2"
    id("com.google.cloud.tools.jib") version "2.8.0"
}

version = "0.1"
group = "com.sample"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("io.micronaut:micronaut-http-validation")
    annotationProcessor("io.micronaut.data:micronaut-data-processor")
    annotationProcessor("io.micronaut.openapi:micronaut-openapi")
    annotationProcessor("io.micronaut.security:micronaut-security-annotations")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut:micronaut-management")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("io.micronaut.kubernetes:micronaut-kubernetes-discovery-client")
    implementation("io.micronaut.liquibase:micronaut-liquibase")
    implementation("io.micronaut.micrometer:micronaut-micrometer-core")
    implementation("io.micronaut.micrometer:micronaut-micrometer-registry-prometheus")
    implementation("io.micronaut.security:micronaut-security")
    implementation("io.micronaut.security:micronaut-security-jwt")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.swagger.core.v3:swagger-annotations")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.apache.logging.log4j:log4j-core:2.17.1")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.apache.logging.log4j:log4j-api:2.17.1")
    runtimeOnly("org.apache.logging.log4j:log4j-slf4j-impl:2.17.1")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
    testImplementation("org.testcontainers:testcontainers")
    implementation("io.micronaut:micronaut-validation")

    testImplementation("org.hamcrest:hamcrest")

    testImplementation("org.mockito:mockito-core")

}


application {
    mainClass.set("com.sample.Application")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

tasks {
    jib {
        to {
            image = "gcr.io/myapp/jib-image"
        }
    }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.sample.*")
    }
}


