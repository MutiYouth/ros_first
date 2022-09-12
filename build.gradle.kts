import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun properties(key: String) = project.findProperty(key)?.toString() ?: ""
val env: MutableMap<String, String> = System.getenv()
val dir: String = projectDir.parentFile.absolutePath

plugins {
    // Java support
    id("java")
    // Kotlin support
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    // Gradle IntelliJ Plugin
    id("org.jetbrains.intellij") version "1.9.0"
}

group = properties("pluginGroup")
version = properties("pluginVersion")  // -SNAPSHOT

repositories {
    mavenCentral()
    maven {
        setUrl("https://jitpack.io")
    }
    maven {
        setUrl("https://maven.aliyun.com/nexus/content/groups/public/")
    }
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(properties("javaVersion")))
    }
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    pluginName.set(properties("pluginName"))
    version.set(properties("platformVersion"))  // "2021.3"
    type.set(properties("platformType"))  // type.set("IC") // Target IDE Platform
    // sandboxDir.set("${rootProject.rootDir}/" + properties("sandboxDir"))
    downloadSources.set(true)
    plugins.set(properties("platformPlugins").split(',').map(String::trim).filter(String::isNotEmpty))  // plugins.set(listOf(/* Plugin Dependencies */))
    // languagePlugins=com.intellij.zh:221.224
    env["languagePlugins"]?.let { plugins.add(it) }
}

tasks {
    runIde {
        systemProperties["idea.is.internal"] = true

        // Path to IDE distribution that will be used to run the IDE with the plugin.
        // ideDir.set(File("path to IDE-dependency"))
    }

    buildSearchableOptions {
        enabled = env["buildSearchableOptions.enabled"] == "true"
        jvmArgs("-Dintellij.searchableOptions.i18n.enabled=true")
    }

    jarSearchableOptions {
        include { it.name.contains(rootProject.name + "-" + properties("pluginVersion")) }
    }

    wrapper {
        gradleVersion = properties("gradleVersion")
        distributionType = Wrapper.DistributionType.ALL
    }

    properties("javaVersion").let {
        withType<JavaCompile> {
            sourceCompatibility = it
            targetCompatibility = it
            options.encoding = "UTF-8"
        }
        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = it
        }
    }

    // Set the JVM compatibility versions
    // withType<JavaCompile> {
    //     sourceCompatibility = "11"
    //     targetCompatibility = "11"
    // }

    patchPluginXml {
        sinceBuild.set("221.*")
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
