package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkApplicationParametersEXT} and {@link VkApplicationParametersEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkApplicationParametersEXT
    extends IPointer
    permits VkApplicationParametersEXT, VkApplicationParametersEXT.Ptr
{}
