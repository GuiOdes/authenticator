import io.gitlab.arturbosch.detekt.Detekt

plugins {
	kotlin("jvm") version "2.0.10"
	kotlin("plugin.spring") version "2.0.10"
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
	id("io.gitlab.arturbosch.detekt") version "1.23.7"
}

group = "com.guiodes"
version = "0.0.1-SNAPSHOT"

val detektVersion = "1.23.7"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Spring Boot
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-mail")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Jackson
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// Kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// Testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testImplementation("io.mockk:mockk:1.13.3")
	testImplementation("com.ninja-squad:springmockk:4.0.0")

	// Database
	runtimeOnly("org.postgresql:postgresql")
	implementation("org.flywaydb:flyway-core:11.0.1")
	runtimeOnly("org.flywaydb:flyway-database-postgresql:11.0.1")

	// Testcontainers
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:postgresql")

	// Detekt
	detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:$detektVersion")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

detekt {
	toolVersion = "1.23.7"
	config.setFrom("config/detekt.yml")
}

tasks.withType<Detekt>().configureEach {
	reports {
		xml.required.set(false)
		html.required.set(false)
		txt.required.set(false)
		sarif.required.set(false)
	}
	autoCorrect = true
}

tasks.withType<Test> {
	useJUnitPlatform()
}
