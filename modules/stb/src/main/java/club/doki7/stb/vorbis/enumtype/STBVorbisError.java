package club.doki7.stb.vorbis.enumtype;

import club.doki7.ffm.annotation.*;

public final class STBVorbisError {
    public static final int _NO_ERROR = 0x0;
    public static final int NEED_MORE_DATA = 0x1;
    public static final int INVALID_API_MIXING = 0x2;
    public static final int OUTOFMEM = 0x3;
    public static final int FEATURE_NOT_SUPPORTED = 0x4;
    public static final int TOO_MANY_CHANNELS = 0x5;
    public static final int FILE_OPEN_FAILURE = 0x6;
    public static final int SEEK_WITHOUT_LENGTH = 0x7;
    public static final int UNEXPECTED_EOF = 0xa;
    public static final int SEEK_INVALID = 0xb;
    public static final int INVALID_SETUP = 0x14;
    public static final int INVALID_STREAM = 0x15;
    public static final int MISSING_CAPTURE_PATTERN = 0x1e;
    public static final int INVALID_STREAM_STRUCTURE_VERSION = 0x1f;
    public static final int CONTINUED_PACKET_FLAG_INVALID = 0x20;
    public static final int INCORRECT_STREAM_SERIAL_NUMBER = 0x21;
    public static final int INVALID_FIRST_PAGE = 0x22;
    public static final int BAD_PACKET_TYPE = 0x23;
    public static final int CANT_FIND_LAST_PAGE = 0x24;
    public static final int SEEK_FAILED = 0x25;
    public static final int OGG_SKELETON_NOT_SUPPORTED = 0x26;

    public static String explain(@EnumType(STBVorbisError.class) int value) {
        return switch (value) {
            case STBVorbisError._NO_ERROR -> "VORBIS__no_error";
            case STBVorbisError.BAD_PACKET_TYPE -> "VORBIS_bad_packet_type";
            case STBVorbisError.CANT_FIND_LAST_PAGE -> "VORBIS_cant_find_last_page";
            case STBVorbisError.CONTINUED_PACKET_FLAG_INVALID -> "VORBIS_continued_packet_flag_invalid";
            case STBVorbisError.FEATURE_NOT_SUPPORTED -> "VORBIS_feature_not_supported";
            case STBVorbisError.FILE_OPEN_FAILURE -> "VORBIS_file_open_failure";
            case STBVorbisError.INCORRECT_STREAM_SERIAL_NUMBER -> "VORBIS_incorrect_stream_serial_number";
            case STBVorbisError.INVALID_API_MIXING -> "VORBIS_invalid_api_mixing";
            case STBVorbisError.INVALID_FIRST_PAGE -> "VORBIS_invalid_first_page";
            case STBVorbisError.INVALID_SETUP -> "VORBIS_invalid_setup";
            case STBVorbisError.INVALID_STREAM -> "VORBIS_invalid_stream";
            case STBVorbisError.INVALID_STREAM_STRUCTURE_VERSION -> "VORBIS_invalid_stream_structure_version";
            case STBVorbisError.MISSING_CAPTURE_PATTERN -> "VORBIS_missing_capture_pattern";
            case STBVorbisError.NEED_MORE_DATA -> "VORBIS_need_more_data";
            case STBVorbisError.OGG_SKELETON_NOT_SUPPORTED -> "VORBIS_ogg_skeleton_not_supported";
            case STBVorbisError.OUTOFMEM -> "VORBIS_outofmem";
            case STBVorbisError.SEEK_FAILED -> "VORBIS_seek_failed";
            case STBVorbisError.SEEK_INVALID -> "VORBIS_seek_invalid";
            case STBVorbisError.SEEK_WITHOUT_LENGTH -> "VORBIS_seek_without_length";
            case STBVorbisError.TOO_MANY_CHANNELS -> "VORBIS_too_many_channels";
            case STBVorbisError.UNEXPECTED_EOF -> "VORBIS_unexpected_eof";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private STBVorbisError() {}
}
