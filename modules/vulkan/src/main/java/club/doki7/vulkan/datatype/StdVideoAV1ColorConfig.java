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

/// Represents a pointer to a {@code StdVideoAV1ColorConfig} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoAV1ColorConfig {
///     StdVideoAV1ColorConfigFlags flags; // @link substring="StdVideoAV1ColorConfigFlags" target="StdVideoAV1ColorConfigFlags" @link substring="flags" target="#flags"
///     uint8_t BitDepth; // @link substring="BitDepth" target="#BitDepth"
///     uint8_t subsampling_x; // @link substring="subsampling_x" target="#subsampling_x"
///     uint8_t subsampling_y; // @link substring="subsampling_y" target="#subsampling_y"
///     uint8_t reserved1;
///     StdVideoAV1ColorPrimaries color_primaries; // @link substring="StdVideoAV1ColorPrimaries" target="StdVideoAV1ColorPrimaries" @link substring="color_primaries" target="#color_primaries"
///     StdVideoAV1TransferCharacteristics transfer_characteristics; // @link substring="StdVideoAV1TransferCharacteristics" target="StdVideoAV1TransferCharacteristics" @link substring="transfer_characteristics" target="#transfer_characteristics"
///     StdVideoAV1MatrixCoefficients matrix_coefficients; // @link substring="StdVideoAV1MatrixCoefficients" target="StdVideoAV1MatrixCoefficients" @link substring="matrix_coefficients" target="#matrix_coefficients"
///     StdVideoAV1ChromaSamplePosition chroma_sample_position; // @link substring="StdVideoAV1ChromaSamplePosition" target="StdVideoAV1ChromaSamplePosition" @link substring="chroma_sample_position" target="#chroma_sample_position"
/// } StdVideoAV1ColorConfig;
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
public record StdVideoAV1ColorConfig(@NotNull MemorySegment segment) implements IStdVideoAV1ColorConfig {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoAV1ColorConfig}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoAV1ColorConfig to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoAV1ColorConfig.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoAV1ColorConfig, Iterable<StdVideoAV1ColorConfig> {
        public long size() {
            return segment.byteSize() / StdVideoAV1ColorConfig.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoAV1ColorConfig at(long index) {
            return new StdVideoAV1ColorConfig(segment.asSlice(index * StdVideoAV1ColorConfig.BYTES, StdVideoAV1ColorConfig.BYTES));
        }

        public StdVideoAV1ColorConfig.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoAV1ColorConfig> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoAV1ColorConfig value) {
            MemorySegment s = segment.asSlice(index * StdVideoAV1ColorConfig.BYTES, StdVideoAV1ColorConfig.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoAV1ColorConfig.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoAV1ColorConfig.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoAV1ColorConfig.BYTES,
                (end - start) * StdVideoAV1ColorConfig.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoAV1ColorConfig.BYTES));
        }

        public StdVideoAV1ColorConfig[] toArray() {
            StdVideoAV1ColorConfig[] ret = new StdVideoAV1ColorConfig[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoAV1ColorConfig> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoAV1ColorConfig> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoAV1ColorConfig.BYTES;
            }

            @Override
            public StdVideoAV1ColorConfig next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoAV1ColorConfig ret = new StdVideoAV1ColorConfig(segment.asSlice(0, StdVideoAV1ColorConfig.BYTES));
                segment = segment.asSlice(StdVideoAV1ColorConfig.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoAV1ColorConfig allocate(Arena arena) {
        return new StdVideoAV1ColorConfig(arena.allocate(LAYOUT));
    }

    public static StdVideoAV1ColorConfig.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoAV1ColorConfig.Ptr(segment);
    }

    public static StdVideoAV1ColorConfig clone(Arena arena, StdVideoAV1ColorConfig src) {
        StdVideoAV1ColorConfig ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoAV1ColorConfigFlags flags() {
        return new StdVideoAV1ColorConfigFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoAV1ColorConfig flags(@NotNull StdVideoAV1ColorConfigFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoAV1ColorConfig flags(Consumer<@NotNull StdVideoAV1ColorConfigFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte BitDepth() {
        return segment.get(LAYOUT$BitDepth, OFFSET$BitDepth);
    }

    public StdVideoAV1ColorConfig BitDepth(@Unsigned byte value) {
        segment.set(LAYOUT$BitDepth, OFFSET$BitDepth, value);
        return this;
    }

    public @Unsigned byte subsampling_x() {
        return segment.get(LAYOUT$subsampling_x, OFFSET$subsampling_x);
    }

    public StdVideoAV1ColorConfig subsampling_x(@Unsigned byte value) {
        segment.set(LAYOUT$subsampling_x, OFFSET$subsampling_x, value);
        return this;
    }

    public @Unsigned byte subsampling_y() {
        return segment.get(LAYOUT$subsampling_y, OFFSET$subsampling_y);
    }

    public StdVideoAV1ColorConfig subsampling_y(@Unsigned byte value) {
        segment.set(LAYOUT$subsampling_y, OFFSET$subsampling_y, value);
        return this;
    }


    public @EnumType(StdVideoAV1ColorPrimaries.class) int color_primaries() {
        return segment.get(LAYOUT$color_primaries, OFFSET$color_primaries);
    }

    public StdVideoAV1ColorConfig color_primaries(@EnumType(StdVideoAV1ColorPrimaries.class) int value) {
        segment.set(LAYOUT$color_primaries, OFFSET$color_primaries, value);
        return this;
    }

    public @EnumType(StdVideoAV1TransferCharacteristics.class) int transfer_characteristics() {
        return segment.get(LAYOUT$transfer_characteristics, OFFSET$transfer_characteristics);
    }

    public StdVideoAV1ColorConfig transfer_characteristics(@EnumType(StdVideoAV1TransferCharacteristics.class) int value) {
        segment.set(LAYOUT$transfer_characteristics, OFFSET$transfer_characteristics, value);
        return this;
    }

    public @EnumType(StdVideoAV1MatrixCoefficients.class) int matrix_coefficients() {
        return segment.get(LAYOUT$matrix_coefficients, OFFSET$matrix_coefficients);
    }

    public StdVideoAV1ColorConfig matrix_coefficients(@EnumType(StdVideoAV1MatrixCoefficients.class) int value) {
        segment.set(LAYOUT$matrix_coefficients, OFFSET$matrix_coefficients, value);
        return this;
    }

    public @EnumType(StdVideoAV1ChromaSamplePosition.class) int chroma_sample_position() {
        return segment.get(LAYOUT$chroma_sample_position, OFFSET$chroma_sample_position);
    }

    public StdVideoAV1ColorConfig chroma_sample_position(@EnumType(StdVideoAV1ChromaSamplePosition.class) int value) {
        segment.set(LAYOUT$chroma_sample_position, OFFSET$chroma_sample_position, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoAV1ColorConfigFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("BitDepth"),
        ValueLayout.JAVA_BYTE.withName("subsampling_x"),
        ValueLayout.JAVA_BYTE.withName("subsampling_y"),
        ValueLayout.JAVA_BYTE.withName("reserved1"),
        ValueLayout.JAVA_INT.withName("color_primaries"),
        ValueLayout.JAVA_INT.withName("transfer_characteristics"),
        ValueLayout.JAVA_INT.withName("matrix_coefficients"),
        ValueLayout.JAVA_INT.withName("chroma_sample_position")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$BitDepth = PathElement.groupElement("BitDepth");
    public static final PathElement PATH$subsampling_x = PathElement.groupElement("subsampling_x");
    public static final PathElement PATH$subsampling_y = PathElement.groupElement("subsampling_y");
    public static final PathElement PATH$color_primaries = PathElement.groupElement("color_primaries");
    public static final PathElement PATH$transfer_characteristics = PathElement.groupElement("transfer_characteristics");
    public static final PathElement PATH$matrix_coefficients = PathElement.groupElement("matrix_coefficients");
    public static final PathElement PATH$chroma_sample_position = PathElement.groupElement("chroma_sample_position");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$BitDepth = (OfByte) LAYOUT.select(PATH$BitDepth);
    public static final OfByte LAYOUT$subsampling_x = (OfByte) LAYOUT.select(PATH$subsampling_x);
    public static final OfByte LAYOUT$subsampling_y = (OfByte) LAYOUT.select(PATH$subsampling_y);
    public static final OfInt LAYOUT$color_primaries = (OfInt) LAYOUT.select(PATH$color_primaries);
    public static final OfInt LAYOUT$transfer_characteristics = (OfInt) LAYOUT.select(PATH$transfer_characteristics);
    public static final OfInt LAYOUT$matrix_coefficients = (OfInt) LAYOUT.select(PATH$matrix_coefficients);
    public static final OfInt LAYOUT$chroma_sample_position = (OfInt) LAYOUT.select(PATH$chroma_sample_position);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$BitDepth = LAYOUT$BitDepth.byteSize();
    public static final long SIZE$subsampling_x = LAYOUT$subsampling_x.byteSize();
    public static final long SIZE$subsampling_y = LAYOUT$subsampling_y.byteSize();
    public static final long SIZE$color_primaries = LAYOUT$color_primaries.byteSize();
    public static final long SIZE$transfer_characteristics = LAYOUT$transfer_characteristics.byteSize();
    public static final long SIZE$matrix_coefficients = LAYOUT$matrix_coefficients.byteSize();
    public static final long SIZE$chroma_sample_position = LAYOUT$chroma_sample_position.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$BitDepth = LAYOUT.byteOffset(PATH$BitDepth);
    public static final long OFFSET$subsampling_x = LAYOUT.byteOffset(PATH$subsampling_x);
    public static final long OFFSET$subsampling_y = LAYOUT.byteOffset(PATH$subsampling_y);
    public static final long OFFSET$color_primaries = LAYOUT.byteOffset(PATH$color_primaries);
    public static final long OFFSET$transfer_characteristics = LAYOUT.byteOffset(PATH$transfer_characteristics);
    public static final long OFFSET$matrix_coefficients = LAYOUT.byteOffset(PATH$matrix_coefficients);
    public static final long OFFSET$chroma_sample_position = LAYOUT.byteOffset(PATH$chroma_sample_position);
}
