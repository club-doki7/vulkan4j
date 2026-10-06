package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkValidationFlagsEXT} and {@link VkValidationFlagsEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkValidationFlagsEXT
    extends IPointer
    permits VkValidationFlagsEXT, VkValidationFlagsEXT.Ptr
{}
