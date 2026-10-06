package club.doki7.vulkan.datatype;

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
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.handle.*;
import club.doki7.vulkan.enumtype.*;
import static club.doki7.vulkan.VkConstants.*;
import club.doki7.vulkan.VkFunctionTypes.*;

/// Represents a pointer to a {@code StdVideoEncodeAV1ExtensionHeader} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeAV1ExtensionHeader {
///     uint8_t temporal_id; // @link substring="temporal_id" target="#temporal_id"
///     uint8_t spatial_id; // @link substring="spatial_id" target="#spatial_id"
/// } StdVideoEncodeAV1ExtensionHeader;
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
public record StdVideoEncodeAV1ExtensionHeader(@NotNull MemorySegment segment) implements IStdVideoEncodeAV1ExtensionHeader {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeAV1ExtensionHeader}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeAV1ExtensionHeader to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeAV1ExtensionHeader.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeAV1ExtensionHeader, Iterable<StdVideoEncodeAV1ExtensionHeader> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeAV1ExtensionHeader.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeAV1ExtensionHeader at(long index) {
            return new StdVideoEncodeAV1ExtensionHeader(segment.asSlice(index * StdVideoEncodeAV1ExtensionHeader.BYTES, StdVideoEncodeAV1ExtensionHeader.BYTES));
        }

        public StdVideoEncodeAV1ExtensionHeader.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeAV1ExtensionHeader> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeAV1ExtensionHeader value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeAV1ExtensionHeader.BYTES, StdVideoEncodeAV1ExtensionHeader.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeAV1ExtensionHeader.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeAV1ExtensionHeader.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeAV1ExtensionHeader.BYTES,
                (end - start) * StdVideoEncodeAV1ExtensionHeader.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeAV1ExtensionHeader.BYTES));
        }

        public StdVideoEncodeAV1ExtensionHeader[] toArray() {
            StdVideoEncodeAV1ExtensionHeader[] ret = new StdVideoEncodeAV1ExtensionHeader[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeAV1ExtensionHeader> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeAV1ExtensionHeader> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeAV1ExtensionHeader.BYTES;
            }

            @Override
            public StdVideoEncodeAV1ExtensionHeader next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeAV1ExtensionHeader ret = new StdVideoEncodeAV1ExtensionHeader(segment.asSlice(0, StdVideoEncodeAV1ExtensionHeader.BYTES));
                segment = segment.asSlice(StdVideoEncodeAV1ExtensionHeader.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeAV1ExtensionHeader allocate(Arena arena) {
        return new StdVideoEncodeAV1ExtensionHeader(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeAV1ExtensionHeader.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeAV1ExtensionHeader.Ptr(segment);
    }

    public static StdVideoEncodeAV1ExtensionHeader clone(Arena arena, StdVideoEncodeAV1ExtensionHeader src) {
        StdVideoEncodeAV1ExtensionHeader ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned byte temporal_id() {
        return segment.get(LAYOUT$temporal_id, OFFSET$temporal_id);
    }

    public StdVideoEncodeAV1ExtensionHeader temporal_id(@Unsigned byte value) {
        segment.set(LAYOUT$temporal_id, OFFSET$temporal_id, value);
        return this;
    }

    public @Unsigned byte spatial_id() {
        return segment.get(LAYOUT$spatial_id, OFFSET$spatial_id);
    }

    public StdVideoEncodeAV1ExtensionHeader spatial_id(@Unsigned byte value) {
        segment.set(LAYOUT$spatial_id, OFFSET$spatial_id, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_BYTE.withName("temporal_id"),
        ValueLayout.JAVA_BYTE.withName("spatial_id")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$temporal_id = PathElement.groupElement("temporal_id");
    public static final PathElement PATH$spatial_id = PathElement.groupElement("spatial_id");

    public static final OfByte LAYOUT$temporal_id = (OfByte) LAYOUT.select(PATH$temporal_id);
    public static final OfByte LAYOUT$spatial_id = (OfByte) LAYOUT.select(PATH$spatial_id);

    public static final long SIZE$temporal_id = LAYOUT$temporal_id.byteSize();
    public static final long SIZE$spatial_id = LAYOUT$spatial_id.byteSize();

    public static final long OFFSET$temporal_id = LAYOUT.byteOffset(PATH$temporal_id);
    public static final long OFFSET$spatial_id = LAYOUT.byteOffset(PATH$spatial_id);
}
