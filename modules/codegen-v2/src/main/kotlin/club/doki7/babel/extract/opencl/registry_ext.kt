package club.doki7.babel.extract.opencl

import club.doki7.sennaar.Identifier
import kotlinx.serialization.Serializable

@Serializable
data class OpenCLRequire(
    var types: List<String>,
    var enums: List<Identifier>,
    var commands: List<Identifier>,
    var headers: List<String>
)

@Serializable
data class OpenCLVersion(
    var name: String,
    var number: Float,
    var require: List<OpenCLRequire>
)

@Serializable
data class OpenCLExtension(
    var name: String,
    var supported: String,
    var revision: String,
    var experimental: Boolean,
    var depends: String?,
    var ratified: String?,
    var promotedTo: String?,
    var obsoletedBy: String?,
    var condition: String?,
    var requires: List<OpenCLRequire>
)

@Serializable
data class OpenCLRegistryExt(
    var versions: Map<Identifier, OpenCLVersion>,
    var extensions: Map<Identifier, OpenCLExtension>
)
