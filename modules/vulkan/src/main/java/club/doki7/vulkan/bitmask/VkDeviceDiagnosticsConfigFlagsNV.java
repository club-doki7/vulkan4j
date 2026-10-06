package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceDiagnosticsConfigFlagsNV.html"><code>VkDeviceDiagnosticsConfigFlagsNV</code></a>
public final class VkDeviceDiagnosticsConfigFlagsNV {
    public static final int ENABLE_AUTOMATIC_CHECKPOINTS = 0x4;
    public static final int ENABLE_RESOURCE_TRACKING = 0x2;
    public static final int ENABLE_SHADER_DEBUG_INFO = 0x1;
    public static final int ENABLE_SHADER_ERROR_REPORTING = 0x8;

    public static String explain(@Bitmask(VkDeviceDiagnosticsConfigFlagsNV.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ENABLE_AUTOMATIC_CHECKPOINTS) != 0) {
            detectedFlagBits.add("VK_DEVICE_DIAGNOSTICS_CONFIG_ENABLE_AUTOMATIC_CHECKPOINTS_BIT_NV");
        }
        if ((flags & ENABLE_RESOURCE_TRACKING) != 0) {
            detectedFlagBits.add("VK_DEVICE_DIAGNOSTICS_CONFIG_ENABLE_RESOURCE_TRACKING_BIT_NV");
        }
        if ((flags & ENABLE_SHADER_DEBUG_INFO) != 0) {
            detectedFlagBits.add("VK_DEVICE_DIAGNOSTICS_CONFIG_ENABLE_SHADER_DEBUG_INFO_BIT_NV");
        }
        if ((flags & ENABLE_SHADER_ERROR_REPORTING) != 0) {
            detectedFlagBits.add("VK_DEVICE_DIAGNOSTICS_CONFIG_ENABLE_SHADER_ERROR_REPORTING_BIT_NV");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDeviceDiagnosticsConfigFlagsNV() {}
}
