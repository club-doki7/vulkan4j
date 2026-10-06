package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugReportObjectTypeEXT.html"><code>VkDebugReportObjectTypeEXT</code></a>
public final class VkDebugReportObjectTypeEXT {
    public static final int UNKNOWN = 0x0;
    public static final int INSTANCE = 0x1;
    public static final int PHYSICAL_DEVICE = 0x2;
    public static final int DEVICE = 0x3;
    public static final int QUEUE = 0x4;
    public static final int SEMAPHORE = 0x5;
    public static final int COMMAND_BUFFER = 0x6;
    public static final int FENCE = 0x7;
    public static final int DEVICE_MEMORY = 0x8;
    public static final int BUFFER = 0x9;
    public static final int IMAGE = 0xa;
    public static final int EVENT = 0xb;
    public static final int QUERY_POOL = 0xc;
    public static final int BUFFER_VIEW = 0xd;
    public static final int IMAGE_VIEW = 0xe;
    public static final int SHADER_MODULE = 0xf;
    public static final int PIPELINE_CACHE = 0x10;
    public static final int PIPELINE_LAYOUT = 0x11;
    public static final int RENDER_PASS = 0x12;
    public static final int PIPELINE = 0x13;
    public static final int DESCRIPTOR_SET_LAYOUT = 0x14;
    public static final int SAMPLER = 0x15;
    public static final int DESCRIPTOR_POOL = 0x16;
    public static final int DESCRIPTOR_SET = 0x17;
    public static final int FRAMEBUFFER = 0x18;
    public static final int COMMAND_POOL = 0x19;
    public static final int SURFACE_KHR = 0x1a;
    public static final int SWAPCHAIN_KHR = 0x1b;
    public static final int DEBUG_REPORT_CALLBACK_EXT = 0x1c;
    public static final int DISPLAY_KHR = 0x1d;
    public static final int DISPLAY_MODE_KHR = 0x1e;
    public static final int VALIDATION_CACHE_EXT = 0x21;
    public static final int SAMPLER_YCBCR_CONVERSION = 0x3b9d2b60;
    public static final int DESCRIPTOR_UPDATE_TEMPLATE = 0x3b9c1608;
    public static final int CU_MODULE_NVX = 0x3b9b3b48;
    public static final int CU_FUNCTION_NVX = 0x3b9b3b49;
    public static final int ACCELERATION_STRUCTURE_KHR = 0x3b9d13f0;
    public static final int ACCELERATION_STRUCTURE_NV = 0x3b9d4e88;
    public static final int CUDA_MODULE_NV = 0x3b9f7938;
    public static final int CUDA_FUNCTION_NV = 0x3b9f7939;
    public static final int BUFFER_COLLECTION_FUCHSIA = 0x3ba05fb0;

