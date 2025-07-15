package club.doki7.opencl.datatype;

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
import club.doki7.opencl.handle.*;
import static club.doki7.opencl.CLConstants.*;
import club.doki7.opencl.CLFunctionTypes.*;

/// Represents a pointer to a {@code VAImageFormat} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VAImageFormat {
///     uint32_t fourcc; // @link substring="fourcc" target="#fourcc"
///     uint32_t byte_order; // @link substring="byte_order" target="#byte_order"
///     uint32_t bits_per_pixel; // @link substring="bits_per_pixel" target="#bits_per_pixel"
///     uint32_t depth; // @link substring="depth" target="#depth"
///     uint32_t red_mask; // @link substring="red_mask" target="#red_mask"
///     uint32_t green_mask; // @link substring="green_mask" target="#green_mask"
///     uint32_t blue_mask; // @link substring="blue_mask" target="#blue_mask"
///     uint32_t alpha_mask; // @link substring="alpha_mask" target="#alpha_mask"
///     uint32_t[4] va_reserved; // @link substring="va_reserved" target="#va_reserved"
/// } VAImageFormat;
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
public record VAImageFormatCLREF(@NotNull MemorySegment segment) implements IVAImageFormatCLREF {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VAImageFormatCLREF}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVAImageFormatCLREF to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VAImageFormatCLREF.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVAImageFormatCLREF, Iterable<VAImageFormatCLREF> {
        public long size() {
            return segment.byteSize() / VAImageFormatCLREF.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VAImageFormatCLREF at(long index) {
            return new VAImageFormatCLREF(segment.asSlice(index * VAImageFormatCLREF.BYTES, VAImageFormatCLREF.BYTES));
        }

        public VAImageFormatCLREF.Ptr at(long index, @NotNull Consumer<@NotNull VAImageFormatCLREF> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VAImageFormatCLREF value) {
            MemorySegment s = segment.asSlice(index * VAImageFormatCLREF.BYTES, VAImageFormatCLREF.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VAImageFormatCLREF.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VAImageFormatCLREF.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VAImageFormatCLREF.BYTES,
                (end - start) * VAImageFormatCLREF.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VAImageFormatCLREF.BYTES));
        }

