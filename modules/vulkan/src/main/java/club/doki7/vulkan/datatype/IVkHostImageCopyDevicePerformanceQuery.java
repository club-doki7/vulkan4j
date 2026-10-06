package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkHostImageCopyDevicePerformanceQuery} and {@link VkHostImageCopyDevicePerformanceQuery.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkHostImageCopyDevicePerformanceQuery
    extends IPointer
    permits VkHostImageCopyDevicePerformanceQuery, VkHostImageCopyDevicePerformanceQuery.Ptr
{}
