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

/// Represents a pointer to a {@code StdVideoH265VpsFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265VpsFlags {
///     uint32_t vps_temporal_id_nesting_flag : 1; // @link substring="vps_temporal_id_nesting_flag" target="#vps_temporal_id_nesting_flag"
///     uint32_t vps_sub_layer_ordering_info_present_flag : 1; // @link substring="vps_sub_layer_ordering_info_present_flag" target="#vps_sub_layer_ordering_info_present_flag"
///     uint32_t vps_timing_info_present_flag : 1; // @link substring="vps_timing_info_present_flag" target="#vps_timing_info_present_flag"
///     uint32_t vps_poc_proportional_to_timing_flag : 1; // @link substring="vps_poc_proportional_to_timing_flag" target="#vps_poc_proportional_to_timing_flag"
/// } StdVideoH265VpsFlags;
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
public record StdVideoH265VpsFlags(@NotNull MemorySegment segment) implements IStdVideoH265VpsFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265VpsFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265VpsFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265VpsFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265VpsFlags, Iterable<StdVideoH265VpsFlags> {
        public long size() {
            return segment.byteSize() / StdVideoH265VpsFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265VpsFlags at(long index) {
            return new StdVideoH265VpsFlags(segment.asSlice(index * StdVideoH265VpsFlags.BYTES, StdVideoH265VpsFlags.BYTES));
        }

        public StdVideoH265VpsFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265VpsFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265VpsFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265VpsFlags.BYTES, StdVideoH265VpsFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265VpsFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265VpsFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265VpsFlags.BYTES,
                (end - start) * StdVideoH265VpsFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265VpsFlags.BYTES));
        }

        public StdVideoH265VpsFlags[] toArray() {
            StdVideoH265VpsFlags[] ret = new StdVideoH265VpsFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265VpsFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265VpsFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265VpsFlags.BYTES;
            }

            @Override
            public StdVideoH265VpsFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265VpsFlags ret = new StdVideoH265VpsFlags(segment.asSlice(0, StdVideoH265VpsFlags.BYTES));
                segment = segment.asSlice(StdVideoH265VpsFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265VpsFlags allocate(Arena arena) {
        return new StdVideoH265VpsFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoH265VpsFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265VpsFlags.Ptr(segment);
    }

    public static StdVideoH265VpsFlags clone(Arena arena, StdVideoH265VpsFlags src) {
        StdVideoH265VpsFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean vps_temporal_id_nesting_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag, LAYOUT$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoH265VpsFlags vps_temporal_id_nesting_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag, LAYOUT$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean vps_sub_layer_ordering_info_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag, LAYOUT$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoH265VpsFlags vps_sub_layer_ordering_info_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag, LAYOUT$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean vps_timing_info_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag, LAYOUT$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoH265VpsFlags vps_timing_info_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag, LAYOUT$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean vps_poc_proportional_to_timing_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag, LAYOUT$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoH265VpsFlags vps_poc_proportional_to_timing_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag, LAYOUT$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag = PathElement.groupElement("vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag");

    public static final OfInt LAYOUT$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag = (OfInt) LAYOUT.select(PATH$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag);


    public static final long OFFSET$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag = LAYOUT.byteOffset(PATH$bitfield$vps_temporal_id_nesting_flag$vps_poc_proportional_to_timing_flag);
}
