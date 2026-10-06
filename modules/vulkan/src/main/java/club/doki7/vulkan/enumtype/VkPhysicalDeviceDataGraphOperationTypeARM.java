package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDataGraphOperationTypeARM.html"><code>VkPhysicalDeviceDataGraphOperationTypeARM</code></a>
public final class VkPhysicalDeviceDataGraphOperationTypeARM {
    public static final int SPIRV_EXTENDED_INSTRUCTION_SET = 0x0;
    public static final int NEURAL_MODEL_QCOM = 0x3ba46308;
    public static final int BUILTIN_MODEL_QCOM = 0x3ba46309;
    public static final int OPTICAL_FLOW = 0x3ba46ad8;

    public static String explain(@EnumType(VkPhysicalDeviceDataGraphOperationTypeARM.class) int value) {
        return switch (value) {
            case VkPhysicalDeviceDataGraphOperationTypeARM.BUILTIN_MODEL_QCOM -> "VK_PHYSICAL_DEVICE_DATA_GRAPH_OPERATION_TYPE_BUILTIN_MODEL_QCOM";
            case VkPhysicalDeviceDataGraphOperationTypeARM.NEURAL_MODEL_QCOM -> "VK_PHYSICAL_DEVICE_DATA_GRAPH_OPERATION_TYPE_NEURAL_MODEL_QCOM";
            case VkPhysicalDeviceDataGraphOperationTypeARM.OPTICAL_FLOW -> "VK_PHYSICAL_DEVICE_DATA_GRAPH_OPERATION_TYPE_OPTICAL_FLOW_ARM";
            case VkPhysicalDeviceDataGraphOperationTypeARM.SPIRV_EXTENDED_INSTRUCTION_SET -> "VK_PHYSICAL_DEVICE_DATA_GRAPH_OPERATION_TYPE_SPIRV_EXTENDED_INSTRUCTION_SET_ARM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPhysicalDeviceDataGraphOperationTypeARM() {}
}
