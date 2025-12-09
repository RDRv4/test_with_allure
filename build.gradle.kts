plugins {
    id("java")
    id("io.qameta.allure") version "3.0.1"

}

group = "org.example"
version = "1.0-SNAPSHOT"

allure {
    report {
        version.set("2.19.0")
    }
    adapter { // ответчат за появление папки allure-res
        aspectjWeaver.set(true) // обработка аннотации @Step
        frameworks {
            junit5 { //название фреймворка
                adapterVersion.set("2.19.0")
            }
        }
    }
}



repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("com.codeborne:selenide:7.11.1")
    implementation("io.qameta.allure:allure-selenide:2.29.0")
}

tasks.test {
    useJUnitPlatform()
}