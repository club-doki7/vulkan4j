package club.doki7.sdl3.enumtype;

import club.doki7.ffm.annotation.*;

/// Possible values to be set for the SDL_GL_CONTEXT_PROFILE_MASK attribute.
///
/// Since: This datatype is available since SDL 3.2.0.
///
public final class SDL_GLProfile {
    public static final int CORE = 0x1;
    public static final int COMPATIBILITY = 0x2;
    public static final int ES = 0x4;

    public static String explain(@EnumType(SDL_GLProfile.class) int value) {
        return switch (value) {
            case SDL_GLProfile.COMPATIBILITY -> "SDL_GL_CONTEXT_PROFILE_COMPATIBILITY";
            case SDL_GLProfile.CORE -> "SDL_GL_CONTEXT_PROFILE_CORE";
            case SDL_GLProfile.ES -> "SDL_GL_CONTEXT_PROFILE_ES";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private SDL_GLProfile() {}
}
