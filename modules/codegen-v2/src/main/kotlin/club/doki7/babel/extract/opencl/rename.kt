package club.doki7.babel.extract.opencl

import club.doki7.babel.extract.ensureLowerCamelCase
import club.doki7.babel.registry.Entity
import club.doki7.babel.registry.IMergeable
import club.doki7.babel.registry.Registry

internal fun <T : IMergeable<T>> Registry<T>.renameEntities() {
    val renamed = mutableMapOf<String, String>()

    fun putEntityIfNameReplaced(entity: Entity) {
        if (entity.name.original != entity.name.value) {
            renamed.putIfAbsent(entity.name.original, entity.name.value)
        }
    }

    commands.values.forEach {
        it.rename { removePrefix("cl").ensureLowerCamelCase() }
        putEntityIfNameReplaced(it)
    }

    constants.values.forEach {
        it.rename { removePrefix("CL_") }
    }

    // Since OpenCL uses snake case, we have to rename structures

    structures.values.forEach { struct ->
        struct.rename { renameSnakeCase(true) }
        putEntityIfNameReplaced(struct)

        struct.members.forEach { member ->
            member.rename { renameSnakeCase(false) }
            putEntityIfNameReplaced(member)
        }
    }

    opaqueHandleTypedefs.values.forEach {
        it.rename { renameSnakeCase(true) }
        putEntityIfNameReplaced(it)
    }

    opaqueTypedefs.values.forEach {
        it.rename { renameSnakeCase(true) }
        putEntityIfNameReplaced(it)
    }

    unions.values.forEach {
        it.rename { renameSnakeCase(true) }
        putEntityIfNameReplaced(it)
    }

    functionTypedefs.values.forEach {
        it.rename {
            val realName = if (startsWith("pfn_")) {
                substring(4)
            } else this
            "PFN_" + realName.renameSnakeCase(true)
        }

        putEntityIfNameReplaced(it)
    }
}

private fun String.renameSnakeCase(upperCaml: Boolean): String {
    val parts = split('_')
    assert(parts.isNotEmpty())

    return parts.joinToString(separator = "") {
        it[0].uppercaseChar() + it.substring(1)
    }.let { if (upperCaml) it else it.ensureLowerCamelCase() }
}