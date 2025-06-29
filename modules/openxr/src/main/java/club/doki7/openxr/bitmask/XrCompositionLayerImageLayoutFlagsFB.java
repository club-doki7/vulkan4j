package club.doki7.openxr.bitmask;

import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrCompositionLayerImageLayoutFlagsFB.html"><code>XrCompositionLayerImageLayoutFlagsFB</code></a>
public final class XrCompositionLayerImageLayoutFlagsFB {
    public static final long VERTICAL_FLIP = 0x1L;

    public static String explain(@Bitmask(XrCompositionLayerImageLayoutFlagsFB.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & VERTICAL_FLIP) != 0) {
            detectedFlagBits.add("XR_COMPOSITION_LAYER_IMAGE_LAYOUT_VERTICAL_FLIP_BIT_FB");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private XrCompositionLayerImageLayoutFlagsFB() {}
}
