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

/// Represents a pointer to a {@code StdVideoAV1SequenceHeader} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoAV1SequenceHeader {
///     StdVideoAV1SequenceHeaderFlags flags; // @link substring="StdVideoAV1SequenceHeaderFlags" target="StdVideoAV1SequenceHeaderFlags" @link substring="flags" target="#flags"
///     StdVideoAV1Profile seq_profile; // @link substring="StdVideoAV1Profile" target="StdVideoAV1Profile" @link substring="seq_profile" target="#seq_profile"
///     uint8_t frame_width_bits_minus_1; // @link substring="frame_width_bits_minus_1" target="#frame_width_bits_minus_1"
///     uint8_t frame_height_bits_minus_1; // @link substring="frame_height_bits_minus_1" target="#frame_height_bits_minus_1"
///     uint16_t max_frame_width_minus_1; // @link substring="max_frame_width_minus_1" target="#max_frame_width_minus_1"
///     uint16_t max_frame_height_minus_1; // @link substring="max_frame_height_minus_1" target="#max_frame_height_minus_1"
///     uint8_t delta_frame_id_length_minus_2; // @link substring="delta_frame_id_length_minus_2" target="#delta_frame_id_length_minus_2"
///     uint8_t additional_frame_id_length_minus_1; // @link substring="additional_frame_id_length_minus_1" target="#additional_frame_id_length_minus_1"
///     uint8_t order_hint_bits_minus_1; // @link substring="order_hint_bits_minus_1" target="#order_hint_bits_minus_1"
///     uint8_t seq_force_integer_mv; // @link substring="seq_force_integer_mv" target="#seq_force_integer_mv"
///     uint8_t seq_force_screen_content_tools; // @link substring="seq_force_screen_content_tools" target="#seq_force_screen_content_tools"
///     uint8_t[5] reserved1;
///     StdVideoAV1ColorConfig const* pColorConfig; // @link substring="StdVideoAV1ColorConfig" target="StdVideoAV1ColorConfig" @link substring="pColorConfig" target="#pColorConfig"
///     StdVideoAV1TimingInfo const* pTimingInfo; // optional // @link substring="StdVideoAV1TimingInfo" target="StdVideoAV1TimingInfo" @link substring="pTimingInfo" target="#pTimingInfo"
/// } StdVideoAV1SequenceHeader;
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
public record StdVideoAV1SequenceHeader(@NotNull MemorySegment segment) implements IStdVideoAV1SequenceHeader {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoAV1SequenceHeader}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoAV1SequenceHeader to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoAV1SequenceHeader.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoAV1SequenceHeader, Iterable<StdVideoAV1SequenceHeader> {
        public long size() {
            return segment.byteSize() / StdVideoAV1SequenceHeader.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoAV1SequenceHeader at(long index) {
            return new StdVideoAV1SequenceHeader(segment.asSlice(index * StdVideoAV1SequenceHeader.BYTES, StdVideoAV1SequenceHeader.BYTES));
        }

        public StdVideoAV1SequenceHeader.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoAV1SequenceHeader> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoAV1SequenceHeader value) {
            MemorySegment s = segment.asSlice(index * StdVideoAV1SequenceHeader.BYTES, StdVideoAV1SequenceHeader.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoAV1SequenceHeader.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoAV1SequenceHeader.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoAV1SequenceHeader.BYTES,
                (end - start) * StdVideoAV1SequenceHeader.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoAV1SequenceHeader.BYTES));
        }

        public StdVideoAV1SequenceHeader[] toArray() {
            StdVideoAV1SequenceHeader[] ret = new StdVideoAV1SequenceHeader[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoAV1SequenceHeader> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoAV1SequenceHeader> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoAV1SequenceHeader.BYTES;
            }

            @Override
            public StdVideoAV1SequenceHeader next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoAV1SequenceHeader ret = new StdVideoAV1SequenceHeader(segment.asSlice(0, StdVideoAV1SequenceHeader.BYTES));
                segment = segment.asSlice(StdVideoAV1SequenceHeader.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoAV1SequenceHeader allocate(Arena arena) {
        return new StdVideoAV1SequenceHeader(arena.allocate(LAYOUT));
    }

    public static StdVideoAV1SequenceHeader.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoAV1SequenceHeader.Ptr(segment);
    }

    public static StdVideoAV1SequenceHeader clone(Arena arena, StdVideoAV1SequenceHeader src) {
        StdVideoAV1SequenceHeader ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoAV1SequenceHeaderFlags flags() {
        return new StdVideoAV1SequenceHeaderFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoAV1SequenceHeader flags(@NotNull StdVideoAV1SequenceHeaderFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoAV1SequenceHeader flags(Consumer<@NotNull StdVideoAV1SequenceHeaderFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @EnumType(StdVideoAV1Profile.class) int seq_profile() {
        return segment.get(LAYOUT$seq_profile, OFFSET$seq_profile);
    }

    public StdVideoAV1SequenceHeader seq_profile(@EnumType(StdVideoAV1Profile.class) int value) {
        segment.set(LAYOUT$seq_profile, OFFSET$seq_profile, value);
        return this;
    }

    public @Unsigned byte frame_width_bits_minus_1() {
        return segment.get(LAYOUT$frame_width_bits_minus_1, OFFSET$frame_width_bits_minus_1);
    }

    public StdVideoAV1SequenceHeader frame_width_bits_minus_1(@Unsigned byte value) {
        segment.set(LAYOUT$frame_width_bits_minus_1, OFFSET$frame_width_bits_minus_1, value);
        return this;
    }

    public @Unsigned byte frame_height_bits_minus_1() {
        return segment.get(LAYOUT$frame_height_bits_minus_1, OFFSET$frame_height_bits_minus_1);
    }

    public StdVideoAV1SequenceHeader frame_height_bits_minus_1(@Unsigned byte value) {
        segment.set(LAYOUT$frame_height_bits_minus_1, OFFSET$frame_height_bits_minus_1, value);
        return this;
    }

    public @Unsigned short max_frame_width_minus_1() {
        return segment.get(LAYOUT$max_frame_width_minus_1, OFFSET$max_frame_width_minus_1);
    }

    public StdVideoAV1SequenceHeader max_frame_width_minus_1(@Unsigned short value) {
        segment.set(LAYOUT$max_frame_width_minus_1, OFFSET$max_frame_width_minus_1, value);
        return this;
    }

    public @Unsigned short max_frame_height_minus_1() {
        return segment.get(LAYOUT$max_frame_height_minus_1, OFFSET$max_frame_height_minus_1);
    }

    public StdVideoAV1SequenceHeader max_frame_height_minus_1(@Unsigned short value) {
        segment.set(LAYOUT$max_frame_height_minus_1, OFFSET$max_frame_height_minus_1, value);
        return this;
    }

    public @Unsigned byte delta_frame_id_length_minus_2() {
        return segment.get(LAYOUT$delta_frame_id_length_minus_2, OFFSET$delta_frame_id_length_minus_2);
    }

    public StdVideoAV1SequenceHeader delta_frame_id_length_minus_2(@Unsigned byte value) {
        segment.set(LAYOUT$delta_frame_id_length_minus_2, OFFSET$delta_frame_id_length_minus_2, value);
        return this;
    }

    public @Unsigned byte additional_frame_id_length_minus_1() {
        return segment.get(LAYOUT$additional_frame_id_length_minus_1, OFFSET$additional_frame_id_length_minus_1);
    }

    public StdVideoAV1SequenceHeader additional_frame_id_length_minus_1(@Unsigned byte value) {
        segment.set(LAYOUT$additional_frame_id_length_minus_1, OFFSET$additional_frame_id_length_minus_1, value);
        return this;
    }

    public @Unsigned byte order_hint_bits_minus_1() {
        return segment.get(LAYOUT$order_hint_bits_minus_1, OFFSET$order_hint_bits_minus_1);
    }

    public StdVideoAV1SequenceHeader order_hint_bits_minus_1(@Unsigned byte value) {
        segment.set(LAYOUT$order_hint_bits_minus_1, OFFSET$order_hint_bits_minus_1, value);
        return this;
    }

    public @Unsigned byte seq_force_integer_mv() {
        return segment.get(LAYOUT$seq_force_integer_mv, OFFSET$seq_force_integer_mv);
    }

    public StdVideoAV1SequenceHeader seq_force_integer_mv(@Unsigned byte value) {
        segment.set(LAYOUT$seq_force_integer_mv, OFFSET$seq_force_integer_mv, value);
        return this;
    }

    public @Unsigned byte seq_force_screen_content_tools() {
        return segment.get(LAYOUT$seq_force_screen_content_tools, OFFSET$seq_force_screen_content_tools);
    }

    public StdVideoAV1SequenceHeader seq_force_screen_content_tools(@Unsigned byte value) {
        segment.set(LAYOUT$seq_force_screen_content_tools, OFFSET$seq_force_screen_content_tools, value);
        return this;
    }


    public StdVideoAV1SequenceHeader pColorConfig(@Nullable IStdVideoAV1ColorConfig value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pColorConfigRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoAV1ColorConfig.Ptr pColorConfig(int assumedCount) {
        MemorySegment s = pColorConfigRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoAV1ColorConfig.BYTES);
        return new StdVideoAV1ColorConfig.Ptr(s);
    }

    public @Nullable StdVideoAV1ColorConfig pColorConfig() {
        MemorySegment s = pColorConfigRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoAV1ColorConfig(s);
    }

    public @Pointer(target=StdVideoAV1ColorConfig.class) @NotNull MemorySegment pColorConfigRaw() {
        return segment.get(LAYOUT$pColorConfig, OFFSET$pColorConfig);
    }

    public void pColorConfigRaw(@Pointer(target=StdVideoAV1ColorConfig.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pColorConfig, OFFSET$pColorConfig, value);
    }

    public StdVideoAV1SequenceHeader pTimingInfo(@Nullable IStdVideoAV1TimingInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTimingInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoAV1TimingInfo.Ptr pTimingInfo(int assumedCount) {
        MemorySegment s = pTimingInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoAV1TimingInfo.BYTES);
        return new StdVideoAV1TimingInfo.Ptr(s);
    }

    public @Nullable StdVideoAV1TimingInfo pTimingInfo() {
        MemorySegment s = pTimingInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoAV1TimingInfo(s);
    }

    public @Pointer(target=StdVideoAV1TimingInfo.class) @NotNull MemorySegment pTimingInfoRaw() {
        return segment.get(LAYOUT$pTimingInfo, OFFSET$pTimingInfo);
    }

    public void pTimingInfoRaw(@Pointer(target=StdVideoAV1TimingInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTimingInfo, OFFSET$pTimingInfo, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoAV1SequenceHeaderFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("seq_profile"),
        ValueLayout.JAVA_BYTE.withName("frame_width_bits_minus_1"),
        ValueLayout.JAVA_BYTE.withName("frame_height_bits_minus_1"),
        ValueLayout.JAVA_SHORT.withName("max_frame_width_minus_1"),
        ValueLayout.JAVA_SHORT.withName("max_frame_height_minus_1"),
        ValueLayout.JAVA_BYTE.withName("delta_frame_id_length_minus_2"),
        ValueLayout.JAVA_BYTE.withName("additional_frame_id_length_minus_1"),
        ValueLayout.JAVA_BYTE.withName("order_hint_bits_minus_1"),
        ValueLayout.JAVA_BYTE.withName("seq_force_integer_mv"),
        ValueLayout.JAVA_BYTE.withName("seq_force_screen_content_tools"),
        MemoryLayout.sequenceLayout(5, ValueLayout.JAVA_BYTE).withName("reserved1"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoAV1ColorConfig.LAYOUT).withName("pColorConfig"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoAV1TimingInfo.LAYOUT).withName("pTimingInfo")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$seq_profile = PathElement.groupElement("seq_profile");
    public static final PathElement PATH$frame_width_bits_minus_1 = PathElement.groupElement("frame_width_bits_minus_1");
    public static final PathElement PATH$frame_height_bits_minus_1 = PathElement.groupElement("frame_height_bits_minus_1");
    public static final PathElement PATH$max_frame_width_minus_1 = PathElement.groupElement("max_frame_width_minus_1");
    public static final PathElement PATH$max_frame_height_minus_1 = PathElement.groupElement("max_frame_height_minus_1");
    public static final PathElement PATH$delta_frame_id_length_minus_2 = PathElement.groupElement("delta_frame_id_length_minus_2");
    public static final PathElement PATH$additional_frame_id_length_minus_1 = PathElement.groupElement("additional_frame_id_length_minus_1");
    public static final PathElement PATH$order_hint_bits_minus_1 = PathElement.groupElement("order_hint_bits_minus_1");
    public static final PathElement PATH$seq_force_integer_mv = PathElement.groupElement("seq_force_integer_mv");
    public static final PathElement PATH$seq_force_screen_content_tools = PathElement.groupElement("seq_force_screen_content_tools");
    public static final PathElement PATH$pColorConfig = PathElement.groupElement("pColorConfig");
    public static final PathElement PATH$pTimingInfo = PathElement.groupElement("pTimingInfo");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$seq_profile = (OfInt) LAYOUT.select(PATH$seq_profile);
    public static final OfByte LAYOUT$frame_width_bits_minus_1 = (OfByte) LAYOUT.select(PATH$frame_width_bits_minus_1);
    public static final OfByte LAYOUT$frame_height_bits_minus_1 = (OfByte) LAYOUT.select(PATH$frame_height_bits_minus_1);
    public static final OfShort LAYOUT$max_frame_width_minus_1 = (OfShort) LAYOUT.select(PATH$max_frame_width_minus_1);
    public static final OfShort LAYOUT$max_frame_height_minus_1 = (OfShort) LAYOUT.select(PATH$max_frame_height_minus_1);
    public static final OfByte LAYOUT$delta_frame_id_length_minus_2 = (OfByte) LAYOUT.select(PATH$delta_frame_id_length_minus_2);
    public static final OfByte LAYOUT$additional_frame_id_length_minus_1 = (OfByte) LAYOUT.select(PATH$additional_frame_id_length_minus_1);
    public static final OfByte LAYOUT$order_hint_bits_minus_1 = (OfByte) LAYOUT.select(PATH$order_hint_bits_minus_1);
    public static final OfByte LAYOUT$seq_force_integer_mv = (OfByte) LAYOUT.select(PATH$seq_force_integer_mv);
    public static final OfByte LAYOUT$seq_force_screen_content_tools = (OfByte) LAYOUT.select(PATH$seq_force_screen_content_tools);
    public static final AddressLayout LAYOUT$pColorConfig = (AddressLayout) LAYOUT.select(PATH$pColorConfig);
    public static final AddressLayout LAYOUT$pTimingInfo = (AddressLayout) LAYOUT.select(PATH$pTimingInfo);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$seq_profile = LAYOUT$seq_profile.byteSize();
    public static final long SIZE$frame_width_bits_minus_1 = LAYOUT$frame_width_bits_minus_1.byteSize();
    public static final long SIZE$frame_height_bits_minus_1 = LAYOUT$frame_height_bits_minus_1.byteSize();
    public static final long SIZE$max_frame_width_minus_1 = LAYOUT$max_frame_width_minus_1.byteSize();
    public static final long SIZE$max_frame_height_minus_1 = LAYOUT$max_frame_height_minus_1.byteSize();
    public static final long SIZE$delta_frame_id_length_minus_2 = LAYOUT$delta_frame_id_length_minus_2.byteSize();
    public static final long SIZE$additional_frame_id_length_minus_1 = LAYOUT$additional_frame_id_length_minus_1.byteSize();
    public static final long SIZE$order_hint_bits_minus_1 = LAYOUT$order_hint_bits_minus_1.byteSize();
    public static final long SIZE$seq_force_integer_mv = LAYOUT$seq_force_integer_mv.byteSize();
    public static final long SIZE$seq_force_screen_content_tools = LAYOUT$seq_force_screen_content_tools.byteSize();
    public static final long SIZE$pColorConfig = LAYOUT$pColorConfig.byteSize();
    public static final long SIZE$pTimingInfo = LAYOUT$pTimingInfo.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$seq_profile = LAYOUT.byteOffset(PATH$seq_profile);
    public static final long OFFSET$frame_width_bits_minus_1 = LAYOUT.byteOffset(PATH$frame_width_bits_minus_1);
    public static final long OFFSET$frame_height_bits_minus_1 = LAYOUT.byteOffset(PATH$frame_height_bits_minus_1);
    public static final long OFFSET$max_frame_width_minus_1 = LAYOUT.byteOffset(PATH$max_frame_width_minus_1);
    public static final long OFFSET$max_frame_height_minus_1 = LAYOUT.byteOffset(PATH$max_frame_height_minus_1);
    public static final long OFFSET$delta_frame_id_length_minus_2 = LAYOUT.byteOffset(PATH$delta_frame_id_length_minus_2);
    public static final long OFFSET$additional_frame_id_length_minus_1 = LAYOUT.byteOffset(PATH$additional_frame_id_length_minus_1);
    public static final long OFFSET$order_hint_bits_minus_1 = LAYOUT.byteOffset(PATH$order_hint_bits_minus_1);
    public static final long OFFSET$seq_force_integer_mv = LAYOUT.byteOffset(PATH$seq_force_integer_mv);
    public static final long OFFSET$seq_force_screen_content_tools = LAYOUT.byteOffset(PATH$seq_force_screen_content_tools);
    public static final long OFFSET$pColorConfig = LAYOUT.byteOffset(PATH$pColorConfig);
    public static final long OFFSET$pTimingInfo = LAYOUT.byteOffset(PATH$pTimingInfo);
}
