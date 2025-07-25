package club.doki7.openxr.bitmask;

import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrExternalCameraStatusFlagsOCULUS.html"><code>XrExternalCameraStatusFlagsOCULUS</code></a>
public final class XrExternalCameraStatusFlagsOCULUS {
    public static final long CALIBRATED = 0x8L;
    public static final long CALIBRATING = 0x2L;
    public static final long CALIBRATION_FAILED = 0x4L;
    public static final long CAPTURING = 0x10L;
    public static final long CONNECTED = 0x1L;

    public static String explain(@Bitmask(XrExternalCameraStatusFlagsOCULUS.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & CALIBRATED) != 0) {
            detectedFlagBits.add("XR_EXTERNAL_CAMERA_STATUS_CALIBRATED_BIT_OCULUS");
        }
        if ((flags & CALIBRATING) != 0) {
            detectedFlagBits.add("XR_EXTERNAL_CAMERA_STATUS_CALIBRATING_BIT_OCULUS");
        }
        if ((flags & CALIBRATION_FAILED) != 0) {
            detectedFlagBits.add("XR_EXTERNAL_CAMERA_STATUS_CALIBRATION_FAILED_BIT_OCULUS");
        }
        if ((flags & CAPTURING) != 0) {
            detectedFlagBits.add("XR_EXTERNAL_CAMERA_STATUS_CAPTURING_BIT_OCULUS");
        }
        if ((flags & CONNECTED) != 0) {
            detectedFlagBits.add("XR_EXTERNAL_CAMERA_STATUS_CONNECTED_BIT_OCULUS");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private XrExternalCameraStatusFlagsOCULUS() {}
}
