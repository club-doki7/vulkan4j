package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDispatchGraphCountInfoAMDX} and {@link VkDispatchGraphCountInfoAMDX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDispatchGraphCountInfoAMDX
    extends IPointer
    permits VkDispatchGraphCountInfoAMDX, VkDispatchGraphCountInfoAMDX.Ptr
{}
