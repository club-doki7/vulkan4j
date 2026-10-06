package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkResult.html"><code>VkResult</code></a>
public final class VkResult {
    public static final int SUCCESS = 0x0;
    public static final int NOT_READY = 0x1;
    public static final int TIMEOUT = 0x2;
    public static final int EVENT_SET = 0x3;
    public static final int EVENT_RESET = 0x4;
    public static final int INCOMPLETE = 0x5;
    public static final int ERROR_OUT_OF_HOST_MEMORY = 0xffffffff;
    public static final int ERROR_OUT_OF_DEVICE_MEMORY = 0xfffffffe;
    public static final int ERROR_INITIALIZATION_FAILED = 0xfffffffd;
    public static final int ERROR_DEVICE_LOST = 0xfffffffc;
    public static final int ERROR_MEMORY_MAP_FAILED = 0xfffffffb;
    public static final int ERROR_LAYER_NOT_PRESENT = 0xfffffffa;
    public static final int ERROR_EXTENSION_NOT_PRESENT = 0xfffffff9;
    public static final int ERROR_FEATURE_NOT_PRESENT = 0xfffffff8;
    public static final int ERROR_INCOMPATIBLE_DRIVER = 0xfffffff7;
    public static final int ERROR_TOO_MANY_OBJECTS = 0xfffffff6;
    public static final int ERROR_FORMAT_NOT_SUPPORTED = 0xfffffff5;
    public static final int ERROR_FRAGMENTED_POOL = 0xfffffff4;
    public static final int ERROR_UNKNOWN = 0xfffffff3;
    public static final int ERROR_VALIDATION_FAILED = 0xc4650b07;
    public static final int ERROR_OUT_OF_POOL_MEMORY = 0xc4642878;
    public static final int ERROR_INVALID_EXTERNAL_HANDLE = 0xc4641cbd;
    public static final int ERROR_INVALID_OPAQUE_CAPTURE_ADDRESS = 0xc4614a18;
    public static final int ERROR_FRAGMENTATION = 0xc462c118;
    public static final int PIPELINE_COMPILE_REQUIRED = 0x3b9f5228;
    public static final int ERROR_NOT_PERMITTED = 0xc4628e4f;
    public static final int ERROR_SURFACE_LOST_KHR = 0xc4653600;
    public static final int ERROR_NATIVE_WINDOW_IN_USE_KHR = 0xc46535ff;
    public static final int SUBOPTIMAL_KHR = 0x3b9acdeb;
    public static final int ERROR_OUT_OF_DATE_KHR = 0xc4653214;
    public static final int ERROR_INCOMPATIBLE_DISPLAY_KHR = 0xc4652a47;
    public static final int ERROR_INVALID_SHADER_NV = 0xc4650720;
    public static final int ERROR_IMAGE_USAGE_NOT_SUPPORTED_KHR = 0xc464dc28;
    public static final int ERROR_VIDEO_PICTURE_LAYOUT_NOT_SUPPORTED_KHR = 0xc464dc27;
    public static final int ERROR_VIDEO_PROFILE_OPERATION_NOT_SUPPORTED_KHR = 0xc464dc26;
    public static final int ERROR_VIDEO_PROFILE_FORMAT_NOT_SUPPORTED_KHR = 0xc464dc25;
    public static final int ERROR_VIDEO_PROFILE_CODEC_NOT_SUPPORTED_KHR = 0xc464dc24;
    public static final int ERROR_VIDEO_STD_VERSION_NOT_SUPPORTED_KHR = 0xc464dc23;
    public static final int ERROR_INVALID_DRM_FORMAT_MODIFIER_PLANE_LAYOUT_EXT = 0xc462ccd0;
    public static final int ERROR_PRESENT_TIMING_QUEUE_FULL_EXT = 0xc4620980;
    public static final int ERROR_FULL_SCREEN_EXCLUSIVE_MODE_LOST_EXT = 0xc46151e8;
    public static final int THREAD_IDLE_KHR = 0x3b9ee0e0;
    public static final int THREAD_DONE_KHR = 0x3b9ee0e1;
    public static final int OPERATION_DEFERRED_KHR = 0x3b9ee0e2;
    public static final int OPERATION_NOT_DEFERRED_KHR = 0x3b9ee0e3;
    public static final int ERROR_INVALID_VIDEO_STD_PARAMETERS_KHR = 0xc460a608;
    public static final int ERROR_COMPRESSION_EXHAUSTED_EXT = 0xc4600db0;
    public static final int INCOMPATIBLE_SHADER_BINARY_EXT = 0x3ba224d0;
    public static final int PIPELINE_BINARY_MISSING_KHR = 0x3ba228b8;
    public static final int ERROR_NOT_ENOUGH_SPACE_KHR = 0xc45dd748;