        public VAImageFormatCLREF[] toArray() {
            VAImageFormatCLREF[] ret = new VAImageFormatCLREF[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VAImageFormatCLREF> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VAImageFormatCLREF> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VAImageFormatCLREF.BYTES;
            }

            @Override
            public VAImageFormatCLREF next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VAImageFormatCLREF ret = new VAImageFormatCLREF(segment.asSlice(0, VAImageFormatCLREF.BYTES));
                segment = segment.asSlice(VAImageFormatCLREF.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VAImageFormatCLREF allocate(Arena arena) {
        return new VAImageFormatCLREF(arena.allocate(LAYOUT));
    }

    public static VAImageFormatCLREF.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VAImageFormatCLREF.Ptr(segment);
    }

    public static VAImageFormatCLREF clone(Arena arena, VAImageFormatCLREF src) {
        VAImageFormatCLREF ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int fourcc() {
        return segment.get(LAYOUT$fourcc, OFFSET$fourcc);
    }

    public VAImageFormatCLREF fourcc(@Unsigned int value) {
        segment.set(LAYOUT$fourcc, OFFSET$fourcc, value);
        return this;
    }

    public @Unsigned int byte_order() {
        return segment.get(LAYOUT$byte_order, OFFSET$byte_order);
    }

    public VAImageFormatCLREF byte_order(@Unsigned int value) {
        segment.set(LAYOUT$byte_order, OFFSET$byte_order, value);
        return this;
    }

    public @Unsigned int bits_per_pixel() {
        return segment.get(LAYOUT$bits_per_pixel, OFFSET$bits_per_pixel);
    }

    public VAImageFormatCLREF bits_per_pixel(@Unsigned int value) {
        segment.set(LAYOUT$bits_per_pixel, OFFSET$bits_per_pixel, value);
        return this;
    }

    public @Unsigned int depth() {
        return segment.get(LAYOUT$depth, OFFSET$depth);
    }

    public VAImageFormatCLREF depth(@Unsigned int value) {
        segment.set(LAYOUT$depth, OFFSET$depth, value);
        return this;
    }

    public @Unsigned int red_mask() {
        return segment.get(LAYOUT$red_mask, OFFSET$red_mask);
    }

    public VAImageFormatCLREF red_mask(@Unsigned int value) {
        segment.set(LAYOUT$red_mask, OFFSET$red_mask, value);
        return this;
    }

    public @Unsigned int green_mask() {
        return segment.get(LAYOUT$green_mask, OFFSET$green_mask);
    }

    public VAImageFormatCLREF green_mask(@Unsigned int value) {
        segment.set(LAYOUT$green_mask, OFFSET$green_mask, value);
        return this;
    }

    public @Unsigned int blue_mask() {
        return segment.get(LAYOUT$blue_mask, OFFSET$blue_mask);
    }

    public VAImageFormatCLREF blue_mask(@Unsigned int value) {
        segment.set(LAYOUT$blue_mask, OFFSET$blue_mask, value);
        return this;
    }

    public @Unsigned int alpha_mask() {
        return segment.get(LAYOUT$alpha_mask, OFFSET$alpha_mask);
    }

    public VAImageFormatCLREF alpha_mask(@Unsigned int value) {
        segment.set(LAYOUT$alpha_mask, OFFSET$alpha_mask, value);
        return this;
    }

    public @Unsigned IntPtr va_reserved() {
        return new IntPtr(va_reservedRaw());
    }

    public VAImageFormatCLREF va_reserved(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = va_reserved();
        consumer.accept(ptr);
        return this;
    }

    public VAImageFormatCLREF va_reserved(@Unsigned IntPtr value) {
        MemorySegment s = va_reservedRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment va_reservedRaw() {
        return segment.asSlice(OFFSET$va_reserved, SIZE$va_reserved);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("fourcc"),
        ValueLayout.JAVA_INT.withName("byte_order"),
        ValueLayout.JAVA_INT.withName("bits_per_pixel"),
        ValueLayout.JAVA_INT.withName("depth"),
        ValueLayout.JAVA_INT.withName("red_mask"),
        ValueLayout.JAVA_INT.withName("green_mask"),
        ValueLayout.JAVA_INT.withName("blue_mask"),
        ValueLayout.JAVA_INT.withName("alpha_mask"),
        MemoryLayout.sequenceLayout(4, ValueLayout.JAVA_INT).withName("va_reserved")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$fourcc = PathElement.groupElement("fourcc");
    public static final PathElement PATH$byte_order = PathElement.groupElement("byte_order");
    public static final PathElement PATH$bits_per_pixel = PathElement.groupElement("bits_per_pixel");
    public static final PathElement PATH$depth = PathElement.groupElement("depth");
    public static final PathElement PATH$red_mask = PathElement.groupElement("red_mask");
    public static final PathElement PATH$green_mask = PathElement.groupElement("green_mask");
    public static final PathElement PATH$blue_mask = PathElement.groupElement("blue_mask");
    public static final PathElement PATH$alpha_mask = PathElement.groupElement("alpha_mask");
    public static final PathElement PATH$va_reserved = PathElement.groupElement("va_reserved");

    public static final OfInt LAYOUT$fourcc = (OfInt) LAYOUT.select(PATH$fourcc);
    public static final OfInt LAYOUT$byte_order = (OfInt) LAYOUT.select(PATH$byte_order);
    public static final OfInt LAYOUT$bits_per_pixel = (OfInt) LAYOUT.select(PATH$bits_per_pixel);
    public static final OfInt LAYOUT$depth = (OfInt) LAYOUT.select(PATH$depth);
    public static final OfInt LAYOUT$red_mask = (OfInt) LAYOUT.select(PATH$red_mask);
    public static final OfInt LAYOUT$green_mask = (OfInt) LAYOUT.select(PATH$green_mask);
    public static final OfInt LAYOUT$blue_mask = (OfInt) LAYOUT.select(PATH$blue_mask);
    public static final OfInt LAYOUT$alpha_mask = (OfInt) LAYOUT.select(PATH$alpha_mask);
    public static final SequenceLayout LAYOUT$va_reserved = (SequenceLayout) LAYOUT.select(PATH$va_reserved);

    public static final long SIZE$fourcc = LAYOUT$fourcc.byteSize();
    public static final long SIZE$byte_order = LAYOUT$byte_order.byteSize();
    public static final long SIZE$bits_per_pixel = LAYOUT$bits_per_pixel.byteSize();
    public static final long SIZE$depth = LAYOUT$depth.byteSize();
    public static final long SIZE$red_mask = LAYOUT$red_mask.byteSize();
    public static final long SIZE$green_mask = LAYOUT$green_mask.byteSize();
    public static final long SIZE$blue_mask = LAYOUT$blue_mask.byteSize();
    public static final long SIZE$alpha_mask = LAYOUT$alpha_mask.byteSize();
    public static final long SIZE$va_reserved = LAYOUT$va_reserved.byteSize();

    public static final long OFFSET$fourcc = LAYOUT.byteOffset(PATH$fourcc);
    public static final long OFFSET$byte_order = LAYOUT.byteOffset(PATH$byte_order);
    public static final long OFFSET$bits_per_pixel = LAYOUT.byteOffset(PATH$bits_per_pixel);
    public static final long OFFSET$depth = LAYOUT.byteOffset(PATH$depth);
    public static final long OFFSET$red_mask = LAYOUT.byteOffset(PATH$red_mask);
    public static final long OFFSET$green_mask = LAYOUT.byteOffset(PATH$green_mask);
    public static final long OFFSET$blue_mask = LAYOUT.byteOffset(PATH$blue_mask);
    public static final long OFFSET$alpha_mask = LAYOUT.byteOffset(PATH$alpha_mask);
    public static final long OFFSET$va_reserved = LAYOUT.byteOffset(PATH$va_reserved);
}
