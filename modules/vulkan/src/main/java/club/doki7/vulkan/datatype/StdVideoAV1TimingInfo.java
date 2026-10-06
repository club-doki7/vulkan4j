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

/// Represents a pointer to a {@code StdVideoAV1TimingInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoAV1TimingInfo {
///     StdVideoAV1TimingInfoFlags flags; // @link substring="StdVideoAV1TimingInfoFlags" target="StdVideoAV1TimingInfoFlags" @link substring="flags" target="#flags"
///     uint32_t num_units_in_display_tick; // @link substring="num_units_in_display_tick" target="#num_units_in_display_tick"
///     uint32_t time_scale; // @link substring="time_scale" target="#time_scale"
///     uint32_t num_ticks_per_picture_minus_1; // @link substring="num_ticks_per_picture_minus_1" target="#num_ticks_per_picture_minus_1"
/// } StdVideoAV1TimingInfo;
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
public record StdVideoAV1TimingInfo(@NotNull MemorySegment segment) implements IStdVideoAV1TimingInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoAV1TimingInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoAV1TimingInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoAV1TimingInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoAV1TimingInfo, Iterable<StdVideoAV1TimingInfo> {
        public long size() {
            return segment.byteSize() / StdVideoAV1TimingInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoAV1TimingInfo at(long index) {
            return new StdVideoAV1TimingInfo(segment.asSlice(index * StdVideoAV1TimingInfo.BYTES, StdVideoAV1TimingInfo.BYTES));
        }

        public StdVideoAV1TimingInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoAV1TimingInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoAV1TimingInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoAV1TimingInfo.BYTES, StdVideoAV1TimingInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoAV1TimingInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoAV1TimingInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoAV1TimingInfo.BYTES,
                (end - start) * StdVideoAV1TimingInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoAV1TimingInfo.BYTES));
        }

        public StdVideoAV1TimingInfo[] toArray() {
            StdVideoAV1TimingInfo[] ret = new StdVideoAV1TimingInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoAV1TimingInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoAV1TimingInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoAV1TimingInfo.BYTES;
            }

            @Override
            public StdVideoAV1TimingInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoAV1TimingInfo ret = new StdVideoAV1TimingInfo(segment.asSlice(0, StdVideoAV1TimingInfo.BYTES));
                segment = segment.asSlice(StdVideoAV1TimingInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoAV1TimingInfo allocate(Arena arena) {
        return new StdVideoAV1TimingInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoAV1TimingInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoAV1TimingInfo.Ptr(segment);
    }

    public static StdVideoAV1TimingInfo clone(Arena arena, StdVideoAV1TimingInfo src) {
        StdVideoAV1TimingInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoAV1TimingInfoFlags flags() {
        return new StdVideoAV1TimingInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoAV1TimingInfo flags(@NotNull StdVideoAV1TimingInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoAV1TimingInfo flags(Consumer<@NotNull StdVideoAV1TimingInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned int num_units_in_display_tick() {
        return segment.get(LAYOUT$num_units_in_display_tick, OFFSET$num_units_in_display_tick);
    }

    public StdVideoAV1TimingInfo num_units_in_display_tick(@Unsigned int value) {
        segment.set(LAYOUT$num_units_in_display_tick, OFFSET$num_units_in_display_tick, value);
        return this;
    }

    public @Unsigned int time_scale() {
        return segment.get(LAYOUT$time_scale, OFFSET$time_scale);
    }

    public StdVideoAV1TimingInfo time_scale(@Unsigned int value) {
        segment.set(LAYOUT$time_scale, OFFSET$time_scale, value);
        return this;
    }

    public @Unsigned int num_ticks_per_picture_minus_1() {
        return segment.get(LAYOUT$num_ticks_per_picture_minus_1, OFFSET$num_ticks_per_picture_minus_1);
    }

    public StdVideoAV1TimingInfo num_ticks_per_picture_minus_1(@Unsigned int value) {
        segment.set(LAYOUT$num_ticks_per_picture_minus_1, OFFSET$num_ticks_per_picture_minus_1, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoAV1TimingInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("num_units_in_display_tick"),
        ValueLayout.JAVA_INT.withName("time_scale"),
        ValueLayout.JAVA_INT.withName("num_ticks_per_picture_minus_1")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$num_units_in_display_tick = PathElement.groupElement("num_units_in_display_tick");
    public static final PathElement PATH$time_scale = PathElement.groupElement("time_scale");
    public static final PathElement PATH$num_ticks_per_picture_minus_1 = PathElement.groupElement("num_ticks_per_picture_minus_1");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$num_units_in_display_tick = (OfInt) LAYOUT.select(PATH$num_units_in_display_tick);
    public static final OfInt LAYOUT$time_scale = (OfInt) LAYOUT.select(PATH$time_scale);
    public static final OfInt LAYOUT$num_ticks_per_picture_minus_1 = (OfInt) LAYOUT.select(PATH$num_ticks_per_picture_minus_1);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$num_units_in_display_tick = LAYOUT$num_units_in_display_tick.byteSize();
    public static final long SIZE$time_scale = LAYOUT$time_scale.byteSize();
    public static final long SIZE$num_ticks_per_picture_minus_1 = LAYOUT$num_ticks_per_picture_minus_1.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$num_units_in_display_tick = LAYOUT.byteOffset(PATH$num_units_in_display_tick);
    public static final long OFFSET$time_scale = LAYOUT.byteOffset(PATH$time_scale);
    public static final long OFFSET$num_ticks_per_picture_minus_1 = LAYOUT.byteOffset(PATH$num_ticks_per_picture_minus_1);
}
