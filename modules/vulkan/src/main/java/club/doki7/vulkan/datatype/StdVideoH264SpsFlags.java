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

/// Represents a pointer to a {@code StdVideoH264SpsFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH264SpsFlags {
///     uint32_t constraint_set0_flag : 1; // @link substring="constraint_set0_flag" target="#constraint_set0_flag"
///     uint32_t constraint_set1_flag : 1; // @link substring="constraint_set1_flag" target="#constraint_set1_flag"
///     uint32_t constraint_set2_flag : 1; // @link substring="constraint_set2_flag" target="#constraint_set2_flag"
///     uint32_t constraint_set3_flag : 1; // @link substring="constraint_set3_flag" target="#constraint_set3_flag"
///     uint32_t constraint_set4_flag : 1; // @link substring="constraint_set4_flag" target="#constraint_set4_flag"
///     uint32_t constraint_set5_flag : 1; // @link substring="constraint_set5_flag" target="#constraint_set5_flag"
///     uint32_t direct_8x8_inference_flag : 1; // @link substring="direct_8x8_inference_flag" target="#direct_8x8_inference_flag"
///     uint32_t mb_adaptive_frame_field_flag : 1; // @link substring="mb_adaptive_frame_field_flag" target="#mb_adaptive_frame_field_flag"
///     uint32_t frame_mbs_only_flag : 1; // @link substring="frame_mbs_only_flag" target="#frame_mbs_only_flag"
///     uint32_t delta_pic_order_always_zero_flag : 1; // @link substring="delta_pic_order_always_zero_flag" target="#delta_pic_order_always_zero_flag"
///     uint32_t separate_colour_plane_flag : 1; // @link substring="separate_colour_plane_flag" target="#separate_colour_plane_flag"
///     uint32_t gaps_in_frame_num_value_allowed_flag : 1; // @link substring="gaps_in_frame_num_value_allowed_flag" target="#gaps_in_frame_num_value_allowed_flag"
///     uint32_t qpprime_y_zero_transform_bypass_flag : 1; // @link substring="qpprime_y_zero_transform_bypass_flag" target="#qpprime_y_zero_transform_bypass_flag"
///     uint32_t frame_cropping_flag : 1; // @link substring="frame_cropping_flag" target="#frame_cropping_flag"
///     uint32_t seq_scaling_matrix_present_flag : 1; // @link substring="seq_scaling_matrix_present_flag" target="#seq_scaling_matrix_present_flag"
///     uint32_t vui_parameters_present_flag : 1; // @link substring="vui_parameters_present_flag" target="#vui_parameters_present_flag"
/// } StdVideoH264SpsFlags;
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
public record StdVideoH264SpsFlags(@NotNull MemorySegment segment) implements IStdVideoH264SpsFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH264SpsFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH264SpsFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH264SpsFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH264SpsFlags, Iterable<StdVideoH264SpsFlags> {
        public long size() {
            return segment.byteSize() / StdVideoH264SpsFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH264SpsFlags at(long index) {
            return new StdVideoH264SpsFlags(segment.asSlice(index * StdVideoH264SpsFlags.BYTES, StdVideoH264SpsFlags.BYTES));
        }

        public StdVideoH264SpsFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH264SpsFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH264SpsFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoH264SpsFlags.BYTES, StdVideoH264SpsFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH264SpsFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH264SpsFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH264SpsFlags.BYTES,
                (end - start) * StdVideoH264SpsFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH264SpsFlags.BYTES));
        }

        public StdVideoH264SpsFlags[] toArray() {
            StdVideoH264SpsFlags[] ret = new StdVideoH264SpsFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH264SpsFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH264SpsFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH264SpsFlags.BYTES;
            }

            @Override
            public StdVideoH264SpsFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH264SpsFlags ret = new StdVideoH264SpsFlags(segment.asSlice(0, StdVideoH264SpsFlags.BYTES));
                segment = segment.asSlice(StdVideoH264SpsFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH264SpsFlags allocate(Arena arena) {
        return new StdVideoH264SpsFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoH264SpsFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH264SpsFlags.Ptr(segment);
    }

    public static StdVideoH264SpsFlags clone(Arena arena, StdVideoH264SpsFlags src) {
        StdVideoH264SpsFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean constraint_set0_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoH264SpsFlags constraint_set0_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean constraint_set1_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoH264SpsFlags constraint_set1_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean constraint_set2_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoH264SpsFlags constraint_set2_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean constraint_set3_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoH264SpsFlags constraint_set3_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public boolean constraint_set4_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 4);
    }

    public StdVideoH264SpsFlags constraint_set4_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 4, value);
        return this;
    }

    public boolean constraint_set5_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 5);
    }

    public StdVideoH264SpsFlags constraint_set5_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 5, value);
        return this;
    }

    public boolean direct_8x8_inference_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 6);
    }

    public StdVideoH264SpsFlags direct_8x8_inference_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 6, value);
        return this;
    }

    public boolean mb_adaptive_frame_field_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 7);
    }

    public StdVideoH264SpsFlags mb_adaptive_frame_field_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 7, value);
        return this;
    }

    public boolean frame_mbs_only_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 8);
    }

    public StdVideoH264SpsFlags frame_mbs_only_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 8, value);
        return this;
    }

    public boolean delta_pic_order_always_zero_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 9);
    }

    public StdVideoH264SpsFlags delta_pic_order_always_zero_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 9, value);
        return this;
    }

    public boolean separate_colour_plane_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 10);
    }

    public StdVideoH264SpsFlags separate_colour_plane_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 10, value);
        return this;
    }

    public boolean gaps_in_frame_num_value_allowed_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 11);
    }

    public StdVideoH264SpsFlags gaps_in_frame_num_value_allowed_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 11, value);
        return this;
    }

    public boolean qpprime_y_zero_transform_bypass_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 12);
    }

    public StdVideoH264SpsFlags qpprime_y_zero_transform_bypass_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 12, value);
        return this;
    }

    public boolean frame_cropping_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 13);
    }

    public StdVideoH264SpsFlags frame_cropping_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 13, value);
        return this;
    }

    public boolean seq_scaling_matrix_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 14);
    }

    public StdVideoH264SpsFlags seq_scaling_matrix_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 14, value);
        return this;
    }

    public boolean vui_parameters_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        return BitfieldUtil.readBit(s, 15);
    }

    public StdVideoH264SpsFlags vui_parameters_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag, LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag);
        BitfieldUtil.writeBit(s, 15, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$constraint_set0_flag$vui_parameters_present_flag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$constraint_set0_flag$vui_parameters_present_flag = PathElement.groupElement("constraint_set0_flag$vui_parameters_present_flag");

    public static final OfInt LAYOUT$bitfield$constraint_set0_flag$vui_parameters_present_flag = (OfInt) LAYOUT.select(PATH$bitfield$constraint_set0_flag$vui_parameters_present_flag);


    public static final long OFFSET$bitfield$constraint_set0_flag$vui_parameters_present_flag = LAYOUT.byteOffset(PATH$bitfield$constraint_set0_flag$vui_parameters_present_flag);
}
