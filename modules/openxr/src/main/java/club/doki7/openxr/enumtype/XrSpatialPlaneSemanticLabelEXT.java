package club.doki7.openxr.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrSpatialPlaneSemanticLabelEXT.html"><code>XrSpatialPlaneSemanticLabelEXT</code></a>
public final class XrSpatialPlaneSemanticLabelEXT {
    public static final int UNCATEGORIZED = 0x1;
    public static final int FLOOR = 0x2;
    public static final int WALL = 0x3;
    public static final int CEILING = 0x4;
    public static final int TABLE = 0x5;

    public static String explain(@EnumType(XrSpatialPlaneSemanticLabelEXT.class) int value) {
        return switch (value) {
            case XrSpatialPlaneSemanticLabelEXT.CEILING -> "XR_SPATIAL_PLANE_SEMANTIC_LABEL_CEILING_EXT";
            case XrSpatialPlaneSemanticLabelEXT.FLOOR -> "XR_SPATIAL_PLANE_SEMANTIC_LABEL_FLOOR_EXT";
            case XrSpatialPlaneSemanticLabelEXT.TABLE -> "XR_SPATIAL_PLANE_SEMANTIC_LABEL_TABLE_EXT";
            case XrSpatialPlaneSemanticLabelEXT.UNCATEGORIZED -> "XR_SPATIAL_PLANE_SEMANTIC_LABEL_UNCATEGORIZED_EXT";
            case XrSpatialPlaneSemanticLabelEXT.WALL -> "XR_SPATIAL_PLANE_SEMANTIC_LABEL_WALL_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private XrSpatialPlaneSemanticLabelEXT() {}
}
