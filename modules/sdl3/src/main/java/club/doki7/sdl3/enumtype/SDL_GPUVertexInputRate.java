package club.doki7.sdl3.enumtype;

import club.doki7.ffm.annotation.*;

/// Specifies the rate at which vertex attributes are pulled from buffers.
///
/// Since: This enum is available since SDL 3.2.0.
///
/// See also:
/// - `SDL_CreateGPUGraphicsPipeline`
///
public final class SDL_GPUVertexInputRate {
    public static final int VERTEX = 0x0;
    public static final int INSTANCE = 0x1;

    public static String explain(@EnumType(SDL_GPUVertexInputRate.class) int value) {
        return switch (value) {
            case SDL_GPUVertexInputRate.INSTANCE -> "SDL_GPU_VERTEXINPUTRATE_INSTANCE";
            case SDL_GPUVertexInputRate.VERTEX -> "SDL_GPU_VERTEXINPUTRATE_VERTEX";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private SDL_GPUVertexInputRate() {}
}
