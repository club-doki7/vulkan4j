package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeSessionParametersGetInfoKHR} and {@link VkVideoEncodeSessionParametersGetInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeSessionParametersGetInfoKHR
    extends IPointer
    permits VkVideoEncodeSessionParametersGetInfoKHR, VkVideoEncodeSessionParametersGetInfoKHR.Ptr
{}
