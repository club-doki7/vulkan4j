package club.doki7.stb.vorbis.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link STB_VorbisComment} and {@link STB_VorbisComment.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ISTB_VorbisComment
    extends IPointer
    permits STB_VorbisComment, STB_VorbisComment.Ptr
{}
