package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDriverId.html"><code>VkDriverId</code></a>
public final class VkDriverId {
    public static final int AMD_PROPRIETARY = 0x1;
    public static final int AMD_OPEN_SOURCE = 0x2;
    public static final int MESA_RADV = 0x3;
    public static final int NVIDIA_PROPRIETARY = 0x4;
    public static final int INTEL_PROPRIETARY_WINDOWS = 0x5;
    public static final int INTEL_OPEN_SOURCE_MESA = 0x6;
    public static final int IMAGINATION_PROPRIETARY = 0x7;
    public static final int QUALCOMM_PROPRIETARY = 0x8;
    public static final int ARM_PROPRIETARY = 0x9;
    public static final int GOOGLE_SWIFTSHADER = 0xa;
    public static final int GGP_PROPRIETARY = 0xb;
    public static final int BROADCOM_PROPRIETARY = 0xc;
    public static final int MESA_LLVMPIPE = 0xd;
    public static final int MOLTENVK = 0xe;
    public static final int COREAVI_PROPRIETARY = 0xf;
    public static final int JUICE_PROPRIETARY = 0x10;
    public static final int VERISILICON_PROPRIETARY = 0x11;
    public static final int MESA_TURNIP = 0x12;
    public static final int MESA_V3DV = 0x13;
    public static final int MESA_PANVK = 0x14;
    public static final int SAMSUNG_PROPRIETARY = 0x15;
    public static final int MESA_VENUS = 0x16;
    public static final int MESA_DOZEN = 0x17;
    public static final int MESA_NVK = 0x18;
    public static final int IMAGINATION_OPEN_SOURCE_MESA = 0x19;
    public static final int MESA_HONEYKRISP = 0x1a;
    public static final int VULKAN_SC_EMULATION_ON_VULKAN = 0x1b;
    public static final int MESA_KOSMICKRISP = 0x1c;
    public static final int MESA_GFXSTREAM = 0x1d;
    public static final int APE_SOFT = 0x1e;
    public static final int RESERVED_31 = 0x1f;
    public static final int APEX = 0x20;

    public static String explain(@EnumType(VkDriverId.class) int value) {
        return switch (value) {
            case VkDriverId.AMD_OPEN_SOURCE -> "VK_DRIVER_ID_AMD_OPEN_SOURCE";
            case VkDriverId.AMD_PROPRIETARY -> "VK_DRIVER_ID_AMD_PROPRIETARY";
            case VkDriverId.APEX -> "VK_DRIVER_ID_APEX";
            case VkDriverId.APE_SOFT -> "VK_DRIVER_ID_APE_SOFT";
            case VkDriverId.ARM_PROPRIETARY -> "VK_DRIVER_ID_ARM_PROPRIETARY";
            case VkDriverId.BROADCOM_PROPRIETARY -> "VK_DRIVER_ID_BROADCOM_PROPRIETARY";
            case VkDriverId.COREAVI_PROPRIETARY -> "VK_DRIVER_ID_COREAVI_PROPRIETARY";
            case VkDriverId.GGP_PROPRIETARY -> "VK_DRIVER_ID_GGP_PROPRIETARY";
            case VkDriverId.GOOGLE_SWIFTSHADER -> "VK_DRIVER_ID_GOOGLE_SWIFTSHADER";
            case VkDriverId.IMAGINATION_OPEN_SOURCE_MESA -> "VK_DRIVER_ID_IMAGINATION_OPEN_SOURCE_MESA";
            case VkDriverId.IMAGINATION_PROPRIETARY -> "VK_DRIVER_ID_IMAGINATION_PROPRIETARY";
            case VkDriverId.INTEL_OPEN_SOURCE_MESA -> "VK_DRIVER_ID_INTEL_OPEN_SOURCE_MESA";
            case VkDriverId.INTEL_PROPRIETARY_WINDOWS -> "VK_DRIVER_ID_INTEL_PROPRIETARY_WINDOWS";
            case VkDriverId.JUICE_PROPRIETARY -> "VK_DRIVER_ID_JUICE_PROPRIETARY";
            case VkDriverId.MESA_DOZEN -> "VK_DRIVER_ID_MESA_DOZEN";
            case VkDriverId.MESA_GFXSTREAM -> "VK_DRIVER_ID_MESA_GFXSTREAM";
            case VkDriverId.MESA_HONEYKRISP -> "VK_DRIVER_ID_MESA_HONEYKRISP";
            case VkDriverId.MESA_KOSMICKRISP -> "VK_DRIVER_ID_MESA_KOSMICKRISP";
            case VkDriverId.MESA_LLVMPIPE -> "VK_DRIVER_ID_MESA_LLVMPIPE";
            case VkDriverId.MESA_NVK -> "VK_DRIVER_ID_MESA_NVK";
            case VkDriverId.MESA_PANVK -> "VK_DRIVER_ID_MESA_PANVK";
            case VkDriverId.MESA_RADV -> "VK_DRIVER_ID_MESA_RADV";
            case VkDriverId.MESA_TURNIP -> "VK_DRIVER_ID_MESA_TURNIP";
            case VkDriverId.MESA_V3DV -> "VK_DRIVER_ID_MESA_V3DV";
            case VkDriverId.MESA_VENUS -> "VK_DRIVER_ID_MESA_VENUS";
            case VkDriverId.MOLTENVK -> "VK_DRIVER_ID_MOLTENVK";
            case VkDriverId.NVIDIA_PROPRIETARY -> "VK_DRIVER_ID_NVIDIA_PROPRIETARY";
            case VkDriverId.QUALCOMM_PROPRIETARY -> "VK_DRIVER_ID_QUALCOMM_PROPRIETARY";
            case VkDriverId.RESERVED_31 -> "VK_DRIVER_ID_RESERVED_31";
            case VkDriverId.SAMSUNG_PROPRIETARY -> "VK_DRIVER_ID_SAMSUNG_PROPRIETARY";
            case VkDriverId.VERISILICON_PROPRIETARY -> "VK_DRIVER_ID_VERISILICON_PROPRIETARY";
            case VkDriverId.VULKAN_SC_EMULATION_ON_VULKAN -> "VK_DRIVER_ID_VULKAN_SC_EMULATION_ON_VULKAN";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDriverId() {}
}
