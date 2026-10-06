package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link NvSciSyncFenceVKREF} and {@link NvSciSyncFenceVKREF.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface INvSciSyncFenceVKREF
    extends IPointer
    permits NvSciSyncFenceVKREF, NvSciSyncFenceVKREF.Ptr
{}
