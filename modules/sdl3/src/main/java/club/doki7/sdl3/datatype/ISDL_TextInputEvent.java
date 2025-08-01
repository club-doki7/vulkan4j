package club.doki7.sdl3.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link SDL_TextInputEvent} and {@link SDL_TextInputEvent.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ISDL_TextInputEvent
    extends IPointer
    permits SDL_TextInputEvent, SDL_TextInputEvent.Ptr
{}
