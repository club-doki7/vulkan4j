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

/// Represents a pointer to a {@code StdVideoH265HrdParameters} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265HrdParameters {
///     StdVideoH265HrdFlags flags; // @link substring="StdVideoH265HrdFlags" target="StdVideoH265HrdFlags" @link substring="flags" target="#flags"
///     uint8_t tick_divisor_minus2; // @link substring="tick_divisor_minus2" target="#tick_divisor_minus2"
///     uint8_t du_cpb_removal_delay_increment_length_minus1; // @link substring="du_cpb_removal_delay_increment_length_minus1" target="#du_cpb_removal_delay_increment_length_minus1"
///     uint8_t dpb_output_delay_du_length_minus1; // @link substring="dpb_output_delay_du_length_minus1" target="#dpb_output_delay_du_length_minus1"
///     uint8_t bit_rate_scale; // @link substring="bit_rate_scale" target="#bit_rate_scale"
///     uint8_t cpb_size_scale; // @link substring="cpb_size_scale" target="#cpb_size_scale"
///     uint8_t cpb_size_du_scale; // @link substring="cpb_size_du_scale" target="#cpb_size_du_scale"
///     uint8_t initial_cpb_removal_delay_length_minus1; // @link substring="initial_cpb_removal_delay_length_minus1" target="#initial_cpb_removal_delay_length_minus1"
///     uint8_t au_cpb_removal_delay_length_minus1; // @link substring="au_cpb_removal_delay_length_minus1" target="#au_cpb_removal_delay_length_minus1"
///     uint8_t dpb_output_delay_length_minus1; // @link substring="dpb_output_delay_length_minus1" target="#dpb_output_delay_length_minus1"
///     uint8_t[STD_VIDEO_H265_SUBLAYERS_LIST_SIZE] cpb_cnt_minus1; // @link substring="cpb_cnt_minus1" target="#cpb_cnt_minus1"
///     uint16_t[STD_VIDEO_H265_SUBLAYERS_LIST_SIZE] elemental_duration_in_tc_minus1; // @link substring="elemental_duration_in_tc_minus1" target="#elemental_duration_in_tc_minus1"
///     uint16_t[3] reserved;
///     StdVideoH265SubLayerHrdParameters const* pSubLayerHrdParametersNal; // optional // @link substring="StdVideoH265SubLayerHrdParameters" target="StdVideoH265SubLayerHrdParameters" @link substring="pSubLayerHrdParametersNal" target="#pSubLayerHrdParametersNal"
///     StdVideoH265SubLayerHrdParameters const* pSubLayerHrdParametersVcl; // optional // @link substring="StdVideoH265SubLayerHrdParameters" target="StdVideoH265SubLayerHrdParameters" @link substring="pSubLayerHrdParametersVcl" target="#pSubLayerHrdParametersVcl"
/// } StdVideoH265HrdParameters;
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
public record StdVideoH265HrdParameters(@NotNull MemorySegment segment) implements IStdVideoH265HrdParameters {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265HrdParameters}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265HrdParameters to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265HrdParameters.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265HrdParameters, Iterable<StdVideoH265HrdParameters> {
        public long size() {
            return segment.byteSize() / StdVideoH265HrdParameters.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265HrdParameters at(long index) {
            return new StdVideoH265HrdParameters(segment.asSlice(index * StdVideoH265HrdParameters.BYTES, StdVideoH265HrdParameters.BYTES));
        }

        public StdVideoH265HrdParameters.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265HrdParameters> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265HrdParameters value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265HrdParameters.BYTES, StdVideoH265HrdParameters.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265HrdParameters.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265HrdParameters.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265HrdParameters.BYTES,
                (end - start) * StdVideoH265HrdParameters.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265HrdParameters.BYTES));
        }

        public StdVideoH265HrdParameters[] toArray() {
            StdVideoH265HrdParameters[] ret = new StdVideoH265HrdParameters[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265HrdParameters> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265HrdParameters> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265HrdParameters.BYTES;
            }

            @Override
            public StdVideoH265HrdParameters next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265HrdParameters ret = new StdVideoH265HrdParameters(segment.asSlice(0, StdVideoH265HrdParameters.BYTES));
                segment = segment.asSlice(StdVideoH265HrdParameters.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265HrdParameters allocate(Arena arena) {
        return new StdVideoH265HrdParameters(arena.allocate(LAYOUT));
    }

    public static StdVideoH265HrdParameters.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265HrdParameters.Ptr(segment);
    }

    public static StdVideoH265HrdParameters clone(Arena arena, StdVideoH265HrdParameters src) {
        StdVideoH265HrdParameters ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoH265HrdFlags flags() {
        return new StdVideoH265HrdFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoH265HrdParameters flags(@NotNull StdVideoH265HrdFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoH265HrdParameters flags(Consumer<@NotNull StdVideoH265HrdFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte tick_divisor_minus2() {
        return segment.get(LAYOUT$tick_divisor_minus2, OFFSET$tick_divisor_minus2);
    }

    public StdVideoH265HrdParameters tick_divisor_minus2(@Unsigned byte value) {
        segment.set(LAYOUT$tick_divisor_minus2, OFFSET$tick_divisor_minus2, value);
        return this;
    }

    public @Unsigned byte du_cpb_removal_delay_increment_length_minus1() {
        return segment.get(LAYOUT$du_cpb_removal_delay_increment_length_minus1, OFFSET$du_cpb_removal_delay_increment_length_minus1);
    }

    public StdVideoH265HrdParameters du_cpb_removal_delay_increment_length_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$du_cpb_removal_delay_increment_length_minus1, OFFSET$du_cpb_removal_delay_increment_length_minus1, value);
        return this;
    }

    public @Unsigned byte dpb_output_delay_du_length_minus1() {
        return segment.get(LAYOUT$dpb_output_delay_du_length_minus1, OFFSET$dpb_output_delay_du_length_minus1);
    }

    public StdVideoH265HrdParameters dpb_output_delay_du_length_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$dpb_output_delay_du_length_minus1, OFFSET$dpb_output_delay_du_length_minus1, value);
        return this;
    }

    public @Unsigned byte bit_rate_scale() {
        return segment.get(LAYOUT$bit_rate_scale, OFFSET$bit_rate_scale);
    }

    public StdVideoH265HrdParameters bit_rate_scale(@Unsigned byte value) {
        segment.set(LAYOUT$bit_rate_scale, OFFSET$bit_rate_scale, value);
        return this;
    }

    public @Unsigned byte cpb_size_scale() {
        return segment.get(LAYOUT$cpb_size_scale, OFFSET$cpb_size_scale);
    }

    public StdVideoH265HrdParameters cpb_size_scale(@Unsigned byte value) {
        segment.set(LAYOUT$cpb_size_scale, OFFSET$cpb_size_scale, value);
        return this;
    }

    public @Unsigned byte cpb_size_du_scale() {
        return segment.get(LAYOUT$cpb_size_du_scale, OFFSET$cpb_size_du_scale);
    }

    public StdVideoH265HrdParameters cpb_size_du_scale(@Unsigned byte value) {
        segment.set(LAYOUT$cpb_size_du_scale, OFFSET$cpb_size_du_scale, value);
        return this;
    }

    public @Unsigned byte initial_cpb_removal_delay_length_minus1() {
        return segment.get(LAYOUT$initial_cpb_removal_delay_length_minus1, OFFSET$initial_cpb_removal_delay_length_minus1);
    }

    public StdVideoH265HrdParameters initial_cpb_removal_delay_length_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$initial_cpb_removal_delay_length_minus1, OFFSET$initial_cpb_removal_delay_length_minus1, value);
        return this;
    }

    public @Unsigned byte au_cpb_removal_delay_length_minus1() {
        return segment.get(LAYOUT$au_cpb_removal_delay_length_minus1, OFFSET$au_cpb_removal_delay_length_minus1);
    }

    public StdVideoH265HrdParameters au_cpb_removal_delay_length_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$au_cpb_removal_delay_length_minus1, OFFSET$au_cpb_removal_delay_length_minus1, value);
        return this;
    }

    public @Unsigned byte dpb_output_delay_length_minus1() {
        return segment.get(LAYOUT$dpb_output_delay_length_minus1, OFFSET$dpb_output_delay_length_minus1);
    }

    public StdVideoH265HrdParameters dpb_output_delay_length_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$dpb_output_delay_length_minus1, OFFSET$dpb_output_delay_length_minus1, value);
        return this;
    }

    public @Unsigned BytePtr cpb_cnt_minus1() {
        return new BytePtr(cpb_cnt_minus1Raw());
    }

    public StdVideoH265HrdParameters cpb_cnt_minus1(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = cpb_cnt_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265HrdParameters cpb_cnt_minus1(@Unsigned BytePtr value) {
        MemorySegment s = cpb_cnt_minus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment cpb_cnt_minus1Raw() {
        return segment.asSlice(OFFSET$cpb_cnt_minus1, SIZE$cpb_cnt_minus1);
    }

    public @Unsigned ShortPtr elemental_duration_in_tc_minus1() {
        return new ShortPtr(elemental_duration_in_tc_minus1Raw());
    }

    public StdVideoH265HrdParameters elemental_duration_in_tc_minus1(@NotNull Consumer<ShortPtr> consumer) {
        @Unsigned ShortPtr ptr = elemental_duration_in_tc_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265HrdParameters elemental_duration_in_tc_minus1(@Unsigned ShortPtr value) {
        MemorySegment s = elemental_duration_in_tc_minus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment elemental_duration_in_tc_minus1Raw() {
        return segment.asSlice(OFFSET$elemental_duration_in_tc_minus1, SIZE$elemental_duration_in_tc_minus1);
    }


    public StdVideoH265HrdParameters pSubLayerHrdParametersNal(@Nullable IStdVideoH265SubLayerHrdParameters value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSubLayerHrdParametersNalRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265SubLayerHrdParameters.Ptr pSubLayerHrdParametersNal(int assumedCount) {
        MemorySegment s = pSubLayerHrdParametersNalRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265SubLayerHrdParameters.BYTES);
        return new StdVideoH265SubLayerHrdParameters.Ptr(s);
    }

    public @Nullable StdVideoH265SubLayerHrdParameters pSubLayerHrdParametersNal() {
        MemorySegment s = pSubLayerHrdParametersNalRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265SubLayerHrdParameters(s);
    }

    public @Pointer(target=StdVideoH265SubLayerHrdParameters.class) @NotNull MemorySegment pSubLayerHrdParametersNalRaw() {
        return segment.get(LAYOUT$pSubLayerHrdParametersNal, OFFSET$pSubLayerHrdParametersNal);
    }

    public void pSubLayerHrdParametersNalRaw(@Pointer(target=StdVideoH265SubLayerHrdParameters.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSubLayerHrdParametersNal, OFFSET$pSubLayerHrdParametersNal, value);
    }

    public StdVideoH265HrdParameters pSubLayerHrdParametersVcl(@Nullable IStdVideoH265SubLayerHrdParameters value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSubLayerHrdParametersVclRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265SubLayerHrdParameters.Ptr pSubLayerHrdParametersVcl(int assumedCount) {
        MemorySegment s = pSubLayerHrdParametersVclRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265SubLayerHrdParameters.BYTES);
        return new StdVideoH265SubLayerHrdParameters.Ptr(s);
    }

    public @Nullable StdVideoH265SubLayerHrdParameters pSubLayerHrdParametersVcl() {
        MemorySegment s = pSubLayerHrdParametersVclRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265SubLayerHrdParameters(s);
    }

    public @Pointer(target=StdVideoH265SubLayerHrdParameters.class) @NotNull MemorySegment pSubLayerHrdParametersVclRaw() {
        return segment.get(LAYOUT$pSubLayerHrdParametersVcl, OFFSET$pSubLayerHrdParametersVcl);
    }

    public void pSubLayerHrdParametersVclRaw(@Pointer(target=StdVideoH265SubLayerHrdParameters.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSubLayerHrdParametersVcl, OFFSET$pSubLayerHrdParametersVcl, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoH265HrdFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("tick_divisor_minus2"),
        ValueLayout.JAVA_BYTE.withName("du_cpb_removal_delay_increment_length_minus1"),
        ValueLayout.JAVA_BYTE.withName("dpb_output_delay_du_length_minus1"),
        ValueLayout.JAVA_BYTE.withName("bit_rate_scale"),
        ValueLayout.JAVA_BYTE.withName("cpb_size_scale"),
        ValueLayout.JAVA_BYTE.withName("cpb_size_du_scale"),
        ValueLayout.JAVA_BYTE.withName("initial_cpb_removal_delay_length_minus1"),
        ValueLayout.JAVA_BYTE.withName("au_cpb_removal_delay_length_minus1"),
        ValueLayout.JAVA_BYTE.withName("dpb_output_delay_length_minus1"),
        MemoryLayout.sequenceLayout(H265_SUBLAYERS_LIST_SIZE, ValueLayout.JAVA_BYTE).withName("cpb_cnt_minus1"),
        MemoryLayout.sequenceLayout(H265_SUBLAYERS_LIST_SIZE, ValueLayout.JAVA_SHORT).withName("elemental_duration_in_tc_minus1"),
        MemoryLayout.sequenceLayout(3, ValueLayout.JAVA_SHORT).withName("reserved"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265SubLayerHrdParameters.LAYOUT).withName("pSubLayerHrdParametersNal"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265SubLayerHrdParameters.LAYOUT).withName("pSubLayerHrdParametersVcl")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$tick_divisor_minus2 = PathElement.groupElement("tick_divisor_minus2");
    public static final PathElement PATH$du_cpb_removal_delay_increment_length_minus1 = PathElement.groupElement("du_cpb_removal_delay_increment_length_minus1");
    public static final PathElement PATH$dpb_output_delay_du_length_minus1 = PathElement.groupElement("dpb_output_delay_du_length_minus1");
    public static final PathElement PATH$bit_rate_scale = PathElement.groupElement("bit_rate_scale");
    public static final PathElement PATH$cpb_size_scale = PathElement.groupElement("cpb_size_scale");
    public static final PathElement PATH$cpb_size_du_scale = PathElement.groupElement("cpb_size_du_scale");
    public static final PathElement PATH$initial_cpb_removal_delay_length_minus1 = PathElement.groupElement("initial_cpb_removal_delay_length_minus1");
    public static final PathElement PATH$au_cpb_removal_delay_length_minus1 = PathElement.groupElement("au_cpb_removal_delay_length_minus1");
    public static final PathElement PATH$dpb_output_delay_length_minus1 = PathElement.groupElement("dpb_output_delay_length_minus1");
    public static final PathElement PATH$cpb_cnt_minus1 = PathElement.groupElement("cpb_cnt_minus1");
    public static final PathElement PATH$elemental_duration_in_tc_minus1 = PathElement.groupElement("elemental_duration_in_tc_minus1");
    public static final PathElement PATH$pSubLayerHrdParametersNal = PathElement.groupElement("pSubLayerHrdParametersNal");
    public static final PathElement PATH$pSubLayerHrdParametersVcl = PathElement.groupElement("pSubLayerHrdParametersVcl");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$tick_divisor_minus2 = (OfByte) LAYOUT.select(PATH$tick_divisor_minus2);
    public static final OfByte LAYOUT$du_cpb_removal_delay_increment_length_minus1 = (OfByte) LAYOUT.select(PATH$du_cpb_removal_delay_increment_length_minus1);
    public static final OfByte LAYOUT$dpb_output_delay_du_length_minus1 = (OfByte) LAYOUT.select(PATH$dpb_output_delay_du_length_minus1);
    public static final OfByte LAYOUT$bit_rate_scale = (OfByte) LAYOUT.select(PATH$bit_rate_scale);
    public static final OfByte LAYOUT$cpb_size_scale = (OfByte) LAYOUT.select(PATH$cpb_size_scale);
    public static final OfByte LAYOUT$cpb_size_du_scale = (OfByte) LAYOUT.select(PATH$cpb_size_du_scale);
    public static final OfByte LAYOUT$initial_cpb_removal_delay_length_minus1 = (OfByte) LAYOUT.select(PATH$initial_cpb_removal_delay_length_minus1);
    public static final OfByte LAYOUT$au_cpb_removal_delay_length_minus1 = (OfByte) LAYOUT.select(PATH$au_cpb_removal_delay_length_minus1);
    public static final OfByte LAYOUT$dpb_output_delay_length_minus1 = (OfByte) LAYOUT.select(PATH$dpb_output_delay_length_minus1);
    public static final SequenceLayout LAYOUT$cpb_cnt_minus1 = (SequenceLayout) LAYOUT.select(PATH$cpb_cnt_minus1);
    public static final SequenceLayout LAYOUT$elemental_duration_in_tc_minus1 = (SequenceLayout) LAYOUT.select(PATH$elemental_duration_in_tc_minus1);
    public static final AddressLayout LAYOUT$pSubLayerHrdParametersNal = (AddressLayout) LAYOUT.select(PATH$pSubLayerHrdParametersNal);
    public static final AddressLayout LAYOUT$pSubLayerHrdParametersVcl = (AddressLayout) LAYOUT.select(PATH$pSubLayerHrdParametersVcl);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$tick_divisor_minus2 = LAYOUT$tick_divisor_minus2.byteSize();
    public static final long SIZE$du_cpb_removal_delay_increment_length_minus1 = LAYOUT$du_cpb_removal_delay_increment_length_minus1.byteSize();
    public static final long SIZE$dpb_output_delay_du_length_minus1 = LAYOUT$dpb_output_delay_du_length_minus1.byteSize();
    public static final long SIZE$bit_rate_scale = LAYOUT$bit_rate_scale.byteSize();
    public static final long SIZE$cpb_size_scale = LAYOUT$cpb_size_scale.byteSize();
    public static final long SIZE$cpb_size_du_scale = LAYOUT$cpb_size_du_scale.byteSize();
    public static final long SIZE$initial_cpb_removal_delay_length_minus1 = LAYOUT$initial_cpb_removal_delay_length_minus1.byteSize();
    public static final long SIZE$au_cpb_removal_delay_length_minus1 = LAYOUT$au_cpb_removal_delay_length_minus1.byteSize();
    public static final long SIZE$dpb_output_delay_length_minus1 = LAYOUT$dpb_output_delay_length_minus1.byteSize();
    public static final long SIZE$cpb_cnt_minus1 = LAYOUT$cpb_cnt_minus1.byteSize();
    public static final long SIZE$elemental_duration_in_tc_minus1 = LAYOUT$elemental_duration_in_tc_minus1.byteSize();
    public static final long SIZE$pSubLayerHrdParametersNal = LAYOUT$pSubLayerHrdParametersNal.byteSize();
    public static final long SIZE$pSubLayerHrdParametersVcl = LAYOUT$pSubLayerHrdParametersVcl.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$tick_divisor_minus2 = LAYOUT.byteOffset(PATH$tick_divisor_minus2);
    public static final long OFFSET$du_cpb_removal_delay_increment_length_minus1 = LAYOUT.byteOffset(PATH$du_cpb_removal_delay_increment_length_minus1);
    public static final long OFFSET$dpb_output_delay_du_length_minus1 = LAYOUT.byteOffset(PATH$dpb_output_delay_du_length_minus1);
    public static final long OFFSET$bit_rate_scale = LAYOUT.byteOffset(PATH$bit_rate_scale);
    public static final long OFFSET$cpb_size_scale = LAYOUT.byteOffset(PATH$cpb_size_scale);
    public static final long OFFSET$cpb_size_du_scale = LAYOUT.byteOffset(PATH$cpb_size_du_scale);
    public static final long OFFSET$initial_cpb_removal_delay_length_minus1 = LAYOUT.byteOffset(PATH$initial_cpb_removal_delay_length_minus1);
    public static final long OFFSET$au_cpb_removal_delay_length_minus1 = LAYOUT.byteOffset(PATH$au_cpb_removal_delay_length_minus1);
    public static final long OFFSET$dpb_output_delay_length_minus1 = LAYOUT.byteOffset(PATH$dpb_output_delay_length_minus1);
    public static final long OFFSET$cpb_cnt_minus1 = LAYOUT.byteOffset(PATH$cpb_cnt_minus1);
    public static final long OFFSET$elemental_duration_in_tc_minus1 = LAYOUT.byteOffset(PATH$elemental_duration_in_tc_minus1);
    public static final long OFFSET$pSubLayerHrdParametersNal = LAYOUT.byteOffset(PATH$pSubLayerHrdParametersNal);
    public static final long OFFSET$pSubLayerHrdParametersVcl = LAYOUT.byteOffset(PATH$pSubLayerHrdParametersVcl);
}
