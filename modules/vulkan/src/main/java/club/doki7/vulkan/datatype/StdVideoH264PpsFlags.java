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
import club.doki7.ffm.bits.BitfieldUtil;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.handle.*;
import club.doki7.vulkan.enumtype.*;
import static club.doki7.vulkan.VkConstants.*;
import club.doki7.vulkan.VkFunctionTypes.*;

/// Represents a pointer to a {@code StdVideoH264PpsFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH264PpsFlags {
///     uint32_t transform_8x8_mode_flag : 1; // @link substring="transform_8x8_mode_flag" target="#transform_8x8_mode_flag"
///     uint32_t redundant_pic_cnt_present_flag : 1; // @link substring="redundant_pic_cnt_present_flag" target="#redundant_pic_cnt_present_flag"
///     uint32_t constrained_intra_pred_flag : 1; // @link substring="constrained_intra_pred_flag" target="#constrained_intra_pred_flag"
///     uint32_t deblocking_filter_control_present_flag : 1; // @link substring="deblocking_filter_control_present_flag" target="#deblocking_filter_control_present_flag"
///     uint32_t weighted_pred_flag : 1; // @link substring="weighted_pred_flag" target="#weighted_pred_flag"
///     uint32_t bottom_field_pic_order_in_frame_present_flag : 1; // @link substring="bottom_field_pic_order_in_frame_present_flag" target="#bottom_field_pic_order_in_frame_present_flag"
///     uint32_t entropy_coding_mode_flag : 1; // @link substring="entropy_coding_mode_flag" target="#entropy_coding_mode_flag"
///     uint32_t pic_scaling_matrix_present_flag : 1; // @link substring="pic_scaling_matrix_present_flag" target="#pic_scaling_matrix_present_flag"
/// } StdVideoH264PpsFlags;
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
public record StdVideoH264PpsFlags(@NotNull MemorySegment segment) implements IStdVideoH264PpsFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH264PpsFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH264PpsFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH264PpsFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH264PpsFlags, Iterable<StdVideoH264PpsFlags> {
        public long size() {
            return segment.byteSize() / StdVideoH264PpsFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH264PpsFlags at(long index) {
            return new StdVideoH264PpsFlags(segment.asSlice(index * StdVideoH264PpsFlags.BYTES, StdVideoH264PpsFlags.BYTES));
        }

        public StdVideoH264PpsFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH264PpsFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH264PpsFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoH264PpsFlags.BYTES, StdVideoH264PpsFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH264PpsFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH264PpsFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH264PpsFlags.BYTES,
                (end - start) * StdVideoH264PpsFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH264PpsFlags.BYTES));
        }

        public StdVideoH264PpsFlags[] toArray() {
            StdVideoH264PpsFlags[] ret = new StdVideoH264PpsFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH264PpsFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH264PpsFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH264PpsFlags.BYTES;
            }

            @Override
            public StdVideoH264PpsFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH264PpsFlags ret = new StdVideoH264PpsFlags(segment.asSlice(0, StdVideoH264PpsFlags.BYTES));
                segment = segment.asSlice(StdVideoH264PpsFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH264PpsFlags allocate(Arena arena) {
        return new StdVideoH264PpsFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoH264PpsFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH264PpsFlags.Ptr(segment);
    }

    public static StdVideoH264PpsFlags clone(Arena arena, StdVideoH264PpsFlags src) {
        StdVideoH264PpsFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean transform_8x8_mode_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoH264PpsFlags transform_8x8_mode_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean redundant_pic_cnt_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoH264PpsFlags redundant_pic_cnt_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean constrained_intra_pred_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoH264PpsFlags constrained_intra_pred_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean deblocking_filter_control_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoH264PpsFlags deblocking_filter_control_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public boolean weighted_pred_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        return BitfieldUtil.readBit(s, 4);
    }

    public StdVideoH264PpsFlags weighted_pred_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        BitfieldUtil.writeBit(s, 4, value);
        return this;
    }

    public boolean bottom_field_pic_order_in_frame_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        return BitfieldUtil.readBit(s, 5);
    }

    public StdVideoH264PpsFlags bottom_field_pic_order_in_frame_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        BitfieldUtil.writeBit(s, 5, value);
        return this;
    }

    public boolean entropy_coding_mode_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        return BitfieldUtil.readBit(s, 6);
    }

    public StdVideoH264PpsFlags entropy_coding_mode_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        BitfieldUtil.writeBit(s, 6, value);
        return this;
    }

    public boolean pic_scaling_matrix_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        return BitfieldUtil.readBit(s, 7);
    }

    public StdVideoH264PpsFlags pic_scaling_matrix_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag, LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
        BitfieldUtil.writeBit(s, 7, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag = PathElement.groupElement("transform_8x8_mode_flag$pic_scaling_matrix_present_flag");

    public static final OfInt LAYOUT$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag = (OfInt) LAYOUT.select(PATH$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);


    public static final long OFFSET$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag = LAYOUT.byteOffset(PATH$bitfield$transform_8x8_mode_flag$pic_scaling_matrix_present_flag);
}