    public static String explain(@EnumType(VkDebugReportObjectTypeEXT.class) int value) {
        return switch (value) {
            case VkDebugReportObjectTypeEXT.ACCELERATION_STRUCTURE_KHR -> "VK_DEBUG_REPORT_OBJECT_TYPE_ACCELERATION_STRUCTURE_KHR_EXT";
            case VkDebugReportObjectTypeEXT.ACCELERATION_STRUCTURE_NV -> "VK_DEBUG_REPORT_OBJECT_TYPE_ACCELERATION_STRUCTURE_NV_EXT";
            case VkDebugReportObjectTypeEXT.BUFFER_COLLECTION_FUCHSIA -> "VK_DEBUG_REPORT_OBJECT_TYPE_BUFFER_COLLECTION_FUCHSIA_EXT";
            case VkDebugReportObjectTypeEXT.BUFFER -> "VK_DEBUG_REPORT_OBJECT_TYPE_BUFFER_EXT";
            case VkDebugReportObjectTypeEXT.BUFFER_VIEW -> "VK_DEBUG_REPORT_OBJECT_TYPE_BUFFER_VIEW_EXT";
            case VkDebugReportObjectTypeEXT.COMMAND_BUFFER -> "VK_DEBUG_REPORT_OBJECT_TYPE_COMMAND_BUFFER_EXT";
            case VkDebugReportObjectTypeEXT.COMMAND_POOL -> "VK_DEBUG_REPORT_OBJECT_TYPE_COMMAND_POOL_EXT";
            case VkDebugReportObjectTypeEXT.CUDA_FUNCTION_NV -> "VK_DEBUG_REPORT_OBJECT_TYPE_CUDA_FUNCTION_NV_EXT";
            case VkDebugReportObjectTypeEXT.CUDA_MODULE_NV -> "VK_DEBUG_REPORT_OBJECT_TYPE_CUDA_MODULE_NV_EXT";
            case VkDebugReportObjectTypeEXT.CU_FUNCTION_NVX -> "VK_DEBUG_REPORT_OBJECT_TYPE_CU_FUNCTION_NVX_EXT";
            case VkDebugReportObjectTypeEXT.CU_MODULE_NVX -> "VK_DEBUG_REPORT_OBJECT_TYPE_CU_MODULE_NVX_EXT";
            case VkDebugReportObjectTypeEXT.DEBUG_REPORT_CALLBACK_EXT -> "VK_DEBUG_REPORT_OBJECT_TYPE_DEBUG_REPORT_CALLBACK_EXT_EXT";
            case VkDebugReportObjectTypeEXT.DESCRIPTOR_POOL -> "VK_DEBUG_REPORT_OBJECT_TYPE_DESCRIPTOR_POOL_EXT";
            case VkDebugReportObjectTypeEXT.DESCRIPTOR_SET -> "VK_DEBUG_REPORT_OBJECT_TYPE_DESCRIPTOR_SET_EXT";
            case VkDebugReportObjectTypeEXT.DESCRIPTOR_SET_LAYOUT -> "VK_DEBUG_REPORT_OBJECT_TYPE_DESCRIPTOR_SET_LAYOUT_EXT";
            case VkDebugReportObjectTypeEXT.DESCRIPTOR_UPDATE_TEMPLATE -> "VK_DEBUG_REPORT_OBJECT_TYPE_DESCRIPTOR_UPDATE_TEMPLATE_EXT";
            case VkDebugReportObjectTypeEXT.DEVICE -> "VK_DEBUG_REPORT_OBJECT_TYPE_DEVICE_EXT";
            case VkDebugReportObjectTypeEXT.DEVICE_MEMORY -> "VK_DEBUG_REPORT_OBJECT_TYPE_DEVICE_MEMORY_EXT";
            case VkDebugReportObjectTypeEXT.DISPLAY_KHR -> "VK_DEBUG_REPORT_OBJECT_TYPE_DISPLAY_KHR_EXT";
            case VkDebugReportObjectTypeEXT.DISPLAY_MODE_KHR -> "VK_DEBUG_REPORT_OBJECT_TYPE_DISPLAY_MODE_KHR_EXT";
            case VkDebugReportObjectTypeEXT.EVENT -> "VK_DEBUG_REPORT_OBJECT_TYPE_EVENT_EXT";
            case VkDebugReportObjectTypeEXT.FENCE -> "VK_DEBUG_REPORT_OBJECT_TYPE_FENCE_EXT";
            case VkDebugReportObjectTypeEXT.FRAMEBUFFER -> "VK_DEBUG_REPORT_OBJECT_TYPE_FRAMEBUFFER_EXT";
            case VkDebugReportObjectTypeEXT.IMAGE -> "VK_DEBUG_REPORT_OBJECT_TYPE_IMAGE_EXT";
            case VkDebugReportObjectTypeEXT.IMAGE_VIEW -> "VK_DEBUG_REPORT_OBJECT_TYPE_IMAGE_VIEW_EXT";
            case VkDebugReportObjectTypeEXT.INSTANCE -> "VK_DEBUG_REPORT_OBJECT_TYPE_INSTANCE_EXT";
            case VkDebugReportObjectTypeEXT.PHYSICAL_DEVICE -> "VK_DEBUG_REPORT_OBJECT_TYPE_PHYSICAL_DEVICE_EXT";
            case VkDebugReportObjectTypeEXT.PIPELINE_CACHE -> "VK_DEBUG_REPORT_OBJECT_TYPE_PIPELINE_CACHE_EXT";
            case VkDebugReportObjectTypeEXT.PIPELINE -> "VK_DEBUG_REPORT_OBJECT_TYPE_PIPELINE_EXT";
            case VkDebugReportObjectTypeEXT.PIPELINE_LAYOUT -> "VK_DEBUG_REPORT_OBJECT_TYPE_PIPELINE_LAYOUT_EXT";
            case VkDebugReportObjectTypeEXT.QUERY_POOL -> "VK_DEBUG_REPORT_OBJECT_TYPE_QUERY_POOL_EXT";
            case VkDebugReportObjectTypeEXT.QUEUE -> "VK_DEBUG_REPORT_OBJECT_TYPE_QUEUE_EXT";
            case VkDebugReportObjectTypeEXT.RENDER_PASS -> "VK_DEBUG_REPORT_OBJECT_TYPE_RENDER_PASS_EXT";
            case VkDebugReportObjectTypeEXT.SAMPLER -> "VK_DEBUG_REPORT_OBJECT_TYPE_SAMPLER_EXT";
            case VkDebugReportObjectTypeEXT.SAMPLER_YCBCR_CONVERSION -> "VK_DEBUG_REPORT_OBJECT_TYPE_SAMPLER_YCBCR_CONVERSION_EXT";
            case VkDebugReportObjectTypeEXT.SEMAPHORE -> "VK_DEBUG_REPORT_OBJECT_TYPE_SEMAPHORE_EXT";
            case VkDebugReportObjectTypeEXT.SHADER_MODULE -> "VK_DEBUG_REPORT_OBJECT_TYPE_SHADER_MODULE_EXT";
            case VkDebugReportObjectTypeEXT.SURFACE_KHR -> "VK_DEBUG_REPORT_OBJECT_TYPE_SURFACE_KHR_EXT";
            case VkDebugReportObjectTypeEXT.SWAPCHAIN_KHR -> "VK_DEBUG_REPORT_OBJECT_TYPE_SWAPCHAIN_KHR_EXT";
            case VkDebugReportObjectTypeEXT.UNKNOWN -> "VK_DEBUG_REPORT_OBJECT_TYPE_UNKNOWN_EXT";
            case VkDebugReportObjectTypeEXT.VALIDATION_CACHE_EXT -> "VK_DEBUG_REPORT_OBJECT_TYPE_VALIDATION_CACHE_EXT_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDebugReportObjectTypeEXT() {}
}
