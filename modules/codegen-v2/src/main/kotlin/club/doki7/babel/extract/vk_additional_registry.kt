package club.doki7.babel.extract

import club.doki7.sennaar.registry.FunctionTypedef
import club.doki7.sennaar.Identifier
import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.interned
import kotlinx.serialization.json.JsonNull

fun vulkanAdditionalRegistry(): Registry {
    val additionalFunctionTypedefs = mutableMapOf<Identifier, FunctionTypedef>()

    fun pfn(s: String) {
        val name = s.interned()
        additionalFunctionTypedefs[name] = FunctionTypedef(
            name,
            params = mutableListOf(),
            result = IdentifierType("void".interned()),
            isPointer = true,
            isNativeAPI = true
        )
    }

    pfn("PFN_vkGetInstanceProcAddr")
    pfn("PFN_vkGetDeviceProcAddr")
    pfn("PFN_vkGetPhysicalDeviceProperties")
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
        name = "vulkan-additional",
        imports = mutableSetOf(),
        aliases = mutableMapOf(),
        bitmasks = mutableMapOf(),
        constants = mutableMapOf(),
        commands = mutableMapOf(),
        enumerations = mutableMapOf(),
        functionTypedefs = additionalFunctionTypedefs,
        opaqueHandleTypedefs = mutableMapOf(),
        opaqueTypedefs = mutableMapOf(),
        structs = mutableMapOf(),
        unions = mutableMapOf(),
        ext = JsonNull
    )
}
