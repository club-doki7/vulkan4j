package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpticalFlowSessionBindingPointNV.html"><code>VkOpticalFlowSessionBindingPointNV</code></a>
public final class VkOpticalFlowSessionBindingPointNV {
    public static final int UNKNOWN = 0x0;
    public static final int INPUT = 0x1;
    public static final int REFERENCE = 0x2;
    public static final int HINT = 0x3;
    public static final int FLOW_VECTOR = 0x4;
    public static final int BACKWARD_FLOW_VECTOR = 0x5;
    public static final int COST = 0x6;
    public static final int BACKWARD_COST = 0x7;
    public static final int GLOBAL_FLOW = 0x8;

    public static String explain(@EnumType(VkOpticalFlowSessionBindingPointNV.class) int value) {
        return switch (value) {
            case VkOpticalFlowSessionBindingPointNV.BACKWARD_COST -> "VK_OPTICAL_FLOW_SESSION_BINDING_POINT_BACKWARD_COST_NV";
            case VkOpticalFlowSessionBindingPointNV.BACKWARD_FLOW_VECTOR -> "VK_OPTICAL_FLOW_SESSION_BINDING_POINT_BACKWARD_FLOW_VECTOR_NV";
            case VkOpticalFlowSessionBindingPointNV.COST -> "VK_OPTICAL_FLOW_SESSION_BINDING_POINT_COST_NV";
            case VkOpticalFlowSessionBindingPointNV.FLOW_VECTOR -> "VK_OPTICAL_FLOW_SESSION_BINDING_POINT_FLOW_VECTOR_NV";
            case VkOpticalFlowSessionBindingPointNV.GLOBAL_FLOW -> "VK_OPTICAL_FLOW_SESSION_BINDING_POINT_GLOBAL_FLOW_NV";
            case VkOpticalFlowSessionBindingPointNV.HINT -> "VK_OPTICAL_FLOW_SESSION_BINDING_POINT_HINT_NV";
            case VkOpticalFlowSessionBindingPointNV.INPUT -> "VK_OPTICAL_FLOW_SESSION_BINDING_POINT_INPUT_NV";
            case VkOpticalFlowSessionBindingPointNV.REFERENCE -> "VK_OPTICAL_FLOW_SESSION_BINDING_POINT_REFERENCE_NV";
            case VkOpticalFlowSessionBindingPointNV.UNKNOWN -> "VK_OPTICAL_FLOW_SESSION_BINDING_POINT_UNKNOWN_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkOpticalFlowSessionBindingPointNV() {}
}
