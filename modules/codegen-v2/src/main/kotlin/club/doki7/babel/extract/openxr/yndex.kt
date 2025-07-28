package club.doki7.babel.extract.openxr

import club.doki7.sennaar.registry.Registry

fun extractOpenXRRegistry(): Registry<OpenXRRegistryExt> {
    val registry = extractRawOpenXRRegistry()
    registry.renameEntities()
    registry.addDependencies()
    registry.buildLookupAccel()
    return registry
}
