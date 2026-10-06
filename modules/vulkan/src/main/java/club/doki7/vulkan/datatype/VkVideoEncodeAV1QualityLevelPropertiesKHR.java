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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1QualityLevelPropertiesKHR.html"><code>VkVideoEncodeAV1QualityLevelPropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeAV1QualityLevelPropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeAV1RateControlFlagsKHR preferredRateControlFlags; // @link substring="VkVideoEncodeAV1RateControlFlagsKHR" target="VkVideoEncodeAV1RateControlFlagsKHR" @link substring="preferredRateControlFlags" target="#preferredRateControlFlags"
///     uint32_t preferredGopFrameCount; // @link substring="preferredGopFrameCount" target="#preferredGopFrameCount"
///     uint32_t preferredKeyFramePeriod; // @link substring="preferredKeyFramePeriod" target="#preferredKeyFramePeriod"
///     uint32_t preferredConsecutiveBipredictiveFrameCount; // @link substring="preferredConsecutiveBipredictiveFrameCount" target="#preferredConsecutiveBipredictiveFrameCount"
///     uint32_t preferredTemporalLayerCount; // @link substring="preferredTemporalLayerCount" target="#preferredTemporalLayerCount"
///     VkVideoEncodeAV1QIndexKHR preferredConstantQIndex; // @link substring="VkVideoEncodeAV1QIndexKHR" target="VkVideoEncodeAV1QIndexKHR" @link substring="preferredConstantQIndex" target="#preferredConstantQIndex"
///     uint32_t preferredMaxSingleReferenceCount; // @link substring="preferredMaxSingleReferenceCount" target="#preferredMaxSingleReferenceCount"
///     uint32_t preferredSingleReferenceNameMask; // @link substring="preferredSingleReferenceNameMask" target="#preferredSingleReferenceNameMask"
///     uint32_t preferredMaxUnidirectionalCompoundReferenceCount; // @link substring="preferredMaxUnidirectionalCompoundReferenceCount" target="#preferredMaxUnidirectionalCompoundReferenceCount"
///     uint32_t preferredMaxUnidirectionalCompoundGroup1ReferenceCount; // @link substring="preferredMaxUnidirectionalCompoundGroup1ReferenceCount" target="#preferredMaxUnidirectionalCompoundGroup1ReferenceCount"
///     uint32_t preferredUnidirectionalCompoundReferenceNameMask; // @link substring="preferredUnidirectionalCompoundReferenceNameMask" target="#preferredUnidirectionalCompoundReferenceNameMask"
///     uint32_t preferredMaxBidirectionalCompoundReferenceCount; // @link substring="preferredMaxBidirectionalCompoundReferenceCount" target="#preferredMaxBidirectionalCompoundReferenceCount"
///     uint32_t preferredMaxBidirectionalCompoundGroup1ReferenceCount; // @link substring="preferredMaxBidirectionalCompoundGroup1ReferenceCount" target="#preferredMaxBidirectionalCompoundGroup1ReferenceCount"
///     uint32_t preferredMaxBidirectionalCompoundGroup2ReferenceCount; // @link substring="preferredMaxBidirectionalCompoundGroup2ReferenceCount" target="#preferredMaxBidirectionalCompoundGroup2ReferenceCount"
///     uint32_t preferredBidirectionalCompoundReferenceNameMask; // @link substring="preferredBidirectionalCompoundReferenceNameMask" target="#preferredBidirectionalCompoundReferenceNameMask"
/// } VkVideoEncodeAV1QualityLevelPropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_AV1_QUALITY_LEVEL_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeAV1QualityLevelPropertiesKHR#allocate(Arena)}, {@link VkVideoEncodeAV1QualityLevelPropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeAV1QualityLevelPropertiesKHR#autoInit}
/// to initialize these fields manually for non-allocated instances.
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
///
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1QualityLevelPropertiesKHR.html"><code>VkVideoEncodeAV1QualityLevelPropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeAV1QualityLevelPropertiesKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeAV1QualityLevelPropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1QualityLevelPropertiesKHR.html"><code>VkVideoEncodeAV1QualityLevelPropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeAV1QualityLevelPropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeAV1QualityLevelPropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeAV1QualityLevelPropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeAV1QualityLevelPropertiesKHR, Iterable<VkVideoEncodeAV1QualityLevelPropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeAV1QualityLevelPropertiesKHR at(long index) {
            return new VkVideoEncodeAV1QualityLevelPropertiesKHR(segment.asSlice(index * VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES, VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES));
        }

        public VkVideoEncodeAV1QualityLevelPropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeAV1QualityLevelPropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeAV1QualityLevelPropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES, VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES,
                (end - start) * VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES));
        }

        public VkVideoEncodeAV1QualityLevelPropertiesKHR[] toArray() {
            VkVideoEncodeAV1QualityLevelPropertiesKHR[] ret = new VkVideoEncodeAV1QualityLevelPropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeAV1QualityLevelPropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeAV1QualityLevelPropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES;
            }

            @Override
            public VkVideoEncodeAV1QualityLevelPropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeAV1QualityLevelPropertiesKHR ret = new VkVideoEncodeAV1QualityLevelPropertiesKHR(segment.asSlice(0, VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeAV1QualityLevelPropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeAV1QualityLevelPropertiesKHR allocate(Arena arena) {
        VkVideoEncodeAV1QualityLevelPropertiesKHR ret = new VkVideoEncodeAV1QualityLevelPropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_AV1_QUALITY_LEVEL_PROPERTIES_KHR);
        return ret;
    }

    public static VkVideoEncodeAV1QualityLevelPropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeAV1QualityLevelPropertiesKHR.Ptr ret = new VkVideoEncodeAV1QualityLevelPropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_AV1_QUALITY_LEVEL_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeAV1QualityLevelPropertiesKHR clone(Arena arena, VkVideoEncodeAV1QualityLevelPropertiesKHR src) {
        VkVideoEncodeAV1QualityLevelPropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_AV1_QUALITY_LEVEL_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeAV1RateControlFlagsKHR.class) int preferredRateControlFlags() {
        return segment.get(LAYOUT$preferredRateControlFlags, OFFSET$preferredRateControlFlags);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredRateControlFlags(@Bitmask(VkVideoEncodeAV1RateControlFlagsKHR.class) int value) {
        segment.set(LAYOUT$preferredRateControlFlags, OFFSET$preferredRateControlFlags, value);
        return this;
    }

    public @Unsigned int preferredGopFrameCount() {
        return segment.get(LAYOUT$preferredGopFrameCount, OFFSET$preferredGopFrameCount);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredGopFrameCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredGopFrameCount, OFFSET$preferredGopFrameCount, value);
        return this;
    }

    public @Unsigned int preferredKeyFramePeriod() {
        return segment.get(LAYOUT$preferredKeyFramePeriod, OFFSET$preferredKeyFramePeriod);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredKeyFramePeriod(@Unsigned int value) {
        segment.set(LAYOUT$preferredKeyFramePeriod, OFFSET$preferredKeyFramePeriod, value);
        return this;
    }

    public @Unsigned int preferredConsecutiveBipredictiveFrameCount() {
        return segment.get(LAYOUT$preferredConsecutiveBipredictiveFrameCount, OFFSET$preferredConsecutiveBipredictiveFrameCount);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredConsecutiveBipredictiveFrameCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredConsecutiveBipredictiveFrameCount, OFFSET$preferredConsecutiveBipredictiveFrameCount, value);
        return this;
    }

    public @Unsigned int preferredTemporalLayerCount() {
        return segment.get(LAYOUT$preferredTemporalLayerCount, OFFSET$preferredTemporalLayerCount);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredTemporalLayerCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredTemporalLayerCount, OFFSET$preferredTemporalLayerCount, value);
        return this;
    }

    public @NotNull VkVideoEncodeAV1QIndexKHR preferredConstantQIndex() {
        return new VkVideoEncodeAV1QIndexKHR(segment.asSlice(OFFSET$preferredConstantQIndex, LAYOUT$preferredConstantQIndex));
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredConstantQIndex(@NotNull VkVideoEncodeAV1QIndexKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$preferredConstantQIndex, SIZE$preferredConstantQIndex);
        return this;
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredConstantQIndex(Consumer<@NotNull VkVideoEncodeAV1QIndexKHR> consumer) {
        consumer.accept(preferredConstantQIndex());
        return this;
    }

    public @Unsigned int preferredMaxSingleReferenceCount() {
        return segment.get(LAYOUT$preferredMaxSingleReferenceCount, OFFSET$preferredMaxSingleReferenceCount);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredMaxSingleReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredMaxSingleReferenceCount, OFFSET$preferredMaxSingleReferenceCount, value);
        return this;
    }

    public @Unsigned int preferredSingleReferenceNameMask() {
        return segment.get(LAYOUT$preferredSingleReferenceNameMask, OFFSET$preferredSingleReferenceNameMask);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredSingleReferenceNameMask(@Unsigned int value) {
        segment.set(LAYOUT$preferredSingleReferenceNameMask, OFFSET$preferredSingleReferenceNameMask, value);
        return this;
    }

    public @Unsigned int preferredMaxUnidirectionalCompoundReferenceCount() {
        return segment.get(LAYOUT$preferredMaxUnidirectionalCompoundReferenceCount, OFFSET$preferredMaxUnidirectionalCompoundReferenceCount);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredMaxUnidirectionalCompoundReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredMaxUnidirectionalCompoundReferenceCount, OFFSET$preferredMaxUnidirectionalCompoundReferenceCount, value);
        return this;
    }

    public @Unsigned int preferredMaxUnidirectionalCompoundGroup1ReferenceCount() {
        return segment.get(LAYOUT$preferredMaxUnidirectionalCompoundGroup1ReferenceCount, OFFSET$preferredMaxUnidirectionalCompoundGroup1ReferenceCount);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredMaxUnidirectionalCompoundGroup1ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredMaxUnidirectionalCompoundGroup1ReferenceCount, OFFSET$preferredMaxUnidirectionalCompoundGroup1ReferenceCount, value);
        return this;
    }

    public @Unsigned int preferredUnidirectionalCompoundReferenceNameMask() {
        return segment.get(LAYOUT$preferredUnidirectionalCompoundReferenceNameMask, OFFSET$preferredUnidirectionalCompoundReferenceNameMask);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredUnidirectionalCompoundReferenceNameMask(@Unsigned int value) {
        segment.set(LAYOUT$preferredUnidirectionalCompoundReferenceNameMask, OFFSET$preferredUnidirectionalCompoundReferenceNameMask, value);
        return this;
    }

    public @Unsigned int preferredMaxBidirectionalCompoundReferenceCount() {
        return segment.get(LAYOUT$preferredMaxBidirectionalCompoundReferenceCount, OFFSET$preferredMaxBidirectionalCompoundReferenceCount);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredMaxBidirectionalCompoundReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredMaxBidirectionalCompoundReferenceCount, OFFSET$preferredMaxBidirectionalCompoundReferenceCount, value);
        return this;
    }

    public @Unsigned int preferredMaxBidirectionalCompoundGroup1ReferenceCount() {
        return segment.get(LAYOUT$preferredMaxBidirectionalCompoundGroup1ReferenceCount, OFFSET$preferredMaxBidirectionalCompoundGroup1ReferenceCount);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredMaxBidirectionalCompoundGroup1ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredMaxBidirectionalCompoundGroup1ReferenceCount, OFFSET$preferredMaxBidirectionalCompoundGroup1ReferenceCount, value);
        return this;
    }

    public @Unsigned int preferredMaxBidirectionalCompoundGroup2ReferenceCount() {
        return segment.get(LAYOUT$preferredMaxBidirectionalCompoundGroup2ReferenceCount, OFFSET$preferredMaxBidirectionalCompoundGroup2ReferenceCount);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredMaxBidirectionalCompoundGroup2ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredMaxBidirectionalCompoundGroup2ReferenceCount, OFFSET$preferredMaxBidirectionalCompoundGroup2ReferenceCount, value);
        return this;
    }

    public @Unsigned int preferredBidirectionalCompoundReferenceNameMask() {
        return segment.get(LAYOUT$preferredBidirectionalCompoundReferenceNameMask, OFFSET$preferredBidirectionalCompoundReferenceNameMask);
    }

    public VkVideoEncodeAV1QualityLevelPropertiesKHR preferredBidirectionalCompoundReferenceNameMask(@Unsigned int value) {
        segment.set(LAYOUT$preferredBidirectionalCompoundReferenceNameMask, OFFSET$preferredBidirectionalCompoundReferenceNameMask, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("preferredRateControlFlags"),
        ValueLayout.JAVA_INT.withName("preferredGopFrameCount"),
        ValueLayout.JAVA_INT.withName("preferredKeyFramePeriod"),
        ValueLayout.JAVA_INT.withName("preferredConsecutiveBipredictiveFrameCount"),
        ValueLayout.JAVA_INT.withName("preferredTemporalLayerCount"),
        VkVideoEncodeAV1QIndexKHR.LAYOUT.withName("preferredConstantQIndex"),
        ValueLayout.JAVA_INT.withName("preferredMaxSingleReferenceCount"),
        ValueLayout.JAVA_INT.withName("preferredSingleReferenceNameMask"),
        ValueLayout.JAVA_INT.withName("preferredMaxUnidirectionalCompoundReferenceCount"),
        ValueLayout.JAVA_INT.withName("preferredMaxUnidirectionalCompoundGroup1ReferenceCount"),
        ValueLayout.JAVA_INT.withName("preferredUnidirectionalCompoundReferenceNameMask"),
        ValueLayout.JAVA_INT.withName("preferredMaxBidirectionalCompoundReferenceCount"),
        ValueLayout.JAVA_INT.withName("preferredMaxBidirectionalCompoundGroup1ReferenceCount"),
        ValueLayout.JAVA_INT.withName("preferredMaxBidirectionalCompoundGroup2ReferenceCount"),
        ValueLayout.JAVA_INT.withName("preferredBidirectionalCompoundReferenceNameMask")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$preferredRateControlFlags = PathElement.groupElement("preferredRateControlFlags");
    public static final PathElement PATH$preferredGopFrameCount = PathElement.groupElement("preferredGopFrameCount");
    public static final PathElement PATH$preferredKeyFramePeriod = PathElement.groupElement("preferredKeyFramePeriod");
    public static final PathElement PATH$preferredConsecutiveBipredictiveFrameCount = PathElement.groupElement("preferredConsecutiveBipredictiveFrameCount");
    public static final PathElement PATH$preferredTemporalLayerCount = PathElement.groupElement("preferredTemporalLayerCount");
    public static final PathElement PATH$preferredConstantQIndex = PathElement.groupElement("preferredConstantQIndex");
    public static final PathElement PATH$preferredMaxSingleReferenceCount = PathElement.groupElement("preferredMaxSingleReferenceCount");
    public static final PathElement PATH$preferredSingleReferenceNameMask = PathElement.groupElement("preferredSingleReferenceNameMask");
    public static final PathElement PATH$preferredMaxUnidirectionalCompoundReferenceCount = PathElement.groupElement("preferredMaxUnidirectionalCompoundReferenceCount");
    public static final PathElement PATH$preferredMaxUnidirectionalCompoundGroup1ReferenceCount = PathElement.groupElement("preferredMaxUnidirectionalCompoundGroup1ReferenceCount");
    public static final PathElement PATH$preferredUnidirectionalCompoundReferenceNameMask = PathElement.groupElement("preferredUnidirectionalCompoundReferenceNameMask");
    public static final PathElement PATH$preferredMaxBidirectionalCompoundReferenceCount = PathElement.groupElement("preferredMaxBidirectionalCompoundReferenceCount");
    public static final PathElement PATH$preferredMaxBidirectionalCompoundGroup1ReferenceCount = PathElement.groupElement("preferredMaxBidirectionalCompoundGroup1ReferenceCount");
    public static final PathElement PATH$preferredMaxBidirectionalCompoundGroup2ReferenceCount = PathElement.groupElement("preferredMaxBidirectionalCompoundGroup2ReferenceCount");
    public static final PathElement PATH$preferredBidirectionalCompoundReferenceNameMask = PathElement.groupElement("preferredBidirectionalCompoundReferenceNameMask");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$preferredRateControlFlags = (OfInt) LAYOUT.select(PATH$preferredRateControlFlags);
    public static final OfInt LAYOUT$preferredGopFrameCount = (OfInt) LAYOUT.select(PATH$preferredGopFrameCount);
    public static final OfInt LAYOUT$preferredKeyFramePeriod = (OfInt) LAYOUT.select(PATH$preferredKeyFramePeriod);
    public static final OfInt LAYOUT$preferredConsecutiveBipredictiveFrameCount = (OfInt) LAYOUT.select(PATH$preferredConsecutiveBipredictiveFrameCount);
    public static final OfInt LAYOUT$preferredTemporalLayerCount = (OfInt) LAYOUT.select(PATH$preferredTemporalLayerCount);
    public static final StructLayout LAYOUT$preferredConstantQIndex = (StructLayout) LAYOUT.select(PATH$preferredConstantQIndex);
    public static final OfInt LAYOUT$preferredMaxSingleReferenceCount = (OfInt) LAYOUT.select(PATH$preferredMaxSingleReferenceCount);
    public static final OfInt LAYOUT$preferredSingleReferenceNameMask = (OfInt) LAYOUT.select(PATH$preferredSingleReferenceNameMask);
    public static final OfInt LAYOUT$preferredMaxUnidirectionalCompoundReferenceCount = (OfInt) LAYOUT.select(PATH$preferredMaxUnidirectionalCompoundReferenceCount);
    public static final OfInt LAYOUT$preferredMaxUnidirectionalCompoundGroup1ReferenceCount = (OfInt) LAYOUT.select(PATH$preferredMaxUnidirectionalCompoundGroup1ReferenceCount);
    public static final OfInt LAYOUT$preferredUnidirectionalCompoundReferenceNameMask = (OfInt) LAYOUT.select(PATH$preferredUnidirectionalCompoundReferenceNameMask);
    public static final OfInt LAYOUT$preferredMaxBidirectionalCompoundReferenceCount = (OfInt) LAYOUT.select(PATH$preferredMaxBidirectionalCompoundReferenceCount);
    public static final OfInt LAYOUT$preferredMaxBidirectionalCompoundGroup1ReferenceCount = (OfInt) LAYOUT.select(PATH$preferredMaxBidirectionalCompoundGroup1ReferenceCount);
    public static final OfInt LAYOUT$preferredMaxBidirectionalCompoundGroup2ReferenceCount = (OfInt) LAYOUT.select(PATH$preferredMaxBidirectionalCompoundGroup2ReferenceCount);
    public static final OfInt LAYOUT$preferredBidirectionalCompoundReferenceNameMask = (OfInt) LAYOUT.select(PATH$preferredBidirectionalCompoundReferenceNameMask);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$preferredRateControlFlags = LAYOUT$preferredRateControlFlags.byteSize();
    public static final long SIZE$preferredGopFrameCount = LAYOUT$preferredGopFrameCount.byteSize();
    public static final long SIZE$preferredKeyFramePeriod = LAYOUT$preferredKeyFramePeriod.byteSize();
    public static final long SIZE$preferredConsecutiveBipredictiveFrameCount = LAYOUT$preferredConsecutiveBipredictiveFrameCount.byteSize();
    public static final long SIZE$preferredTemporalLayerCount = LAYOUT$preferredTemporalLayerCount.byteSize();
    public static final long SIZE$preferredConstantQIndex = LAYOUT$preferredConstantQIndex.byteSize();
    public static final long SIZE$preferredMaxSingleReferenceCount = LAYOUT$preferredMaxSingleReferenceCount.byteSize();
    public static final long SIZE$preferredSingleReferenceNameMask = LAYOUT$preferredSingleReferenceNameMask.byteSize();
    public static final long SIZE$preferredMaxUnidirectionalCompoundReferenceCount = LAYOUT$preferredMaxUnidirectionalCompoundReferenceCount.byteSize();
    public static final long SIZE$preferredMaxUnidirectionalCompoundGroup1ReferenceCount = LAYOUT$preferredMaxUnidirectionalCompoundGroup1ReferenceCount.byteSize();
    public static final long SIZE$preferredUnidirectionalCompoundReferenceNameMask = LAYOUT$preferredUnidirectionalCompoundReferenceNameMask.byteSize();
    public static final long SIZE$preferredMaxBidirectionalCompoundReferenceCount = LAYOUT$preferredMaxBidirectionalCompoundReferenceCount.byteSize();
    public static final long SIZE$preferredMaxBidirectionalCompoundGroup1ReferenceCount = LAYOUT$preferredMaxBidirectionalCompoundGroup1ReferenceCount.byteSize();
    public static final long SIZE$preferredMaxBidirectionalCompoundGroup2ReferenceCount = LAYOUT$preferredMaxBidirectionalCompoundGroup2ReferenceCount.byteSize();
    public static final long SIZE$preferredBidirectionalCompoundReferenceNameMask = LAYOUT$preferredBidirectionalCompoundReferenceNameMask.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$preferredRateControlFlags = LAYOUT.byteOffset(PATH$preferredRateControlFlags);
    public static final long OFFSET$preferredGopFrameCount = LAYOUT.byteOffset(PATH$preferredGopFrameCount);
    public static final long OFFSET$preferredKeyFramePeriod = LAYOUT.byteOffset(PATH$preferredKeyFramePeriod);
    public static final long OFFSET$preferredConsecutiveBipredictiveFrameCount = LAYOUT.byteOffset(PATH$preferredConsecutiveBipredictiveFrameCount);
    public static final long OFFSET$preferredTemporalLayerCount = LAYOUT.byteOffset(PATH$preferredTemporalLayerCount);
    public static final long OFFSET$preferredConstantQIndex = LAYOUT.byteOffset(PATH$preferredConstantQIndex);
    public static final long OFFSET$preferredMaxSingleReferenceCount = LAYOUT.byteOffset(PATH$preferredMaxSingleReferenceCount);
    public static final long OFFSET$preferredSingleReferenceNameMask = LAYOUT.byteOffset(PATH$preferredSingleReferenceNameMask);
    public static final long OFFSET$preferredMaxUnidirectionalCompoundReferenceCount = LAYOUT.byteOffset(PATH$preferredMaxUnidirectionalCompoundReferenceCount);
    public static final long OFFSET$preferredMaxUnidirectionalCompoundGroup1ReferenceCount = LAYOUT.byteOffset(PATH$preferredMaxUnidirectionalCompoundGroup1ReferenceCount);
    public static final long OFFSET$preferredUnidirectionalCompoundReferenceNameMask = LAYOUT.byteOffset(PATH$preferredUnidirectionalCompoundReferenceNameMask);
    public static final long OFFSET$preferredMaxBidirectionalCompoundReferenceCount = LAYOUT.byteOffset(PATH$preferredMaxBidirectionalCompoundReferenceCount);
    public static final long OFFSET$preferredMaxBidirectionalCompoundGroup1ReferenceCount = LAYOUT.byteOffset(PATH$preferredMaxBidirectionalCompoundGroup1ReferenceCount);
    public static final long OFFSET$preferredMaxBidirectionalCompoundGroup2ReferenceCount = LAYOUT.byteOffset(PATH$preferredMaxBidirectionalCompoundGroup2ReferenceCount);
    public static final long OFFSET$preferredBidirectionalCompoundReferenceNameMask = LAYOUT.byteOffset(PATH$preferredBidirectionalCompoundReferenceNameMask);
}
