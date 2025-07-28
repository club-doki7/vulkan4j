package club.doki7.babel.extract.openxr

import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.IMergeable
import club.doki7.sennaar.Identifier

sealed interface XrMetadata

data class XrParamMetadata(val externsync: String?) : XrMetadata

data class XrStructMetadata(
    val structextends: String?,
    val parentstruct: String?,
    val protect: String?,
    val returnonly: Boolean,
    val mayalias: Boolean,
) : XrMetadata

data class Require(
    val comment: String?,
    val extend: String?,
    val types: List<String>,
    val values: List<RequireValue>,
    val commands: List<Identifier>,
    val interactionProfiles: List<String>,
    val extending: List<Extend>
)

data class Extend(
    val interactionProfilePath: String?,
    val components: List<Component>
) {
    data class Component(val subpath: String, val type: Identifier)
}

class RequireValue(
    name: String,
    val extends: String?,
    val value: String?,
    val bitpos: Long?,
    val offset: Long?,
    val negative: Boolean,
    val alias: String?,
    val extNumber: Long?
) : Entity(name) {
    override fun toStringImpl(): String = buildString {
        append("RequireValue(name=\"$name\"")

        extends?.let {
            append(", extends=\"$it\"")
        }

        value?.let {
            append(", value=\"$it\"")
        }

        bitpos?.let {
            append(", bitpos=$it")
        }

        offset?.let {
            append(", offset=$it")
        }

        append(", negative=$negative")

        alias?.let {
            append(", alias=\"$alias\"")
        }

        extNumber?.let {
            append(", extNumber=$it")
        }
    }
}

class OpenXRVersion(
    name: String,
    val number: Float,
    val require: List<Require>
) : Entity(name) {
    override fun toStringImpl(): String = """OpenXRVersion(name="$name", number=$number, require=$require"""
}

class OpenXRExtension(
    name: String,
    val number: Long,
    val type: String,
    val supported: String,
    val depends: String?,
    val provisional: Boolean,
    val ratified: String?,
    val promotedTo: Identifier?,
    val deprecatedBy: String?,
    val requires: List<Require>
) : Entity(name) {
    override fun toStringImpl(): String = buildString {
        append("OpenXRExtension(name=\"$name\", number=$number, type=\"$type\", supported=\"$supported\", provisional=$provisional")

        depends?.let {
            append(", depends=\"$depends\"")
        }

        ratified?.let {
            append(", ratified=\"$ratified\"")
        }

        promotedTo?.let {
            append(", promotedTo=$promotedTo")
        }

        deprecatedBy?.let {
            append(", deprecatedBy=\"$deprecatedBy\"")
        }

        append("requires=$requires")
    }
}

data class OpenXRRegistryExt(
    val versions: Map<Identifier, OpenXRVersion>,
    val extensions: Map<Identifier, OpenXRExtension>
) : IMergeable<OpenXRRegistryExt> {
    override fun merge(other: OpenXRRegistryExt): OpenXRRegistryExt {
        return OpenXRRegistryExt(
            versions + other.versions,
            extensions + other.extensions
        )
    }
}
