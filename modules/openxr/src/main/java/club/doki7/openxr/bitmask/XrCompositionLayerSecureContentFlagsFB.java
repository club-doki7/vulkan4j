package club.doki7.openxr.bitmask;

import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrCompositionLayerSecureContentFlagsFB.html"><code>XrCompositionLayerSecureContentFlagsFB</code></a>
public final class XrCompositionLayerSecureContentFlagsFB {
    public static final long EXCLUDE_LAYER = 0x1L;
    public static final long REPLACE_LAYER = 0x2L;

    public static String explain(@Bitmask(XrCompositionLayerSecureContentFlagsFB.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & EXCLUDE_LAYER) != 0) {
            detectedFlagBits.add("XR_COMPOSITION_LAYER_SECURE_CONTENT_EXCLUDE_LAYER_BIT_FB");
        }
        if ((flags & REPLACE_LAYER) != 0) {
            detectedFlagBits.add("XR_COMPOSITION_LAYER_SECURE_CONTENT_REPLACE_LAYER_BIT_FB");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private XrCompositionLayerSecureContentFlagsFB() {}
}
