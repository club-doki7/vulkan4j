package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAmigoProfilingSubmitInfoSEC} and {@link VkAmigoProfilingSubmitInfoSEC.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAmigoProfilingSubmitInfoSEC
    extends IPointer
    permits VkAmigoProfilingSubmitInfoSEC, VkAmigoProfilingSubmitInfoSEC.Ptr
{}
