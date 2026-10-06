package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDispatchGraphInfoAMDX} and {@link VkDispatchGraphInfoAMDX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDispatchGraphInfoAMDX
    extends IPointer
    permits VkDispatchGraphInfoAMDX, VkDispatchGraphInfoAMDX.Ptr
{}
