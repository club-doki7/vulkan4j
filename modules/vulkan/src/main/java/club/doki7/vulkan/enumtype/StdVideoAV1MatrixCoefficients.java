package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoAV1MatrixCoefficients {
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_IDENTITY = 0x0;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_709 = 0x1;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_UNSPECIFIED = 0x2;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_RESERVED_3 = 0x3;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_FCC = 0x4;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_470_B_G = 0x5;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_601 = 0x6;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_SMPTE_240 = 0x7;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_SMPTE_YCGCO = 0x8;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_2020_NCL = 0x9;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_2020_CL = 0xa;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_SMPTE_2085 = 0xb;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_CHROMAT_NCL = 0xc;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_CHROMAT_CL = 0xd;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_ICTCP = 0xe;
    public static final int STD_VIDEO_AV1_MATRIX_COEFFICIENTS_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoAV1MatrixCoefficients.class) int value) {
        return switch (value) {
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_2020_CL -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_2020_CL";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_2020_NCL -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_2020_NCL";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_470_B_G -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_470_B_G";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_601 -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_601";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_709 -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_BT_709";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_CHROMAT_CL -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_CHROMAT_CL";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_CHROMAT_NCL -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_CHROMAT_NCL";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_FCC -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_FCC";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_ICTCP -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_ICTCP";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_IDENTITY -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_IDENTITY";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_INVALID -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_INVALID";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_RESERVED_3 -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_RESERVED_3";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_SMPTE_2085 -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_SMPTE_2085";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_SMPTE_240 -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_SMPTE_240";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_SMPTE_YCGCO -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_SMPTE_YCGCO";
            case StdVideoAV1MatrixCoefficients.STD_VIDEO_AV1_MATRIX_COEFFICIENTS_UNSPECIFIED -> "STD_VIDEO_AV1_MATRIX_COEFFICIENTS_UNSPECIFIED";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoAV1MatrixCoefficients() {}
}
