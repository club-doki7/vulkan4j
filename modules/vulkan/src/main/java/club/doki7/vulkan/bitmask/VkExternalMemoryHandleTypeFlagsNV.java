package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalMemoryHandleTypeFlagsNV.html"><code>VkExternalMemoryHandleTypeFlagsNV</code></a>
public final class VkExternalMemoryHandleTypeFlagsNV {
    public static final int D3D11_IMAGE = 0x4;
    public static final int D3D11_IMAGE_KMT = 0x8;
    public static final int OPAQUE_WIN32 = 0x1;
    public static final int OPAQUE_WIN32_KMT = 0x2;

    public static String explain(@Bitmask(VkExternalMemoryHandleTypeFlagsNV.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & D3D11_IMAGE) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_IMAGE_BIT_NV");
        }
        if ((flags & D3D11_IMAGE_KMT) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_IMAGE_KMT_BIT_NV");
        }
        if ((flags & OPAQUE_WIN32) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT_NV");
        }
        if ((flags & OPAQUE_WIN32_KMT) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_NV");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkExternalMemoryHandleTypeFlagsNV() {}
}
