package club.doki7.babel.extract.openxr

import club.doki7.sennaar.registry.Bitflag
import club.doki7.sennaar.registry.Bitmask
import club.doki7.sennaar.registry.Constant
import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.EnumVariant
import club.doki7.sennaar.registry.Enumeration
import club.doki7.sennaar.Identifier
import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.interned
import club.doki7.sennaar.registry.putEntityIfAbsent
import club.doki7.babel.util.Either
import club.doki7.babel.util.parseDecOrHex
import java.io.File
import java.math.BigInteger

private const val extendingAddedEntitiesFile = "codegen-v2/output/xr-extending-added-entities.csv"

internal fun Registry<OpenXRRegistryExt>.extendEntities() {
    val addedEntities = HashMap<Entity, Identifier>()

    for (version in ext.versions.values) {
        for (require in version.require) {
            for (requireValue in require.values) {
                if (requireValue.extends != null) {
                    extendBitmask(requireValue, bitmasks, addedEntities)
                    extendEnum(requireValue, enumerations, addedEntities, null)
                }
            }
        }
    }

    for (extension in ext.extensions.values) {
        for (require in extension.requires) {
            for (requireValue in require.values) {
                if (requireValue.extends != null) {
                    extendBitmask(requireValue, bitmasks, addedEntities)
                    extendEnum(requireValue, enumerations, addedEntities, extension.number)
                } else {
                    extractConstant(requireValue, constants, addedEntities)
                }
            }
        }
    }

    log.info(" - 扩展完成，添加了 ${addedEntities.size} 个项目，完整列表可参见 $extendingAddedEntitiesFile")
    File(extendingAddedEntitiesFile).writeText(buildString {
        appendLine("name,addedTo")
        for ((key, value) in addedEntities) {
            appendLine("${key.name},$value")
        }
    })
}

private fun extendBitmask(
    requireValue: RequireValue,
    bitmasks: Map<Identifier, Bitmask>,
    addedEntities: MutableMap<Entity, Identifier>,
) {
    val bitmask = bitmasks[requireValue.extends!!.interned()]
    val bitpos = requireValue.bitpos
    if (bitmask != null && bitpos != null) {
        val value = BigInteger.ONE.shiftLeft(bitpos.toInt())
        val bitflag = Bitflag(name = requireValue.name, value = value)
        if (addedEntities.putIfAbsent(bitflag, bitmask.name) == null) {
            bitmask.bitflags.add(bitflag)
        }
    }
}

private fun extendEnum(
    requireValue: RequireValue,
    enums: Map<Identifier, Enumeration>,
    addedEntities: MutableMap<Entity, Identifier>,
    extNumber: Long?
) {
    val enum = enums[requireValue.extends!!.interned()]
    val value = getVariantValue(requireValue, extNumber)
    if (enum != null && value != null) {
        val variant = EnumVariant(name = requireValue.name, value = value)
        if (addedEntities.putIfAbsent(variant, enum.name) == null) {
            enum.variants.add(variant)
        }
    }
}

private fun getVariantValue(requireValue: RequireValue, extNumber: Long?): Either<Long, List<String>>? {
    if (requireValue.alias != null) {
        return Either.Right(listOf(requireValue.alias))
    }

    if (requireValue.value != null) {
        return try {
            Either.Left(requireValue.value.parseDecOrHex())
        } catch (_: NumberFormatException) {
            Either.Right(listOf(requireValue.value))
        }
    }

    // https://registry.khronos.org/OpenXR/specs/1.0/styleguide.html#_assigning_extension_token_values
    val number = requireValue.extNumber ?: extNumber ?: return null
    val offset = requireValue.offset ?: return null
    val value = 1_000_000_000L + (1_000 * (number - 1)) + offset
    return Either.Left(if (requireValue.negative) -value else value)
}

private fun extractConstant(
    requireValue: RequireValue,
    constants: MutableMap<Identifier, Constant>,
    addedEntities: MutableMap<Entity, Identifier>
) {
    if (requireValue.value == null) {
        return
    }

    val originalName = requireValue.name.original
    val value = requireValue.value

    if (originalName.endsWith("_SPEC_VERSION")) {
        return
    }

    if (addedEntities.putIfAbsent(requireValue, "Constants".interned()) != null) {
        return
    }

    val constant = if (originalName.endsWith("_EXTENSION_NAME")) {
        Constant(
            requireValue.name,
            IdentifierType("CONSTANTS_JavaString"),
            value
        )
    } else {
        Constant(
            requireValue.name,
            IdentifierType(when {
                originalName.startsWith("VK_MAX") || originalName.endsWith("SIZE") -> "size_t"
                value.contains("ULL") -> "uint64_t"
                value.contains("U") -> "uint32_t"
                else -> "int32_t"
            }),
            value
        )
    }
    constants.putEntityIfAbsent(constant)
}
