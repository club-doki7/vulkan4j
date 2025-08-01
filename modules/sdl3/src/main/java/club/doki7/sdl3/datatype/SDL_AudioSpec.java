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

/// Format specifier for audio data.
///
/// Since: This struct is available since SDL 3.2.0.
///
/// See also:
/// - `SDL_AudioFormat`
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct SDL_AudioSpec {
///     SDL_AudioFormat format; // @link substring="SDL_AudioFormat" target="SDL_AudioFormat" @link substring="format" target="#format"
///     int channels; // @link substring="channels" target="#channels"
///     int freq; // @link substring="freq" target="#freq"
/// } SDL_AudioSpec;
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
public record SDL_AudioSpec(@NotNull MemorySegment segment) implements ISDL_AudioSpec {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link SDL_AudioSpec}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ISDL_AudioSpec to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code SDL_AudioSpec.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ISDL_AudioSpec, Iterable<SDL_AudioSpec> {
        public long size() {
            return segment.byteSize() / SDL_AudioSpec.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull SDL_AudioSpec at(long index) {
            return new SDL_AudioSpec(segment.asSlice(index * SDL_AudioSpec.BYTES, SDL_AudioSpec.BYTES));
        }

        public void write(long index, @NotNull SDL_AudioSpec value) {
            MemorySegment s = segment.asSlice(index * SDL_AudioSpec.BYTES, SDL_AudioSpec.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * SDL_AudioSpec.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * SDL_AudioSpec.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * SDL_AudioSpec.BYTES,
                (end - start) * SDL_AudioSpec.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * SDL_AudioSpec.BYTES));
        }

        public SDL_AudioSpec[] toArray() {
            SDL_AudioSpec[] ret = new SDL_AudioSpec[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<SDL_AudioSpec> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<SDL_AudioSpec> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= SDL_AudioSpec.BYTES;
            }

            @Override
            public SDL_AudioSpec next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                SDL_AudioSpec ret = new SDL_AudioSpec(segment.asSlice(0, SDL_AudioSpec.BYTES));
                segment = segment.asSlice(SDL_AudioSpec.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static SDL_AudioSpec allocate(Arena arena) {
        return new SDL_AudioSpec(arena.allocate(LAYOUT));
    }

    public static SDL_AudioSpec.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new SDL_AudioSpec.Ptr(segment);
    }

    public static SDL_AudioSpec clone(Arena arena, SDL_AudioSpec src) {
        SDL_AudioSpec ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(SDL_AudioFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public SDL_AudioSpec format(@EnumType(SDL_AudioFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public int channels() {
        return segment.get(LAYOUT$channels, OFFSET$channels);
    }

    public SDL_AudioSpec channels(int value) {
        segment.set(LAYOUT$channels, OFFSET$channels, value);
        return this;
    }

    public int freq() {
        return segment.get(LAYOUT$freq, OFFSET$freq);
    }

    public SDL_AudioSpec freq(int value) {
        segment.set(LAYOUT$freq, OFFSET$freq, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("format"),
        ValueLayout.JAVA_INT.withName("channels"),
        ValueLayout.JAVA_INT.withName("freq")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$format = PathElement.groupElement("format");
    public static final PathElement PATH$channels = PathElement.groupElement("channels");
    public static final PathElement PATH$freq = PathElement.groupElement("freq");

    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);
    public static final OfInt LAYOUT$channels = (OfInt) LAYOUT.select(PATH$channels);
    public static final OfInt LAYOUT$freq = (OfInt) LAYOUT.select(PATH$freq);

    public static final long SIZE$format = LAYOUT$format.byteSize();
    public static final long SIZE$channels = LAYOUT$channels.byteSize();
    public static final long SIZE$freq = LAYOUT$freq.byteSize();

    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
    public static final long OFFSET$channels = LAYOUT.byteOffset(PATH$channels);
    public static final long OFFSET$freq = LAYOUT.byteOffset(PATH$freq);
}
