package club.doki7.babel.extract.opencl

import club.doki7.babel.extract.ensureLowerCamelCase
import club.doki7.babel.registry.Entity
import club.doki7.babel.registry.Registry

internal fun Registry<OpenCLRegistryExt>.renameEntities() {
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
        struct.rename(String::renameType)
        putEntityIfNameReplaced(struct)

        struct.members.forEach { member ->
            member.rename(String::renameVariable)
            putEntityIfNameReplaced(member)
        }
    }

    unions.values.forEach { union ->
        union.rename(String::renameType)
        putEntityIfNameReplaced(union)

        union.members.forEach { member ->
            member.rename(String::renameVariable)
            putEntityIfNameReplaced(member)
        }
    }

    opaqueHandleTypedefs.values.forEach {
        it.rename(String::renameType)
        putEntityIfNameReplaced(it)
    }

    opaqueTypedefs.values.forEach {
        it.rename(String::renameType)
        putEntityIfNameReplaced(it)
    }
}

private fun String.renameType(): String =
    "CL" + this.removePrefix("cl_").split("_").joinToString("") { it[0].uppercaseChar() + it.substring(1) }

private fun String.renameVariable(): String =
    this.split("_").joinToString("") { it[0].uppercaseChar() + it.substring(1) }.ensureLowerCamelCase()
