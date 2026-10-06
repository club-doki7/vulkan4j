package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCooperativeVectorPropertiesNV} and {@link VkCooperativeVectorPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCooperativeVectorPropertiesNV
    extends IPointer
    permits VkCooperativeVectorPropertiesNV, VkCooperativeVectorPropertiesNV.Ptr
{}
