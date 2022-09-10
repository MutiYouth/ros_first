plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    id("org.jetbrains.intellij") version "1.7.0"
}

group = "com.weng"
version = "0.3.0" // -SNAPSHOT

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.testng:testng:6.8.5")
}


// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    // 用来测试的IDEA的版本
    version.set("2021.3")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    patchPluginXml {
        sinceBuild.set("212.*")
        untilBuild.set("223.*")
        // 以plugin.xml中设置的 changeNotes为优先级最高。  9.6
        /*changeNotes.set("""
            hello test.
            <p>
                <b>0.2.0</b>
                <ul>
                    <li>as so.</li>
                </ul>
            </p>
            <p>
                <b>0.1.0</b>
                <ul>
                    <li>xxxx</li>
                </ul>
            </p>
            
        """.trimIndent())*/
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
