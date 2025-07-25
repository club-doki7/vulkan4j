package club.doki7.stb.truetype.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link STBTT_PackRange} and {@link STBTT_PackRange.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ISTBTT_PackRange
    extends IPointer
    permits STBTT_PackRange, STBTT_PackRange.Ptr
{}
