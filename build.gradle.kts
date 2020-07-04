import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.1.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"

	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
	id ("org.jetbrains.kotlin.kapt") version "1.3.72"

	id ("com.diffplug.gradle.spotless") version "4.0.0"
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

group = "work.inabajun"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// bcrypt
	implementation ("at.favre.lib:bcrypt:0.9.0")

	// doma
	implementation("org.seasar.doma.boot:doma-spring-boot-starter:1.4.0")
	kapt("org.seasar.doma:doma:2.29.0")
	implementation("org.seasar.doma:doma:2.29.0")

	// mysql
	implementation("mysql:mysql-connector-java:8.0.20")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

val compileKotlin: KotlinCompile by tasks

kapt {
	arguments {
		arg("doma.resources.dir", compileKotlin.destinationDir)
	}
}

tasks.register("copyDomaResources",Sync::class){
	from("src/main/resources")
	into(compileKotlin.destinationDir)
	include("doma.compile.config")
	include("META-INF/**/*.sql")
	include("META-INF/**/*.script")
}

tasks.withType<KotlinCompile> {
	dependsOn(tasks.getByName("copyDomaResources"))
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

spotless {
	kotlin {
		ktlint("0.35.0")
	}
}