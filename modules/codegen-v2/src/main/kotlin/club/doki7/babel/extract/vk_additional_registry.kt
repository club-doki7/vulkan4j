package club.doki7.babel.extract

import club.doki7.babel.registry.EmptyMergeable
import club.doki7.babel.registry.FunctionTypedef
import club.doki7.babel.registry.Identifier
import club.doki7.babel.registry.IdentifierType
import club.doki7.babel.registry.Registry
import club.doki7.babel.registry.intern

fun vulkanAdditionalRegistry(): Registry<EmptyMergeable> {
    val additionalFunctionTypedefs = mutableMapOf<Identifier, FunctionTypedef>()

    fun pfn(s: String) {
        val name = s.intern()
        additionalFunctionTypedefs[name] = FunctionTypedef(
            name,
            emptyList(),
            IdentifierType("void".intern()),
            pfnNativeApi = true
        )
    }

    pfn("PFN_vkGetInstanceProcAddr")
    pfn("PFN_vkGetDeviceProcAddr")
    pfn("PFN_vkGetPhysicalDeviceProperties")
    pfn("PFN_vkGetPhysicalDeviceProperties2KHR")
    pfn("PFN_vkGetPhysicalDeviceMemoryProperties")
    pfn("PFN_vkAllocateMemory")
    pfn("PFN_vkFreeMemory")
    pfn("PFN_vkMapMemory")
    pfn("PFN_vkUnmapMemory")
    pfn("PFN_vkFlushMappedMemoryRanges")
    pfn("PFN_vkInvalidateMappedMemoryRanges")
    pfn("PFN_vkBindBufferMemory")
    pfn("PFN_vkBindImageMemory")
    pfn("PFN_vkGetBufferMemoryRequirements")
    pfn("PFN_vkGetImageMemoryRequirements")
    pfn("PFN_vkCreateBuffer")
    pfn("PFN_vkDestroyBuffer")
    pfn("PFN_vkCreateImage")
    pfn("PFN_vkDestroyImage")
    pfn("PFN_vkCmdCopyBuffer")
    pfn("PFN_vkGetBufferMemoryRequirements2KHR")
    pfn("PFN_vkGetImageMemoryRequirements2KHR")
    pfn("PFN_vkBindBufferMemory2KHR")
    pfn("PFN_vkBindImageMemory2KHR")
    pfn("PFN_vkGetPhysicalDeviceMemoryProperties2KHR")
    pfn("PFN_vkGetDeviceBufferMemoryRequirementsKHR")
    pfn("PFN_vkGetDeviceImageMemoryRequirementsKHR")
    pfn("PFN_vkGetMemoryWin32HandleKHR")

    return Registry(
        aliases = mutableMapOf(),
        bitmasks = mutableMapOf(),
        constants = mutableMapOf(),
        commands = mutableMapOf(),
        enumerations = mutableMapOf(),
        functionTypedefs = additionalFunctionTypedefs,
        opaqueHandleTypedefs = mutableMapOf(),
        opaqueTypedefs = mutableMapOf(),
        structures = mutableMapOf(),
        unions = mutableMapOf(),
        ext = EmptyMergeable()
    )
}
