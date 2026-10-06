package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueryResultStatusKHR.html"><code>VkQueryResultStatusKHR</code></a>
public final class VkQueryResultStatusKHR {
    public static final int ERROR = 0xffffffff;
    public static final int NOT_READY = 0x0;
    public static final int COMPLETE = 0x1;
    public static final int INSUFFICIENT_BITSTREAM_BUFFER_RANGE = 0xc460a608;

    public static String explain(@EnumType(VkQueryResultStatusKHR.class) int value) {
        return switch (value) {
            case VkQueryResultStatusKHR.COMPLETE -> "VK_QUERY_RESULT_STATUS_COMPLETE_KHR";
            case VkQueryResultStatusKHR.ERROR -> "VK_QUERY_RESULT_STATUS_ERROR_KHR";
            case VkQueryResultStatusKHR.INSUFFICIENT_BITSTREAM_BUFFER_RANGE -> "VK_QUERY_RESULT_STATUS_INSUFFICIENT_BITSTREAM_BUFFER_RANGE_KHR";
            case VkQueryResultStatusKHR.NOT_READY -> "VK_QUERY_RESULT_STATUS_NOT_READY_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkQueryResultStatusKHR() {}
}
