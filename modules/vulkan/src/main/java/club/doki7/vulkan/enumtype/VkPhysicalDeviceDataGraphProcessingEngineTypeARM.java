package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDataGraphProcessingEngineTypeARM.html"><code>VkPhysicalDeviceDataGraphProcessingEngineTypeARM</code></a>
public final class VkPhysicalDeviceDataGraphProcessingEngineTypeARM {
    public static final int DEFAULT = 0x0;
    public static final int NEURAL_QCOM = 0x3ba46308;
    public static final int COMPUTE_QCOM = 0x3ba46309;

    public static String explain(@EnumType(VkPhysicalDeviceDataGraphProcessingEngineTypeARM.class) int value) {
        return switch (value) {
            case VkPhysicalDeviceDataGraphProcessingEngineTypeARM.COMPUTE_QCOM -> "VK_PHYSICAL_DEVICE_DATA_GRAPH_PROCESSING_ENGINE_TYPE_COMPUTE_QCOM";
            case VkPhysicalDeviceDataGraphProcessingEngineTypeARM.DEFAULT -> "VK_PHYSICAL_DEVICE_DATA_GRAPH_PROCESSING_ENGINE_TYPE_DEFAULT_ARM";
            case VkPhysicalDeviceDataGraphProcessingEngineTypeARM.NEURAL_QCOM -> "VK_PHYSICAL_DEVICE_DATA_GRAPH_PROCESSING_ENGINE_TYPE_NEURAL_QCOM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPhysicalDeviceDataGraphProcessingEngineTypeARM() {}
}
