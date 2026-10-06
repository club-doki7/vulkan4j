package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkShaderModuleIdentifierEXT} and {@link VkShaderModuleIdentifierEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkShaderModuleIdentifierEXT
    extends IPointer
    permits VkShaderModuleIdentifierEXT, VkShaderModuleIdentifierEXT.Ptr
{}
