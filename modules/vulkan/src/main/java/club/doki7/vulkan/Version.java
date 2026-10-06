package club.doki7.vulkan;

import club.doki7.ffm.annotation.Unsigned;
import club.doki7.ffm.annotation.ValueBasedCandidate;

/// Utility class for encoding/decoding Vulkan API versions
///
/// @see <a href="https://docs.vulkan.org/guide/latest/versions.html">Vulkan versions</a>
@ValueBasedCandidate
public record Version(
    @Unsigned int variant,
    @Unsigned int major,
    @Unsigned int minor,
    @Unsigned int patch
) {
    public static final Version VK_API_VERSION_1_0 = new Version(0, 1, 0, 0);
    public static final Version VK_API_VERSION_1_1 = new Version(0, 1, 1, 0);
    public static final Version VK_API_VERSION_1_2 = new Version(0, 1, 2, 0);
    public static final Version VK_API_VERSION_1_3 = new Version(0, 1, 3, 0);
    public static final Version VK_API_VERSION_1_4 = new Version(0, 1, 4, 0);

    public static Version decode(@Unsigned int version) {
        return new Version(
            (version >> 29) & 0x7,
            (version >> 22) & 0x7F,
            (version >> 12) & 0x3FF,
            version & 0xFFF
        );
    }

    public @Unsigned int encode() {
        return (variant << 29) | (major << 22) | (minor << 12) | patch;
    }
}
