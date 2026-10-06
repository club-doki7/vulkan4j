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

/// Represents a pointer to a {@code StdVideoH265ScalingLists} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265ScalingLists {
///     uint8_t[STD_VIDEO_H265_SCALING_LIST_4X4_NUM_ELEMENTS][STD_VIDEO_H265_SCALING_LIST_4X4_NUM_LISTS] ScalingList4x4; // @link substring="ScalingList4x4" target="#ScalingList4x4"
///     uint8_t[STD_VIDEO_H265_SCALING_LIST_8X8_NUM_ELEMENTS][STD_VIDEO_H265_SCALING_LIST_8X8_NUM_LISTS] ScalingList8x8; // @link substring="ScalingList8x8" target="#ScalingList8x8"
///     uint8_t[STD_VIDEO_H265_SCALING_LIST_16X16_NUM_ELEMENTS][STD_VIDEO_H265_SCALING_LIST_16X16_NUM_LISTS] ScalingList16x16; // @link substring="ScalingList16x16" target="#ScalingList16x16"
///     uint8_t[STD_VIDEO_H265_SCALING_LIST_32X32_NUM_ELEMENTS][STD_VIDEO_H265_SCALING_LIST_32X32_NUM_LISTS] ScalingList32x32; // @link substring="ScalingList32x32" target="#ScalingList32x32"
///     uint8_t[STD_VIDEO_H265_SCALING_LIST_16X16_NUM_LISTS] ScalingListDCCoef16x16; // @link substring="ScalingListDCCoef16x16" target="#ScalingListDCCoef16x16"
///     uint8_t[STD_VIDEO_H265_SCALING_LIST_32X32_NUM_LISTS] ScalingListDCCoef32x32; // @link substring="ScalingListDCCoef32x32" target="#ScalingListDCCoef32x32"
/// } StdVideoH265ScalingLists;
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
public record StdVideoH265ScalingLists(@NotNull MemorySegment segment) implements IStdVideoH265ScalingLists {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265ScalingLists}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265ScalingLists to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265ScalingLists.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265ScalingLists, Iterable<StdVideoH265ScalingLists> {
        public long size() {
            return segment.byteSize() / StdVideoH265ScalingLists.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265ScalingLists at(long index) {
            return new StdVideoH265ScalingLists(segment.asSlice(index * StdVideoH265ScalingLists.BYTES, StdVideoH265ScalingLists.BYTES));
        }

        public StdVideoH265ScalingLists.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265ScalingLists> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265ScalingLists value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265ScalingLists.BYTES, StdVideoH265ScalingLists.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265ScalingLists.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265ScalingLists.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265ScalingLists.BYTES,
                (end - start) * StdVideoH265ScalingLists.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265ScalingLists.BYTES));
        }

        public StdVideoH265ScalingLists[] toArray() {
            StdVideoH265ScalingLists[] ret = new StdVideoH265ScalingLists[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265ScalingLists> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265ScalingLists> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265ScalingLists.BYTES;
            }

            @Override
            public StdVideoH265ScalingLists next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265ScalingLists ret = new StdVideoH265ScalingLists(segment.asSlice(0, StdVideoH265ScalingLists.BYTES));
                segment = segment.asSlice(StdVideoH265ScalingLists.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265ScalingLists allocate(Arena arena) {
        return new StdVideoH265ScalingLists(arena.allocate(LAYOUT));
    }

    public static StdVideoH265ScalingLists.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265ScalingLists.Ptr(segment);
    }

    public static StdVideoH265ScalingLists clone(Arena arena, StdVideoH265ScalingLists src) {
        StdVideoH265ScalingLists ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned BytePtr ScalingList4x4() {
        return new BytePtr(ScalingList4x4Raw());
    }

    public StdVideoH265ScalingLists ScalingList4x4(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = ScalingList4x4();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265ScalingLists ScalingList4x4(@Unsigned BytePtr value) {
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

    public StdVideoH265ScalingLists ScalingList8x8(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = ScalingList8x8();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265ScalingLists ScalingList8x8(@Unsigned BytePtr value) {
        MemorySegment s = ScalingList8x8Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment ScalingList8x8Raw() {
        return segment.asSlice(OFFSET$ScalingList8x8, SIZE$ScalingList8x8);
    }

    public @Unsigned BytePtr ScalingList16x16() {
        return new BytePtr(ScalingList16x16Raw());
    }

    public StdVideoH265ScalingLists ScalingList16x16(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = ScalingList16x16();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265ScalingLists ScalingList16x16(@Unsigned BytePtr value) {
        MemorySegment s = ScalingList16x16Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment ScalingList16x16Raw() {
        return segment.asSlice(OFFSET$ScalingList16x16, SIZE$ScalingList16x16);
    }

    public @Unsigned BytePtr ScalingList32x32() {
        return new BytePtr(ScalingList32x32Raw());
    }

    public StdVideoH265ScalingLists ScalingList32x32(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = ScalingList32x32();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265ScalingLists ScalingList32x32(@Unsigned BytePtr value) {
        MemorySegment s = ScalingList32x32Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment ScalingList32x32Raw() {
        return segment.asSlice(OFFSET$ScalingList32x32, SIZE$ScalingList32x32);
    }

    public @Unsigned BytePtr ScalingListDCCoef16x16() {
        return new BytePtr(ScalingListDCCoef16x16Raw());
    }

    public StdVideoH265ScalingLists ScalingListDCCoef16x16(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = ScalingListDCCoef16x16();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265ScalingLists ScalingListDCCoef16x16(@Unsigned BytePtr value) {
        MemorySegment s = ScalingListDCCoef16x16Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment ScalingListDCCoef16x16Raw() {
        return segment.asSlice(OFFSET$ScalingListDCCoef16x16, SIZE$ScalingListDCCoef16x16);
    }

    public @Unsigned BytePtr ScalingListDCCoef32x32() {
        return new BytePtr(ScalingListDCCoef32x32Raw());
    }

    public StdVideoH265ScalingLists ScalingListDCCoef32x32(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = ScalingListDCCoef32x32();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265ScalingLists ScalingListDCCoef32x32(@Unsigned BytePtr value) {
        MemorySegment s = ScalingListDCCoef32x32Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment ScalingListDCCoef32x32Raw() {
        return segment.asSlice(OFFSET$ScalingListDCCoef32x32, SIZE$ScalingListDCCoef32x32);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(H265_SCALING_LIST_4X4_NUM_LISTS, MemoryLayout.sequenceLayout(H265_SCALING_LIST_4X4_NUM_ELEMENTS, ValueLayout.JAVA_BYTE)).withName("ScalingList4x4"),
        MemoryLayout.sequenceLayout(H265_SCALING_LIST_8X8_NUM_LISTS, MemoryLayout.sequenceLayout(H265_SCALING_LIST_8X8_NUM_ELEMENTS, ValueLayout.JAVA_BYTE)).withName("ScalingList8x8"),
        MemoryLayout.sequenceLayout(H265_SCALING_LIST_16X16_NUM_LISTS, MemoryLayout.sequenceLayout(H265_SCALING_LIST_16X16_NUM_ELEMENTS, ValueLayout.JAVA_BYTE)).withName("ScalingList16x16"),
        MemoryLayout.sequenceLayout(H265_SCALING_LIST_32X32_NUM_LISTS, MemoryLayout.sequenceLayout(H265_SCALING_LIST_32X32_NUM_ELEMENTS, ValueLayout.JAVA_BYTE)).withName("ScalingList32x32"),
        MemoryLayout.sequenceLayout(H265_SCALING_LIST_16X16_NUM_LISTS, ValueLayout.JAVA_BYTE).withName("ScalingListDCCoef16x16"),
        MemoryLayout.sequenceLayout(H265_SCALING_LIST_32X32_NUM_LISTS, ValueLayout.JAVA_BYTE).withName("ScalingListDCCoef32x32")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$ScalingList4x4 = PathElement.groupElement("ScalingList4x4");
    public static final PathElement PATH$ScalingList8x8 = PathElement.groupElement("ScalingList8x8");
    public static final PathElement PATH$ScalingList16x16 = PathElement.groupElement("ScalingList16x16");
    public static final PathElement PATH$ScalingList32x32 = PathElement.groupElement("ScalingList32x32");
    public static final PathElement PATH$ScalingListDCCoef16x16 = PathElement.groupElement("ScalingListDCCoef16x16");
    public static final PathElement PATH$ScalingListDCCoef32x32 = PathElement.groupElement("ScalingListDCCoef32x32");

    public static final SequenceLayout LAYOUT$ScalingList4x4 = (SequenceLayout) LAYOUT.select(PATH$ScalingList4x4);
    public static final SequenceLayout LAYOUT$ScalingList8x8 = (SequenceLayout) LAYOUT.select(PATH$ScalingList8x8);
    public static final SequenceLayout LAYOUT$ScalingList16x16 = (SequenceLayout) LAYOUT.select(PATH$ScalingList16x16);
    public static final SequenceLayout LAYOUT$ScalingList32x32 = (SequenceLayout) LAYOUT.select(PATH$ScalingList32x32);
    public static final SequenceLayout LAYOUT$ScalingListDCCoef16x16 = (SequenceLayout) LAYOUT.select(PATH$ScalingListDCCoef16x16);
    public static final SequenceLayout LAYOUT$ScalingListDCCoef32x32 = (SequenceLayout) LAYOUT.select(PATH$ScalingListDCCoef32x32);

    public static final long SIZE$ScalingList4x4 = LAYOUT$ScalingList4x4.byteSize();
    public static final long SIZE$ScalingList8x8 = LAYOUT$ScalingList8x8.byteSize();
    public static final long SIZE$ScalingList16x16 = LAYOUT$ScalingList16x16.byteSize();
    public static final long SIZE$ScalingList32x32 = LAYOUT$ScalingList32x32.byteSize();
    public static final long SIZE$ScalingListDCCoef16x16 = LAYOUT$ScalingListDCCoef16x16.byteSize();
    public static final long SIZE$ScalingListDCCoef32x32 = LAYOUT$ScalingListDCCoef32x32.byteSize();

    public static final long OFFSET$ScalingList4x4 = LAYOUT.byteOffset(PATH$ScalingList4x4);
    public static final long OFFSET$ScalingList8x8 = LAYOUT.byteOffset(PATH$ScalingList8x8);
    public static final long OFFSET$ScalingList16x16 = LAYOUT.byteOffset(PATH$ScalingList16x16);
    public static final long OFFSET$ScalingList32x32 = LAYOUT.byteOffset(PATH$ScalingList32x32);
    public static final long OFFSET$ScalingListDCCoef16x16 = LAYOUT.byteOffset(PATH$ScalingListDCCoef16x16);
    public static final long OFFSET$ScalingListDCCoef32x32 = LAYOUT.byteOffset(PATH$ScalingListDCCoef32x32);
}
