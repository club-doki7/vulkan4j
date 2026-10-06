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

/// Represents a pointer to a {@code StdVideoH264SpsVuiFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH264SpsVuiFlags {
///     uint32_t aspect_ratio_info_present_flag : 1; // @link substring="aspect_ratio_info_present_flag" target="#aspect_ratio_info_present_flag"
///     uint32_t overscan_info_present_flag : 1; // @link substring="overscan_info_present_flag" target="#overscan_info_present_flag"
///     uint32_t overscan_appropriate_flag : 1; // @link substring="overscan_appropriate_flag" target="#overscan_appropriate_flag"
///     uint32_t video_signal_type_present_flag : 1; // @link substring="video_signal_type_present_flag" target="#video_signal_type_present_flag"
///     uint32_t video_full_range_flag : 1; // @link substring="video_full_range_flag" target="#video_full_range_flag"
///     uint32_t color_description_present_flag : 1; // @link substring="color_description_present_flag" target="#color_description_present_flag"
///     uint32_t chroma_loc_info_present_flag : 1; // @link substring="chroma_loc_info_present_flag" target="#chroma_loc_info_present_flag"
///     uint32_t timing_info_present_flag : 1; // @link substring="timing_info_present_flag" target="#timing_info_present_flag"
///     uint32_t fixed_frame_rate_flag : 1; // @link substring="fixed_frame_rate_flag" target="#fixed_frame_rate_flag"
///     uint32_t bitstream_restriction_flag : 1; // @link substring="bitstream_restriction_flag" target="#bitstream_restriction_flag"
///     uint32_t nal_hrd_parameters_present_flag : 1; // @link substring="nal_hrd_parameters_present_flag" target="#nal_hrd_parameters_present_flag"
///     uint32_t vcl_hrd_parameters_present_flag : 1; // @link substring="vcl_hrd_parameters_present_flag" target="#vcl_hrd_parameters_present_flag"
/// } StdVideoH264SpsVuiFlags;
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
public record StdVideoH264SpsVuiFlags(@NotNull MemorySegment segment) implements IStdVideoH264SpsVuiFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH264SpsVuiFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH264SpsVuiFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH264SpsVuiFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH264SpsVuiFlags, Iterable<StdVideoH264SpsVuiFlags> {
        public long size() {
            return segment.byteSize() / StdVideoH264SpsVuiFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH264SpsVuiFlags at(long index) {
            return new StdVideoH264SpsVuiFlags(segment.asSlice(index * StdVideoH264SpsVuiFlags.BYTES, StdVideoH264SpsVuiFlags.BYTES));
        }

        public StdVideoH264SpsVuiFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH264SpsVuiFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH264SpsVuiFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoH264SpsVuiFlags.BYTES, StdVideoH264SpsVuiFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH264SpsVuiFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH264SpsVuiFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH264SpsVuiFlags.BYTES,
                (end - start) * StdVideoH264SpsVuiFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH264SpsVuiFlags.BYTES));
        }

        public StdVideoH264SpsVuiFlags[] toArray() {
            StdVideoH264SpsVuiFlags[] ret = new StdVideoH264SpsVuiFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH264SpsVuiFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH264SpsVuiFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH264SpsVuiFlags.BYTES;
            }

            @Override
            public StdVideoH264SpsVuiFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH264SpsVuiFlags ret = new StdVideoH264SpsVuiFlags(segment.asSlice(0, StdVideoH264SpsVuiFlags.BYTES));
                segment = segment.asSlice(StdVideoH264SpsVuiFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH264SpsVuiFlags allocate(Arena arena) {
        return new StdVideoH264SpsVuiFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoH264SpsVuiFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH264SpsVuiFlags.Ptr(segment);
    }

    public static StdVideoH264SpsVuiFlags clone(Arena arena, StdVideoH264SpsVuiFlags src) {
        StdVideoH264SpsVuiFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean aspect_ratio_info_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoH264SpsVuiFlags aspect_ratio_info_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean overscan_info_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoH264SpsVuiFlags overscan_info_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean overscan_appropriate_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoH264SpsVuiFlags overscan_appropriate_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean video_signal_type_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoH264SpsVuiFlags video_signal_type_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public boolean video_full_range_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        return BitfieldUtil.readBit(s, 4);
    }

    public StdVideoH264SpsVuiFlags video_full_range_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        BitfieldUtil.writeBit(s, 4, value);
        return this;
    }

    public boolean color_description_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        return BitfieldUtil.readBit(s, 5);
    }

    public StdVideoH264SpsVuiFlags color_description_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        BitfieldUtil.writeBit(s, 5, value);
        return this;
    }

    public boolean chroma_loc_info_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        return BitfieldUtil.readBit(s, 6);
    }

    public StdVideoH264SpsVuiFlags chroma_loc_info_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        BitfieldUtil.writeBit(s, 6, value);
        return this;
    }

    public boolean timing_info_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        return BitfieldUtil.readBit(s, 7);
    }

    public StdVideoH264SpsVuiFlags timing_info_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        BitfieldUtil.writeBit(s, 7, value);
        return this;
    }

    public boolean fixed_frame_rate_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        return BitfieldUtil.readBit(s, 8);
    }

    public StdVideoH264SpsVuiFlags fixed_frame_rate_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        BitfieldUtil.writeBit(s, 8, value);
        return this;
    }

    public boolean bitstream_restriction_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        return BitfieldUtil.readBit(s, 9);
    }

    public StdVideoH264SpsVuiFlags bitstream_restriction_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        BitfieldUtil.writeBit(s, 9, value);
        return this;
    }

    public boolean nal_hrd_parameters_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        return BitfieldUtil.readBit(s, 10);
    }

    public StdVideoH264SpsVuiFlags nal_hrd_parameters_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        BitfieldUtil.writeBit(s, 10, value);
        return this;
    }

    public boolean vcl_hrd_parameters_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        return BitfieldUtil.readBit(s, 11);
    }

    public StdVideoH264SpsVuiFlags vcl_hrd_parameters_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag, LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
        BitfieldUtil.writeBit(s, 11, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag = PathElement.groupElement("aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag");

    public static final OfInt LAYOUT$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag = (OfInt) LAYOUT.select(PATH$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);


    public static final long OFFSET$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag = LAYOUT.byteOffset(PATH$bitfield$aspect_ratio_info_present_flag$vcl_hrd_parameters_present_flag);
}
