package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGpaDeviceGetClockInfoAMD} and {@link VkGpaDeviceGetClockInfoAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGpaDeviceGetClockInfoAMD
    extends IPointer
    permits VkGpaDeviceGetClockInfoAMD, VkGpaDeviceGetClockInfoAMD.Ptr
{}
