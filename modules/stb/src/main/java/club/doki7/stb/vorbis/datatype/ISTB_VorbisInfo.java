package club.doki7.stb.vorbis.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link STB_VorbisInfo} and {@link STB_VorbisInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ISTB_VorbisInfo
    extends IPointer
    permits STB_VorbisInfo, STB_VorbisInfo.Ptr
{}
