package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH264MemMgmtControlOp {
    public static final int STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_END = 0x0;
    public static final int STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_UNMARK_SHORT_TERM = 0x1;
    public static final int STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_UNMARK_LONG_TERM = 0x2;
    public static final int STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_MARK_LONG_TERM = 0x3;
    public static final int STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_SET_MAX_LONG_TERM_INDEX = 0x4;
    public static final int STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_UNMARK_ALL = 0x5;
    public static final int STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_MARK_CURRENT_AS_LONG_TERM = 0x6;
    public static final int STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH264MemMgmtControlOp.class) int value) {
        return switch (value) {
            case StdVideoH264MemMgmtControlOp.STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_END -> "STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_END";
            case StdVideoH264MemMgmtControlOp.STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_INVALID -> "STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_INVALID";
            case StdVideoH264MemMgmtControlOp.STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_MARK_CURRENT_AS_LONG_TERM -> "STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_MARK_CURRENT_AS_LONG_TERM";
            case StdVideoH264MemMgmtControlOp.STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_MARK_LONG_TERM -> "STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_MARK_LONG_TERM";
            case StdVideoH264MemMgmtControlOp.STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_SET_MAX_LONG_TERM_INDEX -> "STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_SET_MAX_LONG_TERM_INDEX";
            case StdVideoH264MemMgmtControlOp.STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_UNMARK_ALL -> "STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_UNMARK_ALL";
            case StdVideoH264MemMgmtControlOp.STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_UNMARK_LONG_TERM -> "STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_UNMARK_LONG_TERM";
            case StdVideoH264MemMgmtControlOp.STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_UNMARK_SHORT_TERM -> "STD_VIDEO_H264_MEM_MGMT_CONTROL_OP_UNMARK_SHORT_TERM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH264MemMgmtControlOp() {}
}
