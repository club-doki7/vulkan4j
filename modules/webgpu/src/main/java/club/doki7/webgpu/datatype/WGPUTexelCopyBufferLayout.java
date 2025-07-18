package club.doki7.webgpu.datatype;

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
import club.doki7.webgpu.bitmask.*;
import club.doki7.webgpu.handle.*;
import club.doki7.webgpu.enumtype.*;
import static club.doki7.webgpu.WGPUConstants.*;
import club.doki7.webgpu.WGPUFunctionTypes.*;

/// Represents a pointer to a {@code WGPUTexelCopyBufferLayout} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct WGPUTexelCopyBufferLayout {
///     uint64_t offset; // @link substring="offset" target="#offset"
///     uint32_t bytesPerRow; // @link substring="bytesPerRow" target="#bytesPerRow"
///     uint32_t rowsPerImage; // @link substring="rowsPerImage" target="#rowsPerImage"
/// } WGPUTexelCopyBufferLayout;
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
public record WGPUTexelCopyBufferLayout(@NotNull MemorySegment segment) implements IWGPUTexelCopyBufferLayout {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link WGPUTexelCopyBufferLayout}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IWGPUTexelCopyBufferLayout to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code WGPUTexelCopyBufferLayout.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IWGPUTexelCopyBufferLayout, Iterable<WGPUTexelCopyBufferLayout> {
        public long size() {
            return segment.byteSize() / WGPUTexelCopyBufferLayout.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull WGPUTexelCopyBufferLayout at(long index) {
            return new WGPUTexelCopyBufferLayout(segment.asSlice(index * WGPUTexelCopyBufferLayout.BYTES, WGPUTexelCopyBufferLayout.BYTES));
        }

        public WGPUTexelCopyBufferLayout.Ptr at(long index, @NotNull Consumer<@NotNull WGPUTexelCopyBufferLayout> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull WGPUTexelCopyBufferLayout value) {
            MemorySegment s = segment.asSlice(index * WGPUTexelCopyBufferLayout.BYTES, WGPUTexelCopyBufferLayout.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * WGPUTexelCopyBufferLayout.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * WGPUTexelCopyBufferLayout.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * WGPUTexelCopyBufferLayout.BYTES,
                (end - start) * WGPUTexelCopyBufferLayout.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * WGPUTexelCopyBufferLayout.BYTES));
        }

        public WGPUTexelCopyBufferLayout[] toArray() {
            WGPUTexelCopyBufferLayout[] ret = new WGPUTexelCopyBufferLayout[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<WGPUTexelCopyBufferLayout> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<WGPUTexelCopyBufferLayout> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= WGPUTexelCopyBufferLayout.BYTES;
            }

            @Override
            public WGPUTexelCopyBufferLayout next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                WGPUTexelCopyBufferLayout ret = new WGPUTexelCopyBufferLayout(segment.asSlice(0, WGPUTexelCopyBufferLayout.BYTES));
                segment = segment.asSlice(WGPUTexelCopyBufferLayout.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static WGPUTexelCopyBufferLayout allocate(Arena arena) {
        return new WGPUTexelCopyBufferLayout(arena.allocate(LAYOUT));
    }

    public static WGPUTexelCopyBufferLayout.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new WGPUTexelCopyBufferLayout.Ptr(segment);
    }

    public static WGPUTexelCopyBufferLayout clone(Arena arena, WGPUTexelCopyBufferLayout src) {
        WGPUTexelCopyBufferLayout ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned long offset() {
        return segment.get(LAYOUT$offset, OFFSET$offset);
    }

    public WGPUTexelCopyBufferLayout offset(@Unsigned long value) {
        segment.set(LAYOUT$offset, OFFSET$offset, value);
        return this;
    }

    public @Unsigned int bytesPerRow() {
        return segment.get(LAYOUT$bytesPerRow, OFFSET$bytesPerRow);
    }

    public WGPUTexelCopyBufferLayout bytesPerRow(@Unsigned int value) {
        segment.set(LAYOUT$bytesPerRow, OFFSET$bytesPerRow, value);
        return this;
    }

    public @Unsigned int rowsPerImage() {
        return segment.get(LAYOUT$rowsPerImage, OFFSET$rowsPerImage);
    }

    public WGPUTexelCopyBufferLayout rowsPerImage(@Unsigned int value) {
        segment.set(LAYOUT$rowsPerImage, OFFSET$rowsPerImage, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("offset"),
        ValueLayout.JAVA_INT.withName("bytesPerRow"),
        ValueLayout.JAVA_INT.withName("rowsPerImage")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$offset = PathElement.groupElement("offset");
    public static final PathElement PATH$bytesPerRow = PathElement.groupElement("bytesPerRow");
    public static final PathElement PATH$rowsPerImage = PathElement.groupElement("rowsPerImage");

    public static final OfLong LAYOUT$offset = (OfLong) LAYOUT.select(PATH$offset);
    public static final OfInt LAYOUT$bytesPerRow = (OfInt) LAYOUT.select(PATH$bytesPerRow);
    public static final OfInt LAYOUT$rowsPerImage = (OfInt) LAYOUT.select(PATH$rowsPerImage);

    public static final long SIZE$offset = LAYOUT$offset.byteSize();
    public static final long SIZE$bytesPerRow = LAYOUT$bytesPerRow.byteSize();
    public static final long SIZE$rowsPerImage = LAYOUT$rowsPerImage.byteSize();

    public static final long OFFSET$offset = LAYOUT.byteOffset(PATH$offset);
    public static final long OFFSET$bytesPerRow = LAYOUT.byteOffset(PATH$bytesPerRow);
    public static final long OFFSET$rowsPerImage = LAYOUT.byteOffset(PATH$rowsPerImage);
}
