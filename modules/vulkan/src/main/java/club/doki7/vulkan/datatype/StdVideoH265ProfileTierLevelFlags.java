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

/// Represents a pointer to a {@code StdVideoH265ProfileTierLevelFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265ProfileTierLevelFlags {
///     uint32_t general_tier_flag : 1; // @link substring="general_tier_flag" target="#general_tier_flag"
///     uint32_t general_progressive_source_flag : 1; // @link substring="general_progressive_source_flag" target="#general_progressive_source_flag"
///     uint32_t general_interlaced_source_flag : 1; // @link substring="general_interlaced_source_flag" target="#general_interlaced_source_flag"
///     uint32_t general_non_packed_constraint_flag : 1; // @link substring="general_non_packed_constraint_flag" target="#general_non_packed_constraint_flag"
///     uint32_t general_frame_only_constraint_flag : 1; // @link substring="general_frame_only_constraint_flag" target="#general_frame_only_constraint_flag"
/// } StdVideoH265ProfileTierLevelFlags;
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
public record StdVideoH265ProfileTierLevelFlags(@NotNull MemorySegment segment) implements IStdVideoH265ProfileTierLevelFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265ProfileTierLevelFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265ProfileTierLevelFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265ProfileTierLevelFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265ProfileTierLevelFlags, Iterable<StdVideoH265ProfileTierLevelFlags> {
        public long size() {
            return segment.byteSize() / StdVideoH265ProfileTierLevelFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265ProfileTierLevelFlags at(long index) {
            return new StdVideoH265ProfileTierLevelFlags(segment.asSlice(index * StdVideoH265ProfileTierLevelFlags.BYTES, StdVideoH265ProfileTierLevelFlags.BYTES));
        }

        public StdVideoH265ProfileTierLevelFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265ProfileTierLevelFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265ProfileTierLevelFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265ProfileTierLevelFlags.BYTES, StdVideoH265ProfileTierLevelFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265ProfileTierLevelFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265ProfileTierLevelFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265ProfileTierLevelFlags.BYTES,
                (end - start) * StdVideoH265ProfileTierLevelFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265ProfileTierLevelFlags.BYTES));
        }

        public StdVideoH265ProfileTierLevelFlags[] toArray() {
            StdVideoH265ProfileTierLevelFlags[] ret = new StdVideoH265ProfileTierLevelFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265ProfileTierLevelFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265ProfileTierLevelFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265ProfileTierLevelFlags.BYTES;
            }

            @Override
            public StdVideoH265ProfileTierLevelFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265ProfileTierLevelFlags ret = new StdVideoH265ProfileTierLevelFlags(segment.asSlice(0, StdVideoH265ProfileTierLevelFlags.BYTES));
                segment = segment.asSlice(StdVideoH265ProfileTierLevelFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265ProfileTierLevelFlags allocate(Arena arena) {
        return new StdVideoH265ProfileTierLevelFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoH265ProfileTierLevelFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265ProfileTierLevelFlags.Ptr(segment);
    }

    public static StdVideoH265ProfileTierLevelFlags clone(Arena arena, StdVideoH265ProfileTierLevelFlags src) {
        StdVideoH265ProfileTierLevelFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean general_tier_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$general_tier_flag$general_frame_only_constraint_flag, LAYOUT$bitfield$general_tier_flag$general_frame_only_constraint_flag);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoH265ProfileTierLevelFlags general_tier_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$general_tier_flag$general_frame_only_constraint_flag, LAYOUT$bitfield$general_tier_flag$general_frame_only_constraint_flag);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean general_progressive_source_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$general_tier_flag$general_frame_only_constraint_flag, LAYOUT$bitfield$general_tier_flag$general_frame_only_constraint_flag);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoH265ProfileTierLevelFlags general_progressive_source_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$general_tier_flag$general_frame_only_constraint_flag, LAYOUT$bitfield$general_tier_flag$general_frame_only_constraint_flag);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean general_interlaced_source_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$general_tier_flag$general_frame_only_constraint_flag, LAYOUT$bitfield$general_tier_flag$general_frame_only_constraint_flag);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoH265ProfileTierLevelFlags general_interlaced_source_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$general_tier_flag$general_frame_only_constraint_flag, LAYOUT$bitfield$general_tier_flag$general_frame_only_constraint_flag);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean general_non_packed_constraint_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$general_tier_flag$general_frame_only_constraint_flag, LAYOUT$bitfield$general_tier_flag$general_frame_only_constraint_flag);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoH265ProfileTierLevelFlags general_non_packed_constraint_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$general_tier_flag$general_frame_only_constraint_flag, LAYOUT$bitfield$general_tier_flag$general_frame_only_constraint_flag);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public boolean general_frame_only_constraint_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$general_tier_flag$general_frame_only_constraint_flag, LAYOUT$bitfield$general_tier_flag$general_frame_only_constraint_flag);
        return BitfieldUtil.readBit(s, 4);
    }

    public StdVideoH265ProfileTierLevelFlags general_frame_only_constraint_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$general_tier_flag$general_frame_only_constraint_flag, LAYOUT$bitfield$general_tier_flag$general_frame_only_constraint_flag);
        BitfieldUtil.writeBit(s, 4, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$general_tier_flag$general_frame_only_constraint_flag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$general_tier_flag$general_frame_only_constraint_flag = PathElement.groupElement("general_tier_flag$general_frame_only_constraint_flag");

    public static final OfInt LAYOUT$bitfield$general_tier_flag$general_frame_only_constraint_flag = (OfInt) LAYOUT.select(PATH$bitfield$general_tier_flag$general_frame_only_constraint_flag);


    public static final long OFFSET$bitfield$general_tier_flag$general_frame_only_constraint_flag = LAYOUT.byteOffset(PATH$bitfield$general_tier_flag$general_frame_only_constraint_flag);
}
