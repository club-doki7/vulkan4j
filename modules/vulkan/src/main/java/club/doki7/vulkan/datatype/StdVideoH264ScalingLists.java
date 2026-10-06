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

/// Represents a pointer to a {@code StdVideoH264ScalingLists} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH264ScalingLists {
///     uint16_t scaling_list_present_mask; // @link substring="scaling_list_present_mask" target="#scaling_list_present_mask"
///     uint16_t use_default_scaling_matrix_mask; // @link substring="use_default_scaling_matrix_mask" target="#use_default_scaling_matrix_mask"
///     uint8_t[STD_VIDEO_H264_SCALING_LIST_4X4_NUM_ELEMENTS][STD_VIDEO_H264_SCALING_LIST_4X4_NUM_LISTS] ScalingList4x4; // @link substring="ScalingList4x4" target="#ScalingList4x4"
///     uint8_t[STD_VIDEO_H264_SCALING_LIST_8X8_NUM_ELEMENTS][STD_VIDEO_H264_SCALING_LIST_8X8_NUM_LISTS] ScalingList8x8; // @link substring="ScalingList8x8" target="#ScalingList8x8"
/// } StdVideoH264ScalingLists;
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
public record StdVideoH264ScalingLists(@NotNull MemorySegment segment) implements IStdVideoH264ScalingLists {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH264ScalingLists}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH264ScalingLists to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH264ScalingLists.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH264ScalingLists, Iterable<StdVideoH264ScalingLists> {
        public long size() {
            return segment.byteSize() / StdVideoH264ScalingLists.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH264ScalingLists at(long index) {
            return new StdVideoH264ScalingLists(segment.asSlice(index * StdVideoH264ScalingLists.BYTES, StdVideoH264ScalingLists.BYTES));
        }

        public StdVideoH264ScalingLists.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH264ScalingLists> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH264ScalingLists value) {
            MemorySegment s = segment.asSlice(index * StdVideoH264ScalingLists.BYTES, StdVideoH264ScalingLists.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH264ScalingLists.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH264ScalingLists.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH264ScalingLists.BYTES,
                (end - start) * StdVideoH264ScalingLists.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH264ScalingLists.BYTES));
        }

        public StdVideoH264ScalingLists[] toArray() {
            StdVideoH264ScalingLists[] ret = new StdVideoH264ScalingLists[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH264ScalingLists> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH264ScalingLists> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH264ScalingLists.BYTES;
            }

            @Override
            public StdVideoH264ScalingLists next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH264ScalingLists ret = new StdVideoH264ScalingLists(segment.asSlice(0, StdVideoH264ScalingLists.BYTES));
                segment = segment.asSlice(StdVideoH264ScalingLists.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH264ScalingLists allocate(Arena arena) {
        return new StdVideoH264ScalingLists(arena.allocate(LAYOUT));
    }

    public static StdVideoH264ScalingLists.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH264ScalingLists.Ptr(segment);
    }

    public static StdVideoH264ScalingLists clone(Arena arena, StdVideoH264ScalingLists src) {
        StdVideoH264ScalingLists ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned short scaling_list_present_mask() {
        return segment.get(LAYOUT$scaling_list_present_mask, OFFSET$scaling_list_present_mask);
    }

    public StdVideoH264ScalingLists scaling_list_present_mask(@Unsigned short value) {
        segment.set(LAYOUT$scaling_list_present_mask, OFFSET$scaling_list_present_mask, value);
        return this;
    }

    public @Unsigned short use_default_scaling_matrix_mask() {
        return segment.get(LAYOUT$use_default_scaling_matrix_mask, OFFSET$use_default_scaling_matrix_mask);
    }

    public StdVideoH264ScalingLists use_default_scaling_matrix_mask(@Unsigned short value) {
        segment.set(LAYOUT$use_default_scaling_matrix_mask, OFFSET$use_default_scaling_matrix_mask, value);
        return this;
    }

    public @Unsigned BytePtr ScalingList4x4() {
        return new BytePtr(ScalingList4x4Raw());
    }

    public StdVideoH264ScalingLists ScalingList4x4(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = ScalingList4x4();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH264ScalingLists ScalingList4x4(@Unsigned BytePtr value) {
        MemorySegment s = ScalingList4x4Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment ScalingList4x4Raw() {
        return segment.asSlice(OFFSET$ScalingList4x4, SIZE$ScalingList4x4);
    }

    public @Unsigned BytePtr ScalingList8x8() {
        return new BytePtr(ScalingList8x8Raw());
    }

    public StdVideoH264ScalingLists ScalingList8x8(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = ScalingList8x8();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH264ScalingLists ScalingList8x8(@Unsigned BytePtr value) {
        MemorySegment s = ScalingList8x8Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment ScalingList8x8Raw() {
        return segment.asSlice(OFFSET$ScalingList8x8, SIZE$ScalingList8x8);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_SHORT.withName("scaling_list_present_mask"),
        ValueLayout.JAVA_SHORT.withName("use_default_scaling_matrix_mask"),
        MemoryLayout.sequenceLayout(H264_SCALING_LIST_4X4_NUM_LISTS, MemoryLayout.sequenceLayout(H264_SCALING_LIST_4X4_NUM_ELEMENTS, ValueLayout.JAVA_BYTE)).withName("ScalingList4x4"),
        MemoryLayout.sequenceLayout(H264_SCALING_LIST_8X8_NUM_LISTS, MemoryLayout.sequenceLayout(H264_SCALING_LIST_8X8_NUM_ELEMENTS, ValueLayout.JAVA_BYTE)).withName("ScalingList8x8")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$scaling_list_present_mask = PathElement.groupElement("scaling_list_present_mask");
    public static final PathElement PATH$use_default_scaling_matrix_mask = PathElement.groupElement("use_default_scaling_matrix_mask");
    public static final PathElement PATH$ScalingList4x4 = PathElement.groupElement("ScalingList4x4");
    public static final PathElement PATH$ScalingList8x8 = PathElement.groupElement("ScalingList8x8");

    public static final OfShort LAYOUT$scaling_list_present_mask = (OfShort) LAYOUT.select(PATH$scaling_list_present_mask);
    public static final OfShort LAYOUT$use_default_scaling_matrix_mask = (OfShort) LAYOUT.select(PATH$use_default_scaling_matrix_mask);
    public static final SequenceLayout LAYOUT$ScalingList4x4 = (SequenceLayout) LAYOUT.select(PATH$ScalingList4x4);
    public static final SequenceLayout LAYOUT$ScalingList8x8 = (SequenceLayout) LAYOUT.select(PATH$ScalingList8x8);

    public static final long SIZE$scaling_list_present_mask = LAYOUT$scaling_list_present_mask.byteSize();
    public static final long SIZE$use_default_scaling_matrix_mask = LAYOUT$use_default_scaling_matrix_mask.byteSize();
    public static final long SIZE$ScalingList4x4 = LAYOUT$ScalingList4x4.byteSize();
    public static final long SIZE$ScalingList8x8 = LAYOUT$ScalingList8x8.byteSize();

    public static final long OFFSET$scaling_list_present_mask = LAYOUT.byteOffset(PATH$scaling_list_present_mask);
    public static final long OFFSET$use_default_scaling_matrix_mask = LAYOUT.byteOffset(PATH$use_default_scaling_matrix_mask);
    public static final long OFFSET$ScalingList4x4 = LAYOUT.byteOffset(PATH$ScalingList4x4);
    public static final long OFFSET$ScalingList8x8 = LAYOUT.byteOffset(PATH$ScalingList8x8);
}
