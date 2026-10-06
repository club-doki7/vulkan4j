package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLayeredDriverUnderlyingApiMSFT.html"><code>VkLayeredDriverUnderlyingApiMSFT</code></a>
public final class VkLayeredDriverUnderlyingApiMSFT {
    public static final int NONE = 0x0;
    public static final int D3D12 = 0x1;

    public static String explain(@EnumType(VkLayeredDriverUnderlyingApiMSFT.class) int value) {
        return switch (value) {
            case VkLayeredDriverUnderlyingApiMSFT.D3D12 -> "VK_LAYERED_DRIVER_UNDERLYING_API_D3D12_MSFT";
            case VkLayeredDriverUnderlyingApiMSFT.NONE -> "VK_LAYERED_DRIVER_UNDERLYING_API_NONE_MSFT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkLayeredDriverUnderlyingApiMSFT() {}
}