    public static String explain(@EnumType(VkResult.class) int value) {
        return switch (value) {
            case VkResult.ERROR_COMPRESSION_EXHAUSTED_EXT -> "VK_ERROR_COMPRESSION_EXHAUSTED_EXT";
            case VkResult.ERROR_DEVICE_LOST -> "VK_ERROR_DEVICE_LOST";
            case VkResult.ERROR_EXTENSION_NOT_PRESENT -> "VK_ERROR_EXTENSION_NOT_PRESENT";
            case VkResult.ERROR_FEATURE_NOT_PRESENT -> "VK_ERROR_FEATURE_NOT_PRESENT";
            case VkResult.ERROR_FORMAT_NOT_SUPPORTED -> "VK_ERROR_FORMAT_NOT_SUPPORTED";
            case VkResult.ERROR_FRAGMENTATION -> "VK_ERROR_FRAGMENTATION";
            case VkResult.ERROR_FRAGMENTED_POOL -> "VK_ERROR_FRAGMENTED_POOL";
            case VkResult.ERROR_FULL_SCREEN_EXCLUSIVE_MODE_LOST_EXT -> "VK_ERROR_FULL_SCREEN_EXCLUSIVE_MODE_LOST_EXT";
            case VkResult.ERROR_IMAGE_USAGE_NOT_SUPPORTED_KHR -> "VK_ERROR_IMAGE_USAGE_NOT_SUPPORTED_KHR";
            case VkResult.ERROR_INCOMPATIBLE_DISPLAY_KHR -> "VK_ERROR_INCOMPATIBLE_DISPLAY_KHR";
            case VkResult.ERROR_INCOMPATIBLE_DRIVER -> "VK_ERROR_INCOMPATIBLE_DRIVER";
            case VkResult.ERROR_INITIALIZATION_FAILED -> "VK_ERROR_INITIALIZATION_FAILED";
            case VkResult.ERROR_INVALID_DRM_FORMAT_MODIFIER_PLANE_LAYOUT_EXT -> "VK_ERROR_INVALID_DRM_FORMAT_MODIFIER_PLANE_LAYOUT_EXT";
            case VkResult.ERROR_INVALID_EXTERNAL_HANDLE -> "VK_ERROR_INVALID_EXTERNAL_HANDLE";
            case VkResult.ERROR_INVALID_OPAQUE_CAPTURE_ADDRESS -> "VK_ERROR_INVALID_OPAQUE_CAPTURE_ADDRESS";
            case VkResult.ERROR_INVALID_SHADER_NV -> "VK_ERROR_INVALID_SHADER_NV";
            case VkResult.ERROR_INVALID_VIDEO_STD_PARAMETERS_KHR -> "VK_ERROR_INVALID_VIDEO_STD_PARAMETERS_KHR";
            case VkResult.ERROR_LAYER_NOT_PRESENT -> "VK_ERROR_LAYER_NOT_PRESENT";
            case VkResult.ERROR_MEMORY_MAP_FAILED -> "VK_ERROR_MEMORY_MAP_FAILED";
            case VkResult.ERROR_NATIVE_WINDOW_IN_USE_KHR -> "VK_ERROR_NATIVE_WINDOW_IN_USE_KHR";
            case VkResult.ERROR_NOT_ENOUGH_SPACE_KHR -> "VK_ERROR_NOT_ENOUGH_SPACE_KHR";
            case VkResult.ERROR_NOT_PERMITTED -> "VK_ERROR_NOT_PERMITTED";
            case VkResult.ERROR_OUT_OF_DATE_KHR -> "VK_ERROR_OUT_OF_DATE_KHR";
            case VkResult.ERROR_OUT_OF_DEVICE_MEMORY -> "VK_ERROR_OUT_OF_DEVICE_MEMORY";
            case VkResult.ERROR_OUT_OF_HOST_MEMORY -> "VK_ERROR_OUT_OF_HOST_MEMORY";
            case VkResult.ERROR_OUT_OF_POOL_MEMORY -> "VK_ERROR_OUT_OF_POOL_MEMORY";
            case VkResult.ERROR_PRESENT_TIMING_QUEUE_FULL_EXT -> "VK_ERROR_PRESENT_TIMING_QUEUE_FULL_EXT";
            case VkResult.ERROR_SURFACE_LOST_KHR -> "VK_ERROR_SURFACE_LOST_KHR";
            case VkResult.ERROR_TOO_MANY_OBJECTS -> "VK_ERROR_TOO_MANY_OBJECTS";
            case VkResult.ERROR_UNKNOWN -> "VK_ERROR_UNKNOWN";
            case VkResult.ERROR_VALIDATION_FAILED -> "VK_ERROR_VALIDATION_FAILED";
            case VkResult.ERROR_VIDEO_PICTURE_LAYOUT_NOT_SUPPORTED_KHR -> "VK_ERROR_VIDEO_PICTURE_LAYOUT_NOT_SUPPORTED_KHR";
            case VkResult.ERROR_VIDEO_PROFILE_CODEC_NOT_SUPPORTED_KHR -> "VK_ERROR_VIDEO_PROFILE_CODEC_NOT_SUPPORTED_KHR";
            case VkResult.ERROR_VIDEO_PROFILE_FORMAT_NOT_SUPPORTED_KHR -> "VK_ERROR_VIDEO_PROFILE_FORMAT_NOT_SUPPORTED_KHR";
            case VkResult.ERROR_VIDEO_PROFILE_OPERATION_NOT_SUPPORTED_KHR -> "VK_ERROR_VIDEO_PROFILE_OPERATION_NOT_SUPPORTED_KHR";
            case VkResult.ERROR_VIDEO_STD_VERSION_NOT_SUPPORTED_KHR -> "VK_ERROR_VIDEO_STD_VERSION_NOT_SUPPORTED_KHR";
            case VkResult.EVENT_RESET -> "VK_EVENT_RESET";
            case VkResult.EVENT_SET -> "VK_EVENT_SET";
            case VkResult.INCOMPATIBLE_SHADER_BINARY_EXT -> "VK_INCOMPATIBLE_SHADER_BINARY_EXT";
            case VkResult.INCOMPLETE -> "VK_INCOMPLETE";
            case VkResult.NOT_READY -> "VK_NOT_READY";
            case VkResult.OPERATION_DEFERRED_KHR -> "VK_OPERATION_DEFERRED_KHR";
            case VkResult.OPERATION_NOT_DEFERRED_KHR -> "VK_OPERATION_NOT_DEFERRED_KHR";
            case VkResult.PIPELINE_BINARY_MISSING_KHR -> "VK_PIPELINE_BINARY_MISSING_KHR";
            case VkResult.PIPELINE_COMPILE_REQUIRED -> "VK_PIPELINE_COMPILE_REQUIRED";
            case VkResult.SUBOPTIMAL_KHR -> "VK_SUBOPTIMAL_KHR";
            case VkResult.SUCCESS -> "VK_SUCCESS";
            case VkResult.THREAD_DONE_KHR -> "VK_THREAD_DONE_KHR";
            case VkResult.THREAD_IDLE_KHR -> "VK_THREAD_IDLE_KHR";
            case VkResult.TIMEOUT -> "VK_TIMEOUT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkResult() {}
}
