plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "common_ground"
include("user-service")
include("discovery-server")
include("api-gateway")
include("config-server")
