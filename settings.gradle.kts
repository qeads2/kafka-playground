plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "kafka-playground"
include("client-kafka")
findProject(":client-kafka")?.name = "client-kafka"
