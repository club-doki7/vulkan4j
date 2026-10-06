package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoSessionParametersUpdateInfoKHR} and {@link VkVideoSessionParametersUpdateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoSessionParametersUpdateInfoKHR
    extends IPointer
    permits VkVideoSessionParametersUpdateInfoKHR, VkVideoSessionParametersUpdateInfoKHR.Ptr
{}
