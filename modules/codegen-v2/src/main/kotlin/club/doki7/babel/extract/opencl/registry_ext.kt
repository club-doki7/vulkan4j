package club.doki7.babel.extract.opencl

import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.IMergeable
import club.doki7.sennaar.Identifier

data class OpenCLRequire(
    val types: List<String>,
    val enums: List<Identifier>,
    val commands: List<Identifier>,
    val headers: List<String>
)

class OpenCLVersion(
    name: String,
    val number: Float,
    val require: List<OpenCLRequire>
) : Entity(name) {
    override fun toStringImpl(): String = """OpenXRVersion(name="$name", number=$number, require=$require"""
}

class OpenCLExtension(
    name: String,
    val supported: String,
    val revision: String,
    val experimental: Boolean,
    val depends: String?,
    val ratified: String?,
    val promotedTo: String?,
    val obsoletedBy: String?,
    val condition: String?,
    val requires: List<OpenCLRequire>
) : Entity(name) {
    override fun toStringImpl(): String = buildString {
        append("""OpenCLExtension(name="$name", supported="$supported", revision="$revision", experimental=$experimental""")

        depends?.let {
            append(", depends=\"$depends\"")
        }

        ratified?.let {
            append(", ratified=\"$ratified\"")
        }

        promotedTo?.let {
            append(", promotedTo=\"$promotedTo\"")
        }

        obsoletedBy?.let {
            append(", obsoletedBy=\"$obsoletedBy\"")
        }

        condition?.let {
            append(", condition=\"$condition\"")
        }

        append("requires=$requires")
    }

}

data class OpenCLRegistryExt(
    val versions: Map<Identifier, OpenCLVersion>,
    val extensions: Map<Identifier, OpenCLExtension>
) : IMergeable<OpenCLRegistryExt> {
    override fun merge(other: OpenCLRegistryExt): OpenCLRegistryExt {
        return OpenCLRegistryExt(
            versions + other.versions,
            extensions + other.extensions
        )
    }
}
