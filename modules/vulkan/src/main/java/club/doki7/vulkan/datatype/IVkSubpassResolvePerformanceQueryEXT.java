package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubpassResolvePerformanceQueryEXT} and {@link VkSubpassResolvePerformanceQueryEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubpassResolvePerformanceQueryEXT
    extends IPointer
    permits VkSubpassResolvePerformanceQueryEXT, VkSubpassResolvePerformanceQueryEXT.Ptr
{}
