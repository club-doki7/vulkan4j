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

/// Represents a pointer to a {@code StdVideoVP9ColorConfig} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoVP9ColorConfig {
///     StdVideoVP9ColorConfigFlags flags; // @link substring="StdVideoVP9ColorConfigFlags" target="StdVideoVP9ColorConfigFlags" @link substring="flags" target="#flags"
///     uint8_t BitDepth; // @link substring="BitDepth" target="#BitDepth"
///     uint8_t subsampling_x; // @link substring="subsampling_x" target="#subsampling_x"
///     uint8_t subsampling_y; // @link substring="subsampling_y" target="#subsampling_y"
///     uint8_t reserved1;
///     StdVideoVP9ColorSpace color_space; // @link substring="StdVideoVP9ColorSpace" target="StdVideoVP9ColorSpace" @link substring="color_space" target="#color_space"
/// } StdVideoVP9ColorConfig;
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
public record StdVideoVP9ColorConfig(@NotNull MemorySegment segment) implements IStdVideoVP9ColorConfig {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoVP9ColorConfig}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoVP9ColorConfig to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoVP9ColorConfig.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoVP9ColorConfig, Iterable<StdVideoVP9ColorConfig> {
        public long size() {
            return segment.byteSize() / StdVideoVP9ColorConfig.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoVP9ColorConfig at(long index) {
            return new StdVideoVP9ColorConfig(segment.asSlice(index * StdVideoVP9ColorConfig.BYTES, StdVideoVP9ColorConfig.BYTES));
        }

        public StdVideoVP9ColorConfig.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoVP9ColorConfig> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoVP9ColorConfig value) {
            MemorySegment s = segment.asSlice(index * StdVideoVP9ColorConfig.BYTES, StdVideoVP9ColorConfig.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoVP9ColorConfig.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoVP9ColorConfig.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoVP9ColorConfig.BYTES,
                (end - start) * StdVideoVP9ColorConfig.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoVP9ColorConfig.BYTES));
        }

        public StdVideoVP9ColorConfig[] toArray() {
            StdVideoVP9ColorConfig[] ret = new StdVideoVP9ColorConfig[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoVP9ColorConfig> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoVP9ColorConfig> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoVP9ColorConfig.BYTES;
            }

            @Override
            public StdVideoVP9ColorConfig next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoVP9ColorConfig ret = new StdVideoVP9ColorConfig(segment.asSlice(0, StdVideoVP9ColorConfig.BYTES));
                segment = segment.asSlice(StdVideoVP9ColorConfig.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoVP9ColorConfig allocate(Arena arena) {
        return new StdVideoVP9ColorConfig(arena.allocate(LAYOUT));
    }

    public static StdVideoVP9ColorConfig.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoVP9ColorConfig.Ptr(segment);
    }

    public static StdVideoVP9ColorConfig clone(Arena arena, StdVideoVP9ColorConfig src) {
        StdVideoVP9ColorConfig ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoVP9ColorConfigFlags flags() {
        return new StdVideoVP9ColorConfigFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoVP9ColorConfig flags(@NotNull StdVideoVP9ColorConfigFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoVP9ColorConfig flags(Consumer<@NotNull StdVideoVP9ColorConfigFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte BitDepth() {
        return segment.get(LAYOUT$BitDepth, OFFSET$BitDepth);
    }

    public StdVideoVP9ColorConfig BitDepth(@Unsigned byte value) {
        segment.set(LAYOUT$BitDepth, OFFSET$BitDepth, value);
        return this;
    }

    public @Unsigned byte subsampling_x() {
        return segment.get(LAYOUT$subsampling_x, OFFSET$subsampling_x);
    }

    public StdVideoVP9ColorConfig subsampling_x(@Unsigned byte value) {
        segment.set(LAYOUT$subsampling_x, OFFSET$subsampling_x, value);
        return this;
    }

    public @Unsigned byte subsampling_y() {
        return segment.get(LAYOUT$subsampling_y, OFFSET$subsampling_y);
    }

    public StdVideoVP9ColorConfig subsampling_y(@Unsigned byte value) {
        segment.set(LAYOUT$subsampling_y, OFFSET$subsampling_y, value);
        return this;
    }


    public @EnumType(StdVideoVP9ColorSpace.class) int color_space() {
        return segment.get(LAYOUT$color_space, OFFSET$color_space);
    }

    public StdVideoVP9ColorConfig color_space(@EnumType(StdVideoVP9ColorSpace.class) int value) {
        segment.set(LAYOUT$color_space, OFFSET$color_space, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoVP9ColorConfigFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("BitDepth"),
        ValueLayout.JAVA_BYTE.withName("subsampling_x"),
        ValueLayout.JAVA_BYTE.withName("subsampling_y"),
        ValueLayout.JAVA_BYTE.withName("reserved1"),
        ValueLayout.JAVA_INT.withName("color_space")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$BitDepth = PathElement.groupElement("BitDepth");
    public static final PathElement PATH$subsampling_x = PathElement.groupElement("subsampling_x");
    public static final PathElement PATH$subsampling_y = PathElement.groupElement("subsampling_y");
    public static final PathElement PATH$color_space = PathElement.groupElement("color_space");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$BitDepth = (OfByte) LAYOUT.select(PATH$BitDepth);
    public static final OfByte LAYOUT$subsampling_x = (OfByte) LAYOUT.select(PATH$subsampling_x);
    public static final OfByte LAYOUT$subsampling_y = (OfByte) LAYOUT.select(PATH$subsampling_y);
    public static final OfInt LAYOUT$color_space = (OfInt) LAYOUT.select(PATH$color_space);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$BitDepth = LAYOUT$BitDepth.byteSize();
    public static final long SIZE$subsampling_x = LAYOUT$subsampling_x.byteSize();
    public static final long SIZE$subsampling_y = LAYOUT$subsampling_y.byteSize();
    public static final long SIZE$color_space = LAYOUT$color_space.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$BitDepth = LAYOUT.byteOffset(PATH$BitDepth);
    public static final long OFFSET$subsampling_x = LAYOUT.byteOffset(PATH$subsampling_x);
    public static final long OFFSET$subsampling_y = LAYOUT.byteOffset(PATH$subsampling_y);
    public static final long OFFSET$color_space = LAYOUT.byteOffset(PATH$color_space);
}
