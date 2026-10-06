package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkComponentTypeKHR.html"><code>VkComponentTypeKHR</code></a>
public final class VkComponentTypeKHR {
    public static final int FLOAT16 = 0x0;
    public static final int FLOAT32 = 0x1;
    public static final int FLOAT64 = 0x2;
    public static final int SINT8 = 0x3;
    public static final int SINT16 = 0x4;
    public static final int SINT32 = 0x5;
    public static final int SINT64 = 0x6;
    public static final int UINT8 = 0x7;
    public static final int UINT16 = 0x8;
    public static final int UINT32 = 0x9;
    public static final int UINT64 = 0xa;
    public static final int BFLOAT16 = 0x3b9cf0c8;
    public static final int SINT8_PACKED_NV = 0x3ba247f8;
    public static final int UINT8_PACKED_NV = 0x3ba247f9;
    public static final int FLOAT8_E4M3_EXT = 0x3ba247fa;
    public static final int FLOAT8_E5M2_EXT = 0x3ba247fb;
    public static final int FLOAT6_E2M3_EXT = 0x3ba50b00;
    public static final int FLOAT6_E3M2_EXT = 0x3ba50b01;
    public static final int FLOAT4_E2M1_EXT = 0x3ba50b02;
    public static final int FLOAT8_UNSIGNED_E8M0_EXT = 0x3ba50b03;
    public static final int MXINT8_EXT = 0x3ba50b04;

    public static String explain(@EnumType(VkComponentTypeKHR.class) int value) {
        return switch (value) {
            case VkComponentTypeKHR.BFLOAT16 -> "VK_COMPONENT_TYPE_BFLOAT16_KHR";
            case VkComponentTypeKHR.FLOAT16 -> "VK_COMPONENT_TYPE_FLOAT16_KHR";
            case VkComponentTypeKHR.FLOAT32 -> "VK_COMPONENT_TYPE_FLOAT32_KHR";
            case VkComponentTypeKHR.FLOAT4_E2M1_EXT -> "VK_COMPONENT_TYPE_FLOAT4_E2M1_EXT";
            case VkComponentTypeKHR.FLOAT64 -> "VK_COMPONENT_TYPE_FLOAT64_KHR";
            case VkComponentTypeKHR.FLOAT6_E2M3_EXT -> "VK_COMPONENT_TYPE_FLOAT6_E2M3_EXT";
            case VkComponentTypeKHR.FLOAT6_E3M2_EXT -> "VK_COMPONENT_TYPE_FLOAT6_E3M2_EXT";
            case VkComponentTypeKHR.FLOAT8_E4M3_EXT -> "VK_COMPONENT_TYPE_FLOAT8_E4M3_EXT";
            case VkComponentTypeKHR.FLOAT8_E5M2_EXT -> "VK_COMPONENT_TYPE_FLOAT8_E5M2_EXT";
            case VkComponentTypeKHR.FLOAT8_UNSIGNED_E8M0_EXT -> "VK_COMPONENT_TYPE_FLOAT8_UNSIGNED_E8M0_EXT";
            case VkComponentTypeKHR.MXINT8_EXT -> "VK_COMPONENT_TYPE_MXINT8_EXT";
            case VkComponentTypeKHR.SINT16 -> "VK_COMPONENT_TYPE_SINT16_KHR";
            case VkComponentTypeKHR.SINT32 -> "VK_COMPONENT_TYPE_SINT32_KHR";
            case VkComponentTypeKHR.SINT64 -> "VK_COMPONENT_TYPE_SINT64_KHR";
            case VkComponentTypeKHR.SINT8 -> "VK_COMPONENT_TYPE_SINT8_KHR";
            case VkComponentTypeKHR.SINT8_PACKED_NV -> "VK_COMPONENT_TYPE_SINT8_PACKED_NV";
            case VkComponentTypeKHR.UINT16 -> "VK_COMPONENT_TYPE_UINT16_KHR";
            case VkComponentTypeKHR.UINT32 -> "VK_COMPONENT_TYPE_UINT32_KHR";
            case VkComponentTypeKHR.UINT64 -> "VK_COMPONENT_TYPE_UINT64_KHR";
            case VkComponentTypeKHR.UINT8 -> "VK_COMPONENT_TYPE_UINT8_KHR";
            case VkComponentTypeKHR.UINT8_PACKED_NV -> "VK_COMPONENT_TYPE_UINT8_PACKED_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkComponentTypeKHR() {}
}
