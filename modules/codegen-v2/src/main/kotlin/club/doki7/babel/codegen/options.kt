package club.doki7.babel.codegen

import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.IRegistry

data class CodegenOptions(
    val packageName: String,
    val extraImport: List<String>,
    val constantClassName: String,
    val functionTypeClassName: String,

    val refRegistries: List<IRegistry>,

    val seeLinkProvider: Function1<Entity, String?> = ::dummyLinkProvider
)

private fun dummyLinkProvider(@Suppress("unused") ignoredEntity: Entity): String? = null
