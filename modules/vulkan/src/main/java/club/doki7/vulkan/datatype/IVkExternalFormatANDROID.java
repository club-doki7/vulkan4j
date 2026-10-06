package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalFormatANDROID} and {@link VkExternalFormatANDROID.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalFormatANDROID
    extends IPointer
    permits VkExternalFormatANDROID, VkExternalFormatANDROID.Ptr
{}
