package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalFenceHandleTypeFlags.html"><code>VkExternalFenceHandleTypeFlags</code></a>
public final class VkExternalFenceHandleTypeFlags {
    public static final int OPAQUE_FD = 0x1;
    public static final int OPAQUE_WIN32 = 0x2;
    public static final int OPAQUE_WIN32_KMT = 0x4;
    public static final int SCI_SYNC_FENCE_NV = 0x20;
    public static final int SCI_SYNC_OBJ_NV = 0x10;
    public static final int SYNC_FD = 0x8;

    public static String explain(@Bitmask(VkExternalFenceHandleTypeFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & OPAQUE_FD) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_FENCE_HANDLE_TYPE_OPAQUE_FD_BIT");
        }
        if ((flags & OPAQUE_WIN32) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_FENCE_HANDLE_TYPE_OPAQUE_WIN32_BIT");
        }
        if ((flags & OPAQUE_WIN32_KMT) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_FENCE_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT");
        }
        if ((flags & SCI_SYNC_FENCE_NV) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_FENCE_HANDLE_TYPE_SCI_SYNC_FENCE_BIT_NV");
        }
        if ((flags & SCI_SYNC_OBJ_NV) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_FENCE_HANDLE_TYPE_SCI_SYNC_OBJ_BIT_NV");
        }
        if ((flags & SYNC_FD) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_FENCE_HANDLE_TYPE_SYNC_FD_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkExternalFenceHandleTypeFlags() {}
}
