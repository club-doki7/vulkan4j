package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCompressedTriangleFormatAMDX.html"><code>VkCompressedTriangleFormatAMDX</code></a>
public final class VkCompressedTriangleFormatAMDX {
    public static final int DGF1 = 0x0;

    public static String explain(@EnumType(VkCompressedTriangleFormatAMDX.class) int value) {
        return switch (value) {
            case VkCompressedTriangleFormatAMDX.DGF1 -> "VK_COMPRESSED_TRIANGLE_FORMAT_DGF1_AMDX";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkCompressedTriangleFormatAMDX() {}
}
