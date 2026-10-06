package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeAV1DecoderModelInfo} and {@link StdVideoEncodeAV1DecoderModelInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeAV1DecoderModelInfo
    extends IPointer
    permits StdVideoEncodeAV1DecoderModelInfo, StdVideoEncodeAV1DecoderModelInfo.Ptr
{}
