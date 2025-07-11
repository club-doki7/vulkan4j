package club.doki7.stb.vorbis.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link STB_VorbisAlloc} and {@link STB_VorbisAlloc.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ISTB_VorbisAlloc
    extends IPointer
    permits STB_VorbisAlloc, STB_VorbisAlloc.Ptr
{}
