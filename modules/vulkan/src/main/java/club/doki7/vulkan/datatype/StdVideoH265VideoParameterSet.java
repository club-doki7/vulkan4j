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

/// Represents a pointer to a {@code StdVideoH265VideoParameterSet} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265VideoParameterSet {
///     StdVideoH265VpsFlags flags; // @link substring="StdVideoH265VpsFlags" target="StdVideoH265VpsFlags" @link substring="flags" target="#flags"
///     uint8_t vps_video_parameter_set_id; // @link substring="vps_video_parameter_set_id" target="#vps_video_parameter_set_id"
///     uint8_t vps_max_sub_layers_minus1; // @link substring="vps_max_sub_layers_minus1" target="#vps_max_sub_layers_minus1"
///     uint8_t reserved1;
///     uint8_t reserved2;
///     uint32_t vps_num_units_in_tick; // @link substring="vps_num_units_in_tick" target="#vps_num_units_in_tick"
///     uint32_t vps_time_scale; // @link substring="vps_time_scale" target="#vps_time_scale"
///     uint32_t vps_num_ticks_poc_diff_one_minus1; // @link substring="vps_num_ticks_poc_diff_one_minus1" target="#vps_num_ticks_poc_diff_one_minus1"
///     uint32_t reserved3;
///     StdVideoH265DecPicBufMgr const* pDecPicBufMgr; // optional // @link substring="StdVideoH265DecPicBufMgr" target="StdVideoH265DecPicBufMgr" @link substring="pDecPicBufMgr" target="#pDecPicBufMgr"
///     StdVideoH265HrdParameters const* pHrdParameters; // optional // @link substring="StdVideoH265HrdParameters" target="StdVideoH265HrdParameters" @link substring="pHrdParameters" target="#pHrdParameters"
///     StdVideoH265ProfileTierLevel const* pProfileTierLevel; // optional // @link substring="StdVideoH265ProfileTierLevel" target="StdVideoH265ProfileTierLevel" @link substring="pProfileTierLevel" target="#pProfileTierLevel"
/// } StdVideoH265VideoParameterSet;
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
public record StdVideoH265VideoParameterSet(@NotNull MemorySegment segment) implements IStdVideoH265VideoParameterSet {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265VideoParameterSet}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265VideoParameterSet to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265VideoParameterSet.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265VideoParameterSet, Iterable<StdVideoH265VideoParameterSet> {
        public long size() {
            return segment.byteSize() / StdVideoH265VideoParameterSet.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265VideoParameterSet at(long index) {
            return new StdVideoH265VideoParameterSet(segment.asSlice(index * StdVideoH265VideoParameterSet.BYTES, StdVideoH265VideoParameterSet.BYTES));
        }

        public StdVideoH265VideoParameterSet.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265VideoParameterSet> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265VideoParameterSet value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265VideoParameterSet.BYTES, StdVideoH265VideoParameterSet.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265VideoParameterSet.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265VideoParameterSet.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265VideoParameterSet.BYTES,
                (end - start) * StdVideoH265VideoParameterSet.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265VideoParameterSet.BYTES));
        }

        public StdVideoH265VideoParameterSet[] toArray() {
            StdVideoH265VideoParameterSet[] ret = new StdVideoH265VideoParameterSet[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265VideoParameterSet> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265VideoParameterSet> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265VideoParameterSet.BYTES;
            }

            @Override
            public StdVideoH265VideoParameterSet next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265VideoParameterSet ret = new StdVideoH265VideoParameterSet(segment.asSlice(0, StdVideoH265VideoParameterSet.BYTES));
                segment = segment.asSlice(StdVideoH265VideoParameterSet.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265VideoParameterSet allocate(Arena arena) {
        return new StdVideoH265VideoParameterSet(arena.allocate(LAYOUT));
    }

    public static StdVideoH265VideoParameterSet.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265VideoParameterSet.Ptr(segment);
    }

    public static StdVideoH265VideoParameterSet clone(Arena arena, StdVideoH265VideoParameterSet src) {
        StdVideoH265VideoParameterSet ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoH265VpsFlags flags() {
        return new StdVideoH265VpsFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoH265VideoParameterSet flags(@NotNull StdVideoH265VpsFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoH265VideoParameterSet flags(Consumer<@NotNull StdVideoH265VpsFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte vps_video_parameter_set_id() {
        return segment.get(LAYOUT$vps_video_parameter_set_id, OFFSET$vps_video_parameter_set_id);
    }

    public StdVideoH265VideoParameterSet vps_video_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$vps_video_parameter_set_id, OFFSET$vps_video_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte vps_max_sub_layers_minus1() {
        return segment.get(LAYOUT$vps_max_sub_layers_minus1, OFFSET$vps_max_sub_layers_minus1);
    }

    public StdVideoH265VideoParameterSet vps_max_sub_layers_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$vps_max_sub_layers_minus1, OFFSET$vps_max_sub_layers_minus1, value);
        return this;
    }



    public @Unsigned int vps_num_units_in_tick() {
        return segment.get(LAYOUT$vps_num_units_in_tick, OFFSET$vps_num_units_in_tick);
    }

    public StdVideoH265VideoParameterSet vps_num_units_in_tick(@Unsigned int value) {
        segment.set(LAYOUT$vps_num_units_in_tick, OFFSET$vps_num_units_in_tick, value);
        return this;
    }

    public @Unsigned int vps_time_scale() {
        return segment.get(LAYOUT$vps_time_scale, OFFSET$vps_time_scale);
    }

    public StdVideoH265VideoParameterSet vps_time_scale(@Unsigned int value) {
        segment.set(LAYOUT$vps_time_scale, OFFSET$vps_time_scale, value);
        return this;
    }

    public @Unsigned int vps_num_ticks_poc_diff_one_minus1() {
        return segment.get(LAYOUT$vps_num_ticks_poc_diff_one_minus1, OFFSET$vps_num_ticks_poc_diff_one_minus1);
    }

    public StdVideoH265VideoParameterSet vps_num_ticks_poc_diff_one_minus1(@Unsigned int value) {
        segment.set(LAYOUT$vps_num_ticks_poc_diff_one_minus1, OFFSET$vps_num_ticks_poc_diff_one_minus1, value);
        return this;
    }


    public StdVideoH265VideoParameterSet pDecPicBufMgr(@Nullable IStdVideoH265DecPicBufMgr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDecPicBufMgrRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265DecPicBufMgr.Ptr pDecPicBufMgr(int assumedCount) {
        MemorySegment s = pDecPicBufMgrRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265DecPicBufMgr.BYTES);
        return new StdVideoH265DecPicBufMgr.Ptr(s);
    }

    public @Nullable StdVideoH265DecPicBufMgr pDecPicBufMgr() {
        MemorySegment s = pDecPicBufMgrRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265DecPicBufMgr(s);
    }

    public @Pointer(target=StdVideoH265DecPicBufMgr.class) @NotNull MemorySegment pDecPicBufMgrRaw() {
        return segment.get(LAYOUT$pDecPicBufMgr, OFFSET$pDecPicBufMgr);
    }

    public void pDecPicBufMgrRaw(@Pointer(target=StdVideoH265DecPicBufMgr.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDecPicBufMgr, OFFSET$pDecPicBufMgr, value);
    }

    public StdVideoH265VideoParameterSet pHrdParameters(@Nullable IStdVideoH265HrdParameters value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pHrdParametersRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265HrdParameters.Ptr pHrdParameters(int assumedCount) {
        MemorySegment s = pHrdParametersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265HrdParameters.BYTES);
        return new StdVideoH265HrdParameters.Ptr(s);
    }

    public @Nullable StdVideoH265HrdParameters pHrdParameters() {
        MemorySegment s = pHrdParametersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265HrdParameters(s);
    }

    public @Pointer(target=StdVideoH265HrdParameters.class) @NotNull MemorySegment pHrdParametersRaw() {
        return segment.get(LAYOUT$pHrdParameters, OFFSET$pHrdParameters);
    }

    public void pHrdParametersRaw(@Pointer(target=StdVideoH265HrdParameters.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pHrdParameters, OFFSET$pHrdParameters, value);
    }

    public StdVideoH265VideoParameterSet pProfileTierLevel(@Nullable IStdVideoH265ProfileTierLevel value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pProfileTierLevelRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265ProfileTierLevel.Ptr pProfileTierLevel(int assumedCount) {
        MemorySegment s = pProfileTierLevelRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265ProfileTierLevel.BYTES);
        return new StdVideoH265ProfileTierLevel.Ptr(s);
    }

    public @Nullable StdVideoH265ProfileTierLevel pProfileTierLevel() {
        MemorySegment s = pProfileTierLevelRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265ProfileTierLevel(s);
    }

    public @Pointer(target=StdVideoH265ProfileTierLevel.class) @NotNull MemorySegment pProfileTierLevelRaw() {
        return segment.get(LAYOUT$pProfileTierLevel, OFFSET$pProfileTierLevel);
    }

    public void pProfileTierLevelRaw(@Pointer(target=StdVideoH265ProfileTierLevel.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pProfileTierLevel, OFFSET$pProfileTierLevel, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoH265VpsFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("vps_video_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("vps_max_sub_layers_minus1"),
        ValueLayout.JAVA_BYTE.withName("reserved1"),
        ValueLayout.JAVA_BYTE.withName("reserved2"),
        ValueLayout.JAVA_INT.withName("vps_num_units_in_tick"),
        ValueLayout.JAVA_INT.withName("vps_time_scale"),
        ValueLayout.JAVA_INT.withName("vps_num_ticks_poc_diff_one_minus1"),
        ValueLayout.JAVA_INT.withName("reserved3"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265DecPicBufMgr.LAYOUT).withName("pDecPicBufMgr"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265HrdParameters.LAYOUT).withName("pHrdParameters"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265ProfileTierLevel.LAYOUT).withName("pProfileTierLevel")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$vps_video_parameter_set_id = PathElement.groupElement("vps_video_parameter_set_id");
    public static final PathElement PATH$vps_max_sub_layers_minus1 = PathElement.groupElement("vps_max_sub_layers_minus1");
    public static final PathElement PATH$vps_num_units_in_tick = PathElement.groupElement("vps_num_units_in_tick");
    public static final PathElement PATH$vps_time_scale = PathElement.groupElement("vps_time_scale");
    public static final PathElement PATH$vps_num_ticks_poc_diff_one_minus1 = PathElement.groupElement("vps_num_ticks_poc_diff_one_minus1");
    public static final PathElement PATH$pDecPicBufMgr = PathElement.groupElement("pDecPicBufMgr");
    public static final PathElement PATH$pHrdParameters = PathElement.groupElement("pHrdParameters");
    public static final PathElement PATH$pProfileTierLevel = PathElement.groupElement("pProfileTierLevel");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$vps_video_parameter_set_id = (OfByte) LAYOUT.select(PATH$vps_video_parameter_set_id);
    public static final OfByte LAYOUT$vps_max_sub_layers_minus1 = (OfByte) LAYOUT.select(PATH$vps_max_sub_layers_minus1);
    public static final OfInt LAYOUT$vps_num_units_in_tick = (OfInt) LAYOUT.select(PATH$vps_num_units_in_tick);
    public static final OfInt LAYOUT$vps_time_scale = (OfInt) LAYOUT.select(PATH$vps_time_scale);
    public static final OfInt LAYOUT$vps_num_ticks_poc_diff_one_minus1 = (OfInt) LAYOUT.select(PATH$vps_num_ticks_poc_diff_one_minus1);
    public static final AddressLayout LAYOUT$pDecPicBufMgr = (AddressLayout) LAYOUT.select(PATH$pDecPicBufMgr);
    public static final AddressLayout LAYOUT$pHrdParameters = (AddressLayout) LAYOUT.select(PATH$pHrdParameters);
    public static final AddressLayout LAYOUT$pProfileTierLevel = (AddressLayout) LAYOUT.select(PATH$pProfileTierLevel);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$vps_video_parameter_set_id = LAYOUT$vps_video_parameter_set_id.byteSize();
    public static final long SIZE$vps_max_sub_layers_minus1 = LAYOUT$vps_max_sub_layers_minus1.byteSize();
    public static final long SIZE$vps_num_units_in_tick = LAYOUT$vps_num_units_in_tick.byteSize();
    public static final long SIZE$vps_time_scale = LAYOUT$vps_time_scale.byteSize();
    public static final long SIZE$vps_num_ticks_poc_diff_one_minus1 = LAYOUT$vps_num_ticks_poc_diff_one_minus1.byteSize();
    public static final long SIZE$pDecPicBufMgr = LAYOUT$pDecPicBufMgr.byteSize();
    public static final long SIZE$pHrdParameters = LAYOUT$pHrdParameters.byteSize();
    public static final long SIZE$pProfileTierLevel = LAYOUT$pProfileTierLevel.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$vps_video_parameter_set_id = LAYOUT.byteOffset(PATH$vps_video_parameter_set_id);
    public static final long OFFSET$vps_max_sub_layers_minus1 = LAYOUT.byteOffset(PATH$vps_max_sub_layers_minus1);
    public static final long OFFSET$vps_num_units_in_tick = LAYOUT.byteOffset(PATH$vps_num_units_in_tick);
    public static final long OFFSET$vps_time_scale = LAYOUT.byteOffset(PATH$vps_time_scale);
    public static final long OFFSET$vps_num_ticks_poc_diff_one_minus1 = LAYOUT.byteOffset(PATH$vps_num_ticks_poc_diff_one_minus1);
    public static final long OFFSET$pDecPicBufMgr = LAYOUT.byteOffset(PATH$pDecPicBufMgr);
    public static final long OFFSET$pHrdParameters = LAYOUT.byteOffset(PATH$pHrdParameters);
    public static final long OFFSET$pProfileTierLevel = LAYOUT.byteOffset(PATH$pProfileTierLevel);
}
