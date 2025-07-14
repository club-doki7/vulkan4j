package club.doki7.opencl;

import org.jetbrains.annotations.NotNull;

public record CLVersion(int major, int minor, int patch) {
    public static final int VERSION_MAJOR_BITS = 10;
    public static final int VERSION_MINOR_BITS = 10;
    public static final int VERSION_PATCH_BITS = 12;

    public static final int VERSION_MAJOR_MASK = (1 << VERSION_MAJOR_BITS) - 1;
    public static final int VERSION_MINOR_MASK = (1 << VERSION_MINOR_BITS) - 1;
    public static final int VERSION_PATCH_MASK = (1 << VERSION_PATCH_BITS) - 1;

    public static @NotNull CLVersion decode(int version) {
        var major = version >> (VERSION_MINOR_BITS + VERSION_PATCH_BITS);
        var minor = (version >> VERSION_PATCH_BITS) & VERSION_MINOR_MASK;
        var patch = version & VERSION_PATCH_MASK;

        return new CLVersion(major, minor, patch);
    }

    public int encode() {
        var preMajor = (major & VERSION_MAJOR_MASK) << (VERSION_MINOR_BITS + VERSION_PATCH_BITS);
        var preMinor = (minor & VERSION_MINOR_MASK) << VERSION_PATCH_BITS;
        var prePatch = patch & VERSION_PATCH_BITS;

        return preMajor | preMinor | prePatch;
    }
}
