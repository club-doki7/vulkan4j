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

/// Represents a pointer to a {@code StdVideoAV1Quantization} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoAV1Quantization {
///     StdVideoAV1QuantizationFlags flags; // @link substring="StdVideoAV1QuantizationFlags" target="StdVideoAV1QuantizationFlags" @link substring="flags" target="#flags"
///     uint8_t base_q_idx; // @link substring="base_q_idx" target="#base_q_idx"
///     int8_t DeltaQYDc; // @link substring="DeltaQYDc" target="#DeltaQYDc"
///     int8_t DeltaQUDc; // @link substring="DeltaQUDc" target="#DeltaQUDc"
///     int8_t DeltaQUAc; // @link substring="DeltaQUAc" target="#DeltaQUAc"
///     int8_t DeltaQVDc; // @link substring="DeltaQVDc" target="#DeltaQVDc"
///     int8_t DeltaQVAc; // @link substring="DeltaQVAc" target="#DeltaQVAc"
///     uint8_t qm_y; // @link substring="qm_y" target="#qm_y"
///     uint8_t qm_u; // @link substring="qm_u" target="#qm_u"
///     uint8_t qm_v; // @link substring="qm_v" target="#qm_v"
/// } StdVideoAV1Quantization;
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
public record StdVideoAV1Quantization(@NotNull MemorySegment segment) implements IStdVideoAV1Quantization {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoAV1Quantization}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoAV1Quantization to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoAV1Quantization.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoAV1Quantization, Iterable<StdVideoAV1Quantization> {
        public long size() {
            return segment.byteSize() / StdVideoAV1Quantization.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoAV1Quantization at(long index) {
            return new StdVideoAV1Quantization(segment.asSlice(index * StdVideoAV1Quantization.BYTES, StdVideoAV1Quantization.BYTES));
        }

        public StdVideoAV1Quantization.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoAV1Quantization> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoAV1Quantization value) {
            MemorySegment s = segment.asSlice(index * StdVideoAV1Quantization.BYTES, StdVideoAV1Quantization.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoAV1Quantization.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoAV1Quantization.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoAV1Quantization.BYTES,
                (end - start) * StdVideoAV1Quantization.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoAV1Quantization.BYTES));
        }

        public StdVideoAV1Quantization[] toArray() {
            StdVideoAV1Quantization[] ret = new StdVideoAV1Quantization[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoAV1Quantization> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoAV1Quantization> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoAV1Quantization.BYTES;
            }

            @Override
            public StdVideoAV1Quantization next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoAV1Quantization ret = new StdVideoAV1Quantization(segment.asSlice(0, StdVideoAV1Quantization.BYTES));
                segment = segment.asSlice(StdVideoAV1Quantization.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoAV1Quantization allocate(Arena arena) {
        return new StdVideoAV1Quantization(arena.allocate(LAYOUT));
    }

    public static StdVideoAV1Quantization.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoAV1Quantization.Ptr(segment);
    }

    public static StdVideoAV1Quantization clone(Arena arena, StdVideoAV1Quantization src) {
        StdVideoAV1Quantization ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoAV1QuantizationFlags flags() {
        return new StdVideoAV1QuantizationFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoAV1Quantization flags(@NotNull StdVideoAV1QuantizationFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoAV1Quantization flags(Consumer<@NotNull StdVideoAV1QuantizationFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte base_q_idx() {
        return segment.get(LAYOUT$base_q_idx, OFFSET$base_q_idx);
    }

    public StdVideoAV1Quantization base_q_idx(@Unsigned byte value) {
        segment.set(LAYOUT$base_q_idx, OFFSET$base_q_idx, value);
        return this;
    }

    public byte DeltaQYDc() {
        return segment.get(LAYOUT$DeltaQYDc, OFFSET$DeltaQYDc);
    }

    public StdVideoAV1Quantization DeltaQYDc(byte value) {
        segment.set(LAYOUT$DeltaQYDc, OFFSET$DeltaQYDc, value);
        return this;
    }

    public byte DeltaQUDc() {
        return segment.get(LAYOUT$DeltaQUDc, OFFSET$DeltaQUDc);
    }

    public StdVideoAV1Quantization DeltaQUDc(byte value) {
        segment.set(LAYOUT$DeltaQUDc, OFFSET$DeltaQUDc, value);
        return this;
    }

    public byte DeltaQUAc() {
        return segment.get(LAYOUT$DeltaQUAc, OFFSET$DeltaQUAc);
    }

    public StdVideoAV1Quantization DeltaQUAc(byte value) {
        segment.set(LAYOUT$DeltaQUAc, OFFSET$DeltaQUAc, value);
        return this;
    }

    public byte DeltaQVDc() {
        return segment.get(LAYOUT$DeltaQVDc, OFFSET$DeltaQVDc);
    }

    public StdVideoAV1Quantization DeltaQVDc(byte value) {
        segment.set(LAYOUT$DeltaQVDc, OFFSET$DeltaQVDc, value);
        return this;
    }

    public byte DeltaQVAc() {
        return segment.get(LAYOUT$DeltaQVAc, OFFSET$DeltaQVAc);
    }

    public StdVideoAV1Quantization DeltaQVAc(byte value) {
        segment.set(LAYOUT$DeltaQVAc, OFFSET$DeltaQVAc, value);
        return this;
    }

    public @Unsigned byte qm_y() {
        return segment.get(LAYOUT$qm_y, OFFSET$qm_y);
    }

    public StdVideoAV1Quantization qm_y(@Unsigned byte value) {
        segment.set(LAYOUT$qm_y, OFFSET$qm_y, value);
        return this;
    }

    public @Unsigned byte qm_u() {
        return segment.get(LAYOUT$qm_u, OFFSET$qm_u);
    }

    public StdVideoAV1Quantization qm_u(@Unsigned byte value) {
        segment.set(LAYOUT$qm_u, OFFSET$qm_u, value);
        return this;
    }

    public @Unsigned byte qm_v() {
        return segment.get(LAYOUT$qm_v, OFFSET$qm_v);
    }

    public StdVideoAV1Quantization qm_v(@Unsigned byte value) {
        segment.set(LAYOUT$qm_v, OFFSET$qm_v, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoAV1QuantizationFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("base_q_idx"),
        ValueLayout.JAVA_BYTE.withName("DeltaQYDc"),
        ValueLayout.JAVA_BYTE.withName("DeltaQUDc"),
        ValueLayout.JAVA_BYTE.withName("DeltaQUAc"),
        ValueLayout.JAVA_BYTE.withName("DeltaQVDc"),
        ValueLayout.JAVA_BYTE.withName("DeltaQVAc"),
        ValueLayout.JAVA_BYTE.withName("qm_y"),
        ValueLayout.JAVA_BYTE.withName("qm_u"),
        ValueLayout.JAVA_BYTE.withName("qm_v")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$base_q_idx = PathElement.groupElement("base_q_idx");
    public static final PathElement PATH$DeltaQYDc = PathElement.groupElement("DeltaQYDc");
    public static final PathElement PATH$DeltaQUDc = PathElement.groupElement("DeltaQUDc");
    public static final PathElement PATH$DeltaQUAc = PathElement.groupElement("DeltaQUAc");
    public static final PathElement PATH$DeltaQVDc = PathElement.groupElement("DeltaQVDc");
    public static final PathElement PATH$DeltaQVAc = PathElement.groupElement("DeltaQVAc");
    public static final PathElement PATH$qm_y = PathElement.groupElement("qm_y");
    public static final PathElement PATH$qm_u = PathElement.groupElement("qm_u");
    public static final PathElement PATH$qm_v = PathElement.groupElement("qm_v");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$base_q_idx = (OfByte) LAYOUT.select(PATH$base_q_idx);
    public static final OfByte LAYOUT$DeltaQYDc = (OfByte) LAYOUT.select(PATH$DeltaQYDc);
    public static final OfByte LAYOUT$DeltaQUDc = (OfByte) LAYOUT.select(PATH$DeltaQUDc);
    public static final OfByte LAYOUT$DeltaQUAc = (OfByte) LAYOUT.select(PATH$DeltaQUAc);
    public static final OfByte LAYOUT$DeltaQVDc = (OfByte) LAYOUT.select(PATH$DeltaQVDc);
    public static final OfByte LAYOUT$DeltaQVAc = (OfByte) LAYOUT.select(PATH$DeltaQVAc);
    public static final OfByte LAYOUT$qm_y = (OfByte) LAYOUT.select(PATH$qm_y);
    public static final OfByte LAYOUT$qm_u = (OfByte) LAYOUT.select(PATH$qm_u);
    public static final OfByte LAYOUT$qm_v = (OfByte) LAYOUT.select(PATH$qm_v);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$base_q_idx = LAYOUT$base_q_idx.byteSize();
    public static final long SIZE$DeltaQYDc = LAYOUT$DeltaQYDc.byteSize();
    public static final long SIZE$DeltaQUDc = LAYOUT$DeltaQUDc.byteSize();
    public static final long SIZE$DeltaQUAc = LAYOUT$DeltaQUAc.byteSize();
    public static final long SIZE$DeltaQVDc = LAYOUT$DeltaQVDc.byteSize();
    public static final long SIZE$DeltaQVAc = LAYOUT$DeltaQVAc.byteSize();
    public static final long SIZE$qm_y = LAYOUT$qm_y.byteSize();
    public static final long SIZE$qm_u = LAYOUT$qm_u.byteSize();
    public static final long SIZE$qm_v = LAYOUT$qm_v.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$base_q_idx = LAYOUT.byteOffset(PATH$base_q_idx);
    public static final long OFFSET$DeltaQYDc = LAYOUT.byteOffset(PATH$DeltaQYDc);
    public static final long OFFSET$DeltaQUDc = LAYOUT.byteOffset(PATH$DeltaQUDc);
    public static final long OFFSET$DeltaQUAc = LAYOUT.byteOffset(PATH$DeltaQUAc);
    public static final long OFFSET$DeltaQVDc = LAYOUT.byteOffset(PATH$DeltaQVDc);
    public static final long OFFSET$DeltaQVAc = LAYOUT.byteOffset(PATH$DeltaQVAc);
    public static final long OFFSET$qm_y = LAYOUT.byteOffset(PATH$qm_y);
    public static final long OFFSET$qm_u = LAYOUT.byteOffset(PATH$qm_u);
    public static final long OFFSET$qm_v = LAYOUT.byteOffset(PATH$qm_v);
}
