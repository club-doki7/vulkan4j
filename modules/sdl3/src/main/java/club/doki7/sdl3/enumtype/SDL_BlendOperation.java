package club.doki7.sdl3.enumtype;

import club.doki7.ffm.annotation.*;

/// The blend operation used when combining source and destination pixel
/// components.
///
/// Since: This enum is available since SDL 3.2.0.
///
public final class SDL_BlendOperation {
    public static final int ADD = 0x1;
    public static final int SUBTRACT = 0x2;
    public static final int REV_SUBTRACT = 0x3;
    public static final int MINIMUM = 0x4;
    public static final int MAXIMUM = 0x5;

    public static String explain(@EnumType(SDL_BlendOperation.class) int value) {
        return switch (value) {
            case SDL_BlendOperation.ADD -> "SDL_BLENDOPERATION_ADD";
            case SDL_BlendOperation.MAXIMUM -> "SDL_BLENDOPERATION_MAXIMUM";
            case SDL_BlendOperation.MINIMUM -> "SDL_BLENDOPERATION_MINIMUM";
            case SDL_BlendOperation.REV_SUBTRACT -> "SDL_BLENDOPERATION_REV_SUBTRACT";
            case SDL_BlendOperation.SUBTRACT -> "SDL_BLENDOPERATION_SUBTRACT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private SDL_BlendOperation() {}
}
