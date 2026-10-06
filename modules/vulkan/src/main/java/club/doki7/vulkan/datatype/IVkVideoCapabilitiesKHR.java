package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoCapabilitiesKHR} and {@link VkVideoCapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoCapabilitiesKHR
    extends IPointer
    permits VkVideoCapabilitiesKHR, VkVideoCapabilitiesKHR.Ptr
{}
