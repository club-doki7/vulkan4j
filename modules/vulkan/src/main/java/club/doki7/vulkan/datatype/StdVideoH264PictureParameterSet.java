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

/// Represents a pointer to a {@code StdVideoH264PictureParameterSet} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH264PictureParameterSet {
///     StdVideoH264PpsFlags flags; // @link substring="StdVideoH264PpsFlags" target="StdVideoH264PpsFlags" @link substring="flags" target="#flags"
///     uint8_t seq_parameter_set_id; // @link substring="seq_parameter_set_id" target="#seq_parameter_set_id"
///     uint8_t pic_parameter_set_id; // @link substring="pic_parameter_set_id" target="#pic_parameter_set_id"
///     uint8_t num_ref_idx_l0_default_active_minus1; // @link substring="num_ref_idx_l0_default_active_minus1" target="#num_ref_idx_l0_default_active_minus1"
///     uint8_t num_ref_idx_l1_default_active_minus1; // @link substring="num_ref_idx_l1_default_active_minus1" target="#num_ref_idx_l1_default_active_minus1"
///     StdVideoH264WeightedBipredIdc weighted_bipred_idc; // @link substring="StdVideoH264WeightedBipredIdc" target="StdVideoH264WeightedBipredIdc" @link substring="weighted_bipred_idc" target="#weighted_bipred_idc"
///     int8_t pic_init_qp_minus26; // @link substring="pic_init_qp_minus26" target="#pic_init_qp_minus26"
///     int8_t pic_init_qs_minus26; // @link substring="pic_init_qs_minus26" target="#pic_init_qs_minus26"
///     int8_t chroma_qp_index_offset; // @link substring="chroma_qp_index_offset" target="#chroma_qp_index_offset"
///     int8_t second_chroma_qp_index_offset; // @link substring="second_chroma_qp_index_offset" target="#second_chroma_qp_index_offset"
///     StdVideoH264ScalingLists const* pScalingLists; // optional // @link substring="StdVideoH264ScalingLists" target="StdVideoH264ScalingLists" @link substring="pScalingLists" target="#pScalingLists"
/// } StdVideoH264PictureParameterSet;
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
public record StdVideoH264PictureParameterSet(@NotNull MemorySegment segment) implements IStdVideoH264PictureParameterSet {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH264PictureParameterSet}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH264PictureParameterSet to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH264PictureParameterSet.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH264PictureParameterSet, Iterable<StdVideoH264PictureParameterSet> {
        public long size() {
            return segment.byteSize() / StdVideoH264PictureParameterSet.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH264PictureParameterSet at(long index) {
            return new StdVideoH264PictureParameterSet(segment.asSlice(index * StdVideoH264PictureParameterSet.BYTES, StdVideoH264PictureParameterSet.BYTES));
        }

        public StdVideoH264PictureParameterSet.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH264PictureParameterSet> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH264PictureParameterSet value) {
            MemorySegment s = segment.asSlice(index * StdVideoH264PictureParameterSet.BYTES, StdVideoH264PictureParameterSet.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH264PictureParameterSet.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH264PictureParameterSet.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH264PictureParameterSet.BYTES,
                (end - start) * StdVideoH264PictureParameterSet.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH264PictureParameterSet.BYTES));
        }

        public StdVideoH264PictureParameterSet[] toArray() {
            StdVideoH264PictureParameterSet[] ret = new StdVideoH264PictureParameterSet[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH264PictureParameterSet> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH264PictureParameterSet> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH264PictureParameterSet.BYTES;
            }

            @Override
            public StdVideoH264PictureParameterSet next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH264PictureParameterSet ret = new StdVideoH264PictureParameterSet(segment.asSlice(0, StdVideoH264PictureParameterSet.BYTES));
                segment = segment.asSlice(StdVideoH264PictureParameterSet.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH264PictureParameterSet allocate(Arena arena) {
        return new StdVideoH264PictureParameterSet(arena.allocate(LAYOUT));
    }

    public static StdVideoH264PictureParameterSet.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH264PictureParameterSet.Ptr(segment);
    }

    public static StdVideoH264PictureParameterSet clone(Arena arena, StdVideoH264PictureParameterSet src) {
        StdVideoH264PictureParameterSet ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoH264PpsFlags flags() {
        return new StdVideoH264PpsFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoH264PictureParameterSet flags(@NotNull StdVideoH264PpsFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoH264PictureParameterSet flags(Consumer<@NotNull StdVideoH264PpsFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte seq_parameter_set_id() {
        return segment.get(LAYOUT$seq_parameter_set_id, OFFSET$seq_parameter_set_id);
    }

    public StdVideoH264PictureParameterSet seq_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$seq_parameter_set_id, OFFSET$seq_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte pic_parameter_set_id() {
        return segment.get(LAYOUT$pic_parameter_set_id, OFFSET$pic_parameter_set_id);
    }

    public StdVideoH264PictureParameterSet pic_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$pic_parameter_set_id, OFFSET$pic_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte num_ref_idx_l0_default_active_minus1() {
        return segment.get(LAYOUT$num_ref_idx_l0_default_active_minus1, OFFSET$num_ref_idx_l0_default_active_minus1);
    }

    public StdVideoH264PictureParameterSet num_ref_idx_l0_default_active_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$num_ref_idx_l0_default_active_minus1, OFFSET$num_ref_idx_l0_default_active_minus1, value);
        return this;
    }

    public @Unsigned byte num_ref_idx_l1_default_active_minus1() {
        return segment.get(LAYOUT$num_ref_idx_l1_default_active_minus1, OFFSET$num_ref_idx_l1_default_active_minus1);
    }

    public StdVideoH264PictureParameterSet num_ref_idx_l1_default_active_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$num_ref_idx_l1_default_active_minus1, OFFSET$num_ref_idx_l1_default_active_minus1, value);
        return this;
    }

    public @EnumType(StdVideoH264WeightedBipredIdc.class) int weighted_bipred_idc() {
        return segment.get(LAYOUT$weighted_bipred_idc, OFFSET$weighted_bipred_idc);
    }

    public StdVideoH264PictureParameterSet weighted_bipred_idc(@EnumType(StdVideoH264WeightedBipredIdc.class) int value) {
        segment.set(LAYOUT$weighted_bipred_idc, OFFSET$weighted_bipred_idc, value);
        return this;
    }

    public byte pic_init_qp_minus26() {
        return segment.get(LAYOUT$pic_init_qp_minus26, OFFSET$pic_init_qp_minus26);
    }

    public StdVideoH264PictureParameterSet pic_init_qp_minus26(byte value) {
        segment.set(LAYOUT$pic_init_qp_minus26, OFFSET$pic_init_qp_minus26, value);
        return this;
    }

    public byte pic_init_qs_minus26() {
        return segment.get(LAYOUT$pic_init_qs_minus26, OFFSET$pic_init_qs_minus26);
    }

    public StdVideoH264PictureParameterSet pic_init_qs_minus26(byte value) {
        segment.set(LAYOUT$pic_init_qs_minus26, OFFSET$pic_init_qs_minus26, value);
        return this;
    }

    public byte chroma_qp_index_offset() {
        return segment.get(LAYOUT$chroma_qp_index_offset, OFFSET$chroma_qp_index_offset);
    }

    public StdVideoH264PictureParameterSet chroma_qp_index_offset(byte value) {
        segment.set(LAYOUT$chroma_qp_index_offset, OFFSET$chroma_qp_index_offset, value);
        return this;
    }

    public byte second_chroma_qp_index_offset() {
        return segment.get(LAYOUT$second_chroma_qp_index_offset, OFFSET$second_chroma_qp_index_offset);
    }

    public StdVideoH264PictureParameterSet second_chroma_qp_index_offset(byte value) {
        segment.set(LAYOUT$second_chroma_qp_index_offset, OFFSET$second_chroma_qp_index_offset, value);
        return this;
    }

    public StdVideoH264PictureParameterSet pScalingLists(@Nullable IStdVideoH264ScalingLists value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pScalingListsRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH264ScalingLists.Ptr pScalingLists(int assumedCount) {
        MemorySegment s = pScalingListsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH264ScalingLists.BYTES);
        return new StdVideoH264ScalingLists.Ptr(s);
    }

    public @Nullable StdVideoH264ScalingLists pScalingLists() {
        MemorySegment s = pScalingListsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH264ScalingLists(s);
    }

    public @Pointer(target=StdVideoH264ScalingLists.class) @NotNull MemorySegment pScalingListsRaw() {
        return segment.get(LAYOUT$pScalingLists, OFFSET$pScalingLists);
    }

    public void pScalingListsRaw(@Pointer(target=StdVideoH264ScalingLists.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pScalingLists, OFFSET$pScalingLists, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoH264PpsFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("seq_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("pic_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("num_ref_idx_l0_default_active_minus1"),
        ValueLayout.JAVA_BYTE.withName("num_ref_idx_l1_default_active_minus1"),
        ValueLayout.JAVA_INT.withName("weighted_bipred_idc"),
        ValueLayout.JAVA_BYTE.withName("pic_init_qp_minus26"),
        ValueLayout.JAVA_BYTE.withName("pic_init_qs_minus26"),
        ValueLayout.JAVA_BYTE.withName("chroma_qp_index_offset"),
        ValueLayout.JAVA_BYTE.withName("second_chroma_qp_index_offset"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH264ScalingLists.LAYOUT).withName("pScalingLists")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$seq_parameter_set_id = PathElement.groupElement("seq_parameter_set_id");
    public static final PathElement PATH$pic_parameter_set_id = PathElement.groupElement("pic_parameter_set_id");
    public static final PathElement PATH$num_ref_idx_l0_default_active_minus1 = PathElement.groupElement("num_ref_idx_l0_default_active_minus1");
    public static final PathElement PATH$num_ref_idx_l1_default_active_minus1 = PathElement.groupElement("num_ref_idx_l1_default_active_minus1");
    public static final PathElement PATH$weighted_bipred_idc = PathElement.groupElement("weighted_bipred_idc");
    public static final PathElement PATH$pic_init_qp_minus26 = PathElement.groupElement("pic_init_qp_minus26");
    public static final PathElement PATH$pic_init_qs_minus26 = PathElement.groupElement("pic_init_qs_minus26");
    public static final PathElement PATH$chroma_qp_index_offset = PathElement.groupElement("chroma_qp_index_offset");
    public static final PathElement PATH$second_chroma_qp_index_offset = PathElement.groupElement("second_chroma_qp_index_offset");
    public static final PathElement PATH$pScalingLists = PathElement.groupElement("pScalingLists");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$seq_parameter_set_id = (OfByte) LAYOUT.select(PATH$seq_parameter_set_id);
    public static final OfByte LAYOUT$pic_parameter_set_id = (OfByte) LAYOUT.select(PATH$pic_parameter_set_id);
    public static final OfByte LAYOUT$num_ref_idx_l0_default_active_minus1 = (OfByte) LAYOUT.select(PATH$num_ref_idx_l0_default_active_minus1);
    public static final OfByte LAYOUT$num_ref_idx_l1_default_active_minus1 = (OfByte) LAYOUT.select(PATH$num_ref_idx_l1_default_active_minus1);
    public static final OfInt LAYOUT$weighted_bipred_idc = (OfInt) LAYOUT.select(PATH$weighted_bipred_idc);
    public static final OfByte LAYOUT$pic_init_qp_minus26 = (OfByte) LAYOUT.select(PATH$pic_init_qp_minus26);
    public static final OfByte LAYOUT$pic_init_qs_minus26 = (OfByte) LAYOUT.select(PATH$pic_init_qs_minus26);
    public static final OfByte LAYOUT$chroma_qp_index_offset = (OfByte) LAYOUT.select(PATH$chroma_qp_index_offset);
    public static final OfByte LAYOUT$second_chroma_qp_index_offset = (OfByte) LAYOUT.select(PATH$second_chroma_qp_index_offset);
    public static final AddressLayout LAYOUT$pScalingLists = (AddressLayout) LAYOUT.select(PATH$pScalingLists);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$seq_parameter_set_id = LAYOUT$seq_parameter_set_id.byteSize();
    public static final long SIZE$pic_parameter_set_id = LAYOUT$pic_parameter_set_id.byteSize();
    public static final long SIZE$num_ref_idx_l0_default_active_minus1 = LAYOUT$num_ref_idx_l0_default_active_minus1.byteSize();
    public static final long SIZE$num_ref_idx_l1_default_active_minus1 = LAYOUT$num_ref_idx_l1_default_active_minus1.byteSize();
    public static final long SIZE$weighted_bipred_idc = LAYOUT$weighted_bipred_idc.byteSize();
    public static final long SIZE$pic_init_qp_minus26 = LAYOUT$pic_init_qp_minus26.byteSize();
    public static final long SIZE$pic_init_qs_minus26 = LAYOUT$pic_init_qs_minus26.byteSize();
    public static final long SIZE$chroma_qp_index_offset = LAYOUT$chroma_qp_index_offset.byteSize();
    public static final long SIZE$second_chroma_qp_index_offset = LAYOUT$second_chroma_qp_index_offset.byteSize();
    public static final long SIZE$pScalingLists = LAYOUT$pScalingLists.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$seq_parameter_set_id = LAYOUT.byteOffset(PATH$seq_parameter_set_id);
    public static final long OFFSET$pic_parameter_set_id = LAYOUT.byteOffset(PATH$pic_parameter_set_id);
    public static final long OFFSET$num_ref_idx_l0_default_active_minus1 = LAYOUT.byteOffset(PATH$num_ref_idx_l0_default_active_minus1);
    public static final long OFFSET$num_ref_idx_l1_default_active_minus1 = LAYOUT.byteOffset(PATH$num_ref_idx_l1_default_active_minus1);
    public static final long OFFSET$weighted_bipred_idc = LAYOUT.byteOffset(PATH$weighted_bipred_idc);
    public static final long OFFSET$pic_init_qp_minus26 = LAYOUT.byteOffset(PATH$pic_init_qp_minus26);
    public static final long OFFSET$pic_init_qs_minus26 = LAYOUT.byteOffset(PATH$pic_init_qs_minus26);
    public static final long OFFSET$chroma_qp_index_offset = LAYOUT.byteOffset(PATH$chroma_qp_index_offset);
    public static final long OFFSET$second_chroma_qp_index_offset = LAYOUT.byteOffset(PATH$second_chroma_qp_index_offset);
    public static final long OFFSET$pScalingLists = LAYOUT.byteOffset(PATH$pScalingLists);
}
