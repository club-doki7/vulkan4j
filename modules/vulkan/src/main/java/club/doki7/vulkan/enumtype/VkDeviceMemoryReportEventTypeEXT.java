package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceMemoryReportEventTypeEXT.html"><code>VkDeviceMemoryReportEventTypeEXT</code></a>
public final class VkDeviceMemoryReportEventTypeEXT {
    public static final int ALLOCATE = 0x0;
    public static final int FREE = 0x1;
    public static final int IMPORT = 0x2;
    public static final int UNIMPORT = 0x3;
    public static final int ALLOCATION_FAILED = 0x4;

    public static String explain(@EnumType(VkDeviceMemoryReportEventTypeEXT.class) int value) {
        return switch (value) {
            case VkDeviceMemoryReportEventTypeEXT.ALLOCATE -> "VK_DEVICE_MEMORY_REPORT_EVENT_TYPE_ALLOCATE_EXT";
            case VkDeviceMemoryReportEventTypeEXT.ALLOCATION_FAILED -> "VK_DEVICE_MEMORY_REPORT_EVENT_TYPE_ALLOCATION_FAILED_EXT";
            case VkDeviceMemoryReportEventTypeEXT.FREE -> "VK_DEVICE_MEMORY_REPORT_EVENT_TYPE_FREE_EXT";
            case VkDeviceMemoryReportEventTypeEXT.IMPORT -> "VK_DEVICE_MEMORY_REPORT_EVENT_TYPE_IMPORT_EXT";
            case VkDeviceMemoryReportEventTypeEXT.UNIMPORT -> "VK_DEVICE_MEMORY_REPORT_EVENT_TYPE_UNIMPORT_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDeviceMemoryReportEventTypeEXT() {}
}
