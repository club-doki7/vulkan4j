package club.doki7.babel.codegen

import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.Registry

data class CodegenOptions(
    val packageName: String,
    val extraImport: List<String>,
    val constantClassName: String,
    val functionTypeClassName: String,

    val refRegistries: List<Registry>,

    val seeLinkProvider: Function1<Entity, String?> = ::dummyLinkProvider
)

private fun dummyLinkProvider(@Suppress("unused") ignoredEntity: Entity): String? = null
