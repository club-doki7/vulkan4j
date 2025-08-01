package club.doki7.sdl3.datatype;

import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import club.doki7.ffm.IPointer;
import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.sdl3.bitmask.*;
import club.doki7.sdl3.handle.*;
import club.doki7.sdl3.enumtype.*;
import static club.doki7.sdl3.SDL3Constants.*;

/// A structure specifying the parameters of color targets used in a graphics
/// pipeline.
///
/// Since: This struct is available since SDL 3.2.0.
///
/// See also:
/// - `SDL_GPUGraphicsPipelineTargetInfo`
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct SDL_GPUColorTargetDescription {
///     SDL_GPUTextureFormat format; // @link substring="SDL_GPUTextureFormat" target="SDL_GPUTextureFormat" @link substring="format" target="#format"
///     SDL_GPUColorTargetBlendState blend_state; // @link substring="SDL_GPUColorTargetBlendState" target="SDL_GPUColorTargetBlendState" @link substring="blend_state" target="#blend_state"
/// } SDL_GPUColorTargetDescription;
/// }
///
/// ## Contracts
///
/// The property {@link #segment()} should always be not-null
/// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
/// {@code LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
/// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
///
/// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
/// perform any runtime check. The constructor can be useful for automatic code generators.
@ValueBasedCandidate
@UnsafeConstructor
public record SDL_GPUColorTargetDescription(@NotNull MemorySegment segment) implements ISDL_GPUColorTargetDescription {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link SDL_GPUColorTargetDescription}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ISDL_GPUColorTargetDescription to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code SDL_GPUColorTargetDescription.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ISDL_GPUColorTargetDescription, Iterable<SDL_GPUColorTargetDescription> {
        public long size() {
            return segment.byteSize() / SDL_GPUColorTargetDescription.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull SDL_GPUColorTargetDescription at(long index) {
            return new SDL_GPUColorTargetDescription(segment.asSlice(index * SDL_GPUColorTargetDescription.BYTES, SDL_GPUColorTargetDescription.BYTES));
        }

        public void write(long index, @NotNull SDL_GPUColorTargetDescription value) {
            MemorySegment s = segment.asSlice(index * SDL_GPUColorTargetDescription.BYTES, SDL_GPUColorTargetDescription.BYTES);
            s.copyFrom(value.segment);
        }

        /// Assume the {@link Ptr} is capable of holding at least {@code newSize} structures,
        /// create a new view {@link Ptr} that uses the same backing storage as this
        /// {@link Ptr}, but with the new size. Since there is actually no way to really check
        /// whether the new size is valid, while buffer overflow is undefined behavior, this method is
        /// marked as {@link Unsafe}.
        ///
        /// This method could be useful when handling data returned from some C API, where the size of
        /// the data is not known in advance.
        ///
        /// If the size of the underlying segment is actually known in advance and correctly set, and
        /// you want to create a shrunk view, you may use {@link #slice(long)} (with validation)
        /// instead.
        @Unsafe
        public @NotNull Ptr reinterpret(long newSize) {
            return new Ptr(segment.reinterpret(newSize * SDL_GPUColorTargetDescription.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * SDL_GPUColorTargetDescription.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * SDL_GPUColorTargetDescription.BYTES,
                (end - start) * SDL_GPUColorTargetDescription.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * SDL_GPUColorTargetDescription.BYTES));
        }

        public SDL_GPUColorTargetDescription[] toArray() {
            SDL_GPUColorTargetDescription[] ret = new SDL_GPUColorTargetDescription[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<SDL_GPUColorTargetDescription> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<SDL_GPUColorTargetDescription> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= SDL_GPUColorTargetDescription.BYTES;
            }

            @Override
            public SDL_GPUColorTargetDescription next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                SDL_GPUColorTargetDescription ret = new SDL_GPUColorTargetDescription(segment.asSlice(0, SDL_GPUColorTargetDescription.BYTES));
                segment = segment.asSlice(SDL_GPUColorTargetDescription.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static SDL_GPUColorTargetDescription allocate(Arena arena) {
        return new SDL_GPUColorTargetDescription(arena.allocate(LAYOUT));
    }

    public static SDL_GPUColorTargetDescription.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new SDL_GPUColorTargetDescription.Ptr(segment);
    }

    public static SDL_GPUColorTargetDescription clone(Arena arena, SDL_GPUColorTargetDescription src) {
        SDL_GPUColorTargetDescription ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(SDL_GPUTextureFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public SDL_GPUColorTargetDescription format(@EnumType(SDL_GPUTextureFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public @NotNull SDL_GPUColorTargetBlendState blend_state() {
        return new SDL_GPUColorTargetBlendState(segment.asSlice(OFFSET$blend_state, LAYOUT$blend_state));
    }

    public SDL_GPUColorTargetDescription blend_state(@NotNull SDL_GPUColorTargetBlendState value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$blend_state, SIZE$blend_state);
        return this;
    }

    public SDL_GPUColorTargetDescription blend_state(Consumer<@NotNull SDL_GPUColorTargetBlendState> consumer) {
        consumer.accept(blend_state());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("format"),
        SDL_GPUColorTargetBlendState.LAYOUT.withName("blend_state")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$format = PathElement.groupElement("format");
    public static final PathElement PATH$blend_state = PathElement.groupElement("blend_state");

    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);
    public static final StructLayout LAYOUT$blend_state = (StructLayout) LAYOUT.select(PATH$blend_state);

    public static final long SIZE$format = LAYOUT$format.byteSize();
    public static final long SIZE$blend_state = LAYOUT$blend_state.byteSize();

    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
    public static final long OFFSET$blend_state = LAYOUT.byteOffset(PATH$blend_state);
}
