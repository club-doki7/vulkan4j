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

/// Represents a pointer to a {@code StdVideoH265HrdFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265HrdFlags {
///     uint32_t nal_hrd_parameters_present_flag : 1; // @link substring="nal_hrd_parameters_present_flag" target="#nal_hrd_parameters_present_flag"
///     uint32_t vcl_hrd_parameters_present_flag : 1; // @link substring="vcl_hrd_parameters_present_flag" target="#vcl_hrd_parameters_present_flag"
///     uint32_t sub_pic_hrd_params_present_flag : 1; // @link substring="sub_pic_hrd_params_present_flag" target="#sub_pic_hrd_params_present_flag"
///     uint32_t sub_pic_cpb_params_in_pic_timing_sei_flag : 1; // @link substring="sub_pic_cpb_params_in_pic_timing_sei_flag" target="#sub_pic_cpb_params_in_pic_timing_sei_flag"
///     uint32_t fixed_pic_rate_general_flag : 8; // @link substring="fixed_pic_rate_general_flag" target="#fixed_pic_rate_general_flag"
///     uint32_t fixed_pic_rate_within_cvs_flag : 8; // @link substring="fixed_pic_rate_within_cvs_flag" target="#fixed_pic_rate_within_cvs_flag"
///     uint32_t low_delay_hrd_flag : 8; // @link substring="low_delay_hrd_flag" target="#low_delay_hrd_flag"
/// } StdVideoH265HrdFlags;
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
public record StdVideoH265HrdFlags(@NotNull MemorySegment segment) implements IStdVideoH265HrdFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265HrdFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265HrdFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265HrdFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265HrdFlags, Iterable<StdVideoH265HrdFlags> {
        public long size() {
            return segment.byteSize() / StdVideoH265HrdFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265HrdFlags at(long index) {
            return new StdVideoH265HrdFlags(segment.asSlice(index * StdVideoH265HrdFlags.BYTES, StdVideoH265HrdFlags.BYTES));
        }

        public StdVideoH265HrdFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265HrdFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265HrdFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265HrdFlags.BYTES, StdVideoH265HrdFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265HrdFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265HrdFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265HrdFlags.BYTES,
                (end - start) * StdVideoH265HrdFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265HrdFlags.BYTES));
        }

        public StdVideoH265HrdFlags[] toArray() {
            StdVideoH265HrdFlags[] ret = new StdVideoH265HrdFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265HrdFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265HrdFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265HrdFlags.BYTES;
            }

            @Override
            public StdVideoH265HrdFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265HrdFlags ret = new StdVideoH265HrdFlags(segment.asSlice(0, StdVideoH265HrdFlags.BYTES));
                segment = segment.asSlice(StdVideoH265HrdFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265HrdFlags allocate(Arena arena) {
        return new StdVideoH265HrdFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoH265HrdFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265HrdFlags.Ptr(segment);
    }

    public static StdVideoH265HrdFlags clone(Arena arena, StdVideoH265HrdFlags src) {
        StdVideoH265HrdFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean nal_hrd_parameters_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoH265HrdFlags nal_hrd_parameters_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean vcl_hrd_parameters_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoH265HrdFlags vcl_hrd_parameters_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean sub_pic_hrd_params_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoH265HrdFlags sub_pic_hrd_params_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean sub_pic_cpb_params_in_pic_timing_sei_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoH265HrdFlags sub_pic_cpb_params_in_pic_timing_sei_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public @Unsigned int fixed_pic_rate_general_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        return BitfieldUtil.readBits(s, 4, 12);
    }

    public StdVideoH265HrdFlags fixed_pic_rate_general_flag(@Unsigned int value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        BitfieldUtil.writeBits(s, 4, 12, value);
        return this;
    }

    public @Unsigned int fixed_pic_rate_within_cvs_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        return BitfieldUtil.readBits(s, 12, 20);
    }

    public StdVideoH265HrdFlags fixed_pic_rate_within_cvs_flag(@Unsigned int value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        BitfieldUtil.writeBits(s, 12, 20, value);
        return this;
    }

    public @Unsigned int low_delay_hrd_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        return BitfieldUtil.readBits(s, 20, 28);
    }

    public StdVideoH265HrdFlags low_delay_hrd_flag(@Unsigned int value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag, LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
        BitfieldUtil.writeBits(s, 20, 28, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag = PathElement.groupElement("nal_hrd_parameters_present_flag$low_delay_hrd_flag");

    public static final OfInt LAYOUT$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag = (OfInt) LAYOUT.select(PATH$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);


    public static final long OFFSET$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag = LAYOUT.byteOffset(PATH$bitfield$nal_hrd_parameters_present_flag$low_delay_hrd_flag);
}
