package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeAV1ExtensionHeader} and {@link StdVideoEncodeAV1ExtensionHeader.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeAV1ExtensionHeader
    extends IPointer
    permits StdVideoEncodeAV1ExtensionHeader, StdVideoEncodeAV1ExtensionHeader.Ptr
{}
