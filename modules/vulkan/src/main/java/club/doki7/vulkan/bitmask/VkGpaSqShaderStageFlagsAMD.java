package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGpaSqShaderStageFlagsAMD.html"><code>VkGpaSqShaderStageFlagsAMD</code></a>
public final class VkGpaSqShaderStageFlagsAMD {
    public static final int CS = 0x40;
    public static final int ES = 0x8;
    public static final int GS = 0x4;
    public static final int HS = 0x10;
    public static final int LS = 0x20;
    public static final int PS = 0x1;
    public static final int VS = 0x2;

    public static String explain(@Bitmask(VkGpaSqShaderStageFlagsAMD.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & CS) != 0) {
            detectedFlagBits.add("VK_GPA_SQ_SHADER_STAGE_CS_BIT_AMD");
        }
        if ((flags & ES) != 0) {
            detectedFlagBits.add("VK_GPA_SQ_SHADER_STAGE_ES_BIT_AMD");
        }
        if ((flags & GS) != 0) {
            detectedFlagBits.add("VK_GPA_SQ_SHADER_STAGE_GS_BIT_AMD");
        }
        if ((flags & HS) != 0) {
            detectedFlagBits.add("VK_GPA_SQ_SHADER_STAGE_HS_BIT_AMD");
        }
        if ((flags & LS) != 0) {
            detectedFlagBits.add("VK_GPA_SQ_SHADER_STAGE_LS_BIT_AMD");
        }
        if ((flags & PS) != 0) {
            detectedFlagBits.add("VK_GPA_SQ_SHADER_STAGE_PS_BIT_AMD");
        }
        if ((flags & VS) != 0) {
            detectedFlagBits.add("VK_GPA_SQ_SHADER_STAGE_VS_BIT_AMD");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkGpaSqShaderStageFlagsAMD() {}
}
