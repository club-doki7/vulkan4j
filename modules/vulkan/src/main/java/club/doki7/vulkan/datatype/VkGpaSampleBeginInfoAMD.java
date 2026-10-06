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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGpaSampleBeginInfoAMD.html"><code>VkGpaSampleBeginInfoAMD</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGpaSampleBeginInfoAMD {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkGpaSampleTypeAMD sampleType; // @link substring="VkGpaSampleTypeAMD" target="VkGpaSampleTypeAMD" @link substring="sampleType" target="#sampleType"
///     VkBool32 sampleInternalOperations; // @link substring="sampleInternalOperations" target="#sampleInternalOperations"
///     VkBool32 cacheFlushOnCounterCollection; // @link substring="cacheFlushOnCounterCollection" target="#cacheFlushOnCounterCollection"
///     VkBool32 sqShaderMaskEnable; // @link substring="sqShaderMaskEnable" target="#sqShaderMaskEnable"
///     VkGpaSqShaderStageFlagsAMD sqShaderMask; // optional // @link substring="VkGpaSqShaderStageFlagsAMD" target="VkGpaSqShaderStageFlagsAMD" @link substring="sqShaderMask" target="#sqShaderMask"
///     uint32_t perfCounterCount; // @link substring="perfCounterCount" target="#perfCounterCount"
///     VkGpaPerfCounterAMD const* pPerfCounters; // @link substring="VkGpaPerfCounterAMD" target="VkGpaPerfCounterAMD" @link substring="pPerfCounters" target="#pPerfCounters"
///     uint32_t streamingPerfTraceSampleInterval; // @link substring="streamingPerfTraceSampleInterval" target="#streamingPerfTraceSampleInterval"
///     VkDeviceSize perfCounterDeviceMemoryLimit; // @link substring="perfCounterDeviceMemoryLimit" target="#perfCounterDeviceMemoryLimit"
///     VkBool32 sqThreadTraceEnable; // @link substring="sqThreadTraceEnable" target="#sqThreadTraceEnable"
///     VkBool32 sqThreadTraceSuppressInstructionTokens; // @link substring="sqThreadTraceSuppressInstructionTokens" target="#sqThreadTraceSuppressInstructionTokens"
///     VkDeviceSize sqThreadTraceDeviceMemoryLimit; // @link substring="sqThreadTraceDeviceMemoryLimit" target="#sqThreadTraceDeviceMemoryLimit"
///     VkPipelineStageFlags timingPreSample; // optional // @link substring="VkPipelineStageFlags" target="VkPipelineStageFlags" @link substring="timingPreSample" target="#timingPreSample"
///     VkPipelineStageFlags timingPostSample; // optional // @link substring="VkPipelineStageFlags" target="VkPipelineStageFlags" @link substring="timingPostSample" target="#timingPostSample"
/// } VkGpaSampleBeginInfoAMD;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_GPA_SAMPLE_BEGIN_INFO_AMD`
///
/// The {@code allocate} ({@link VkGpaSampleBeginInfoAMD#allocate(Arena)}, {@link VkGpaSampleBeginInfoAMD#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkGpaSampleBeginInfoAMD#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGpaSampleBeginInfoAMD.html"><code>VkGpaSampleBeginInfoAMD</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGpaSampleBeginInfoAMD(@NotNull MemorySegment segment) implements IVkGpaSampleBeginInfoAMD {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGpaSampleBeginInfoAMD.html"><code>VkGpaSampleBeginInfoAMD</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGpaSampleBeginInfoAMD}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGpaSampleBeginInfoAMD to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGpaSampleBeginInfoAMD.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGpaSampleBeginInfoAMD, Iterable<VkGpaSampleBeginInfoAMD> {
        public long size() {
            return segment.byteSize() / VkGpaSampleBeginInfoAMD.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGpaSampleBeginInfoAMD at(long index) {
            return new VkGpaSampleBeginInfoAMD(segment.asSlice(index * VkGpaSampleBeginInfoAMD.BYTES, VkGpaSampleBeginInfoAMD.BYTES));
        }

        public VkGpaSampleBeginInfoAMD.Ptr at(long index, @NotNull Consumer<@NotNull VkGpaSampleBeginInfoAMD> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGpaSampleBeginInfoAMD value) {
            MemorySegment s = segment.asSlice(index * VkGpaSampleBeginInfoAMD.BYTES, VkGpaSampleBeginInfoAMD.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGpaSampleBeginInfoAMD.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGpaSampleBeginInfoAMD.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGpaSampleBeginInfoAMD.BYTES,
                (end - start) * VkGpaSampleBeginInfoAMD.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGpaSampleBeginInfoAMD.BYTES));
        }

        public VkGpaSampleBeginInfoAMD[] toArray() {
            VkGpaSampleBeginInfoAMD[] ret = new VkGpaSampleBeginInfoAMD[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGpaSampleBeginInfoAMD> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGpaSampleBeginInfoAMD> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGpaSampleBeginInfoAMD.BYTES;
            }

            @Override
            public VkGpaSampleBeginInfoAMD next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGpaSampleBeginInfoAMD ret = new VkGpaSampleBeginInfoAMD(segment.asSlice(0, VkGpaSampleBeginInfoAMD.BYTES));
                segment = segment.asSlice(VkGpaSampleBeginInfoAMD.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGpaSampleBeginInfoAMD allocate(Arena arena) {
        VkGpaSampleBeginInfoAMD ret = new VkGpaSampleBeginInfoAMD(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.GPA_SAMPLE_BEGIN_INFO_AMD);
        return ret;
    }

    public static VkGpaSampleBeginInfoAMD.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkGpaSampleBeginInfoAMD.Ptr ret = new VkGpaSampleBeginInfoAMD.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.GPA_SAMPLE_BEGIN_INFO_AMD);
        }
        return ret;
    }

    public static VkGpaSampleBeginInfoAMD clone(Arena arena, VkGpaSampleBeginInfoAMD src) {
        VkGpaSampleBeginInfoAMD ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.GPA_SAMPLE_BEGIN_INFO_AMD);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkGpaSampleBeginInfoAMD sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkGpaSampleBeginInfoAMD pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkGpaSampleBeginInfoAMD pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkGpaSampleTypeAMD.class) int sampleType() {
        return segment.get(LAYOUT$sampleType, OFFSET$sampleType);
    }

    public VkGpaSampleBeginInfoAMD sampleType(@EnumType(VkGpaSampleTypeAMD.class) int value) {
        segment.set(LAYOUT$sampleType, OFFSET$sampleType, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sampleInternalOperations() {
        return segment.get(LAYOUT$sampleInternalOperations, OFFSET$sampleInternalOperations);
    }

    public VkGpaSampleBeginInfoAMD sampleInternalOperations(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sampleInternalOperations, OFFSET$sampleInternalOperations, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int cacheFlushOnCounterCollection() {
        return segment.get(LAYOUT$cacheFlushOnCounterCollection, OFFSET$cacheFlushOnCounterCollection);
    }

    public VkGpaSampleBeginInfoAMD cacheFlushOnCounterCollection(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$cacheFlushOnCounterCollection, OFFSET$cacheFlushOnCounterCollection, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sqShaderMaskEnable() {
        return segment.get(LAYOUT$sqShaderMaskEnable, OFFSET$sqShaderMaskEnable);
    }

    public VkGpaSampleBeginInfoAMD sqShaderMaskEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sqShaderMaskEnable, OFFSET$sqShaderMaskEnable, value);
        return this;
    }

    public @Bitmask(VkGpaSqShaderStageFlagsAMD.class) int sqShaderMask() {
        return segment.get(LAYOUT$sqShaderMask, OFFSET$sqShaderMask);
    }

    public VkGpaSampleBeginInfoAMD sqShaderMask(@Bitmask(VkGpaSqShaderStageFlagsAMD.class) int value) {
        segment.set(LAYOUT$sqShaderMask, OFFSET$sqShaderMask, value);
        return this;
    }

    public @Unsigned int perfCounterCount() {
        return segment.get(LAYOUT$perfCounterCount, OFFSET$perfCounterCount);
    }

    public VkGpaSampleBeginInfoAMD perfCounterCount(@Unsigned int value) {
        segment.set(LAYOUT$perfCounterCount, OFFSET$perfCounterCount, value);
        return this;
    }

    public VkGpaSampleBeginInfoAMD pPerfCounters(@Nullable IVkGpaPerfCounterAMD value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPerfCountersRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkGpaPerfCounterAMD.Ptr pPerfCounters(int assumedCount) {
        MemorySegment s = pPerfCountersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkGpaPerfCounterAMD.BYTES);
        return new VkGpaPerfCounterAMD.Ptr(s);
    }

    public @Nullable VkGpaPerfCounterAMD pPerfCounters() {
        MemorySegment s = pPerfCountersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkGpaPerfCounterAMD(s);
    }

    public @Pointer(target=VkGpaPerfCounterAMD.class) @NotNull MemorySegment pPerfCountersRaw() {
        return segment.get(LAYOUT$pPerfCounters, OFFSET$pPerfCounters);
    }

    public void pPerfCountersRaw(@Pointer(target=VkGpaPerfCounterAMD.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPerfCounters, OFFSET$pPerfCounters, value);
    }

    public @Unsigned int streamingPerfTraceSampleInterval() {
        return segment.get(LAYOUT$streamingPerfTraceSampleInterval, OFFSET$streamingPerfTraceSampleInterval);
    }

    public VkGpaSampleBeginInfoAMD streamingPerfTraceSampleInterval(@Unsigned int value) {
        segment.set(LAYOUT$streamingPerfTraceSampleInterval, OFFSET$streamingPerfTraceSampleInterval, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long perfCounterDeviceMemoryLimit() {
        return segment.get(LAYOUT$perfCounterDeviceMemoryLimit, OFFSET$perfCounterDeviceMemoryLimit);
    }

    public VkGpaSampleBeginInfoAMD perfCounterDeviceMemoryLimit(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$perfCounterDeviceMemoryLimit, OFFSET$perfCounterDeviceMemoryLimit, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sqThreadTraceEnable() {
        return segment.get(LAYOUT$sqThreadTraceEnable, OFFSET$sqThreadTraceEnable);
    }

    public VkGpaSampleBeginInfoAMD sqThreadTraceEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sqThreadTraceEnable, OFFSET$sqThreadTraceEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sqThreadTraceSuppressInstructionTokens() {
        return segment.get(LAYOUT$sqThreadTraceSuppressInstructionTokens, OFFSET$sqThreadTraceSuppressInstructionTokens);
    }

    public VkGpaSampleBeginInfoAMD sqThreadTraceSuppressInstructionTokens(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sqThreadTraceSuppressInstructionTokens, OFFSET$sqThreadTraceSuppressInstructionTokens, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long sqThreadTraceDeviceMemoryLimit() {
        return segment.get(LAYOUT$sqThreadTraceDeviceMemoryLimit, OFFSET$sqThreadTraceDeviceMemoryLimit);
    }

    public VkGpaSampleBeginInfoAMD sqThreadTraceDeviceMemoryLimit(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$sqThreadTraceDeviceMemoryLimit, OFFSET$sqThreadTraceDeviceMemoryLimit, value);
        return this;
    }

    public @Bitmask(VkPipelineStageFlags.class) int timingPreSample() {
        return segment.get(LAYOUT$timingPreSample, OFFSET$timingPreSample);
    }

    public VkGpaSampleBeginInfoAMD timingPreSample(@Bitmask(VkPipelineStageFlags.class) int value) {
        segment.set(LAYOUT$timingPreSample, OFFSET$timingPreSample, value);
        return this;
    }

    public @Bitmask(VkPipelineStageFlags.class) int timingPostSample() {
        return segment.get(LAYOUT$timingPostSample, OFFSET$timingPostSample);
    }

    public VkGpaSampleBeginInfoAMD timingPostSample(@Bitmask(VkPipelineStageFlags.class) int value) {
        segment.set(LAYOUT$timingPostSample, OFFSET$timingPostSample, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("sampleType"),
        ValueLayout.JAVA_INT.withName("sampleInternalOperations"),
        ValueLayout.JAVA_INT.withName("cacheFlushOnCounterCollection"),
        ValueLayout.JAVA_INT.withName("sqShaderMaskEnable"),
        ValueLayout.JAVA_INT.withName("sqShaderMask"),
        ValueLayout.JAVA_INT.withName("perfCounterCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkGpaPerfCounterAMD.LAYOUT).withName("pPerfCounters"),
        ValueLayout.JAVA_INT.withName("streamingPerfTraceSampleInterval"),
        ValueLayout.JAVA_LONG.withName("perfCounterDeviceMemoryLimit"),
        ValueLayout.JAVA_INT.withName("sqThreadTraceEnable"),
        ValueLayout.JAVA_INT.withName("sqThreadTraceSuppressInstructionTokens"),
        ValueLayout.JAVA_LONG.withName("sqThreadTraceDeviceMemoryLimit"),
        ValueLayout.JAVA_INT.withName("timingPreSample"),
        ValueLayout.JAVA_INT.withName("timingPostSample")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$sampleType = PathElement.groupElement("sampleType");
    public static final PathElement PATH$sampleInternalOperations = PathElement.groupElement("sampleInternalOperations");
    public static final PathElement PATH$cacheFlushOnCounterCollection = PathElement.groupElement("cacheFlushOnCounterCollection");
    public static final PathElement PATH$sqShaderMaskEnable = PathElement.groupElement("sqShaderMaskEnable");
    public static final PathElement PATH$sqShaderMask = PathElement.groupElement("sqShaderMask");
    public static final PathElement PATH$perfCounterCount = PathElement.groupElement("perfCounterCount");
    public static final PathElement PATH$pPerfCounters = PathElement.groupElement("pPerfCounters");
    public static final PathElement PATH$streamingPerfTraceSampleInterval = PathElement.groupElement("streamingPerfTraceSampleInterval");
    public static final PathElement PATH$perfCounterDeviceMemoryLimit = PathElement.groupElement("perfCounterDeviceMemoryLimit");
    public static final PathElement PATH$sqThreadTraceEnable = PathElement.groupElement("sqThreadTraceEnable");
    public static final PathElement PATH$sqThreadTraceSuppressInstructionTokens = PathElement.groupElement("sqThreadTraceSuppressInstructionTokens");
    public static final PathElement PATH$sqThreadTraceDeviceMemoryLimit = PathElement.groupElement("sqThreadTraceDeviceMemoryLimit");
    public static final PathElement PATH$timingPreSample = PathElement.groupElement("timingPreSample");
    public static final PathElement PATH$timingPostSample = PathElement.groupElement("timingPostSample");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$sampleType = (OfInt) LAYOUT.select(PATH$sampleType);
    public static final OfInt LAYOUT$sampleInternalOperations = (OfInt) LAYOUT.select(PATH$sampleInternalOperations);
    public static final OfInt LAYOUT$cacheFlushOnCounterCollection = (OfInt) LAYOUT.select(PATH$cacheFlushOnCounterCollection);
    public static final OfInt LAYOUT$sqShaderMaskEnable = (OfInt) LAYOUT.select(PATH$sqShaderMaskEnable);
    public static final OfInt LAYOUT$sqShaderMask = (OfInt) LAYOUT.select(PATH$sqShaderMask);
    public static final OfInt LAYOUT$perfCounterCount = (OfInt) LAYOUT.select(PATH$perfCounterCount);
    public static final AddressLayout LAYOUT$pPerfCounters = (AddressLayout) LAYOUT.select(PATH$pPerfCounters);
    public static final OfInt LAYOUT$streamingPerfTraceSampleInterval = (OfInt) LAYOUT.select(PATH$streamingPerfTraceSampleInterval);
    public static final OfLong LAYOUT$perfCounterDeviceMemoryLimit = (OfLong) LAYOUT.select(PATH$perfCounterDeviceMemoryLimit);
    public static final OfInt LAYOUT$sqThreadTraceEnable = (OfInt) LAYOUT.select(PATH$sqThreadTraceEnable);
    public static final OfInt LAYOUT$sqThreadTraceSuppressInstructionTokens = (OfInt) LAYOUT.select(PATH$sqThreadTraceSuppressInstructionTokens);
    public static final OfLong LAYOUT$sqThreadTraceDeviceMemoryLimit = (OfLong) LAYOUT.select(PATH$sqThreadTraceDeviceMemoryLimit);
    public static final OfInt LAYOUT$timingPreSample = (OfInt) LAYOUT.select(PATH$timingPreSample);
    public static final OfInt LAYOUT$timingPostSample = (OfInt) LAYOUT.select(PATH$timingPostSample);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$sampleType = LAYOUT$sampleType.byteSize();
    public static final long SIZE$sampleInternalOperations = LAYOUT$sampleInternalOperations.byteSize();
    public static final long SIZE$cacheFlushOnCounterCollection = LAYOUT$cacheFlushOnCounterCollection.byteSize();
    public static final long SIZE$sqShaderMaskEnable = LAYOUT$sqShaderMaskEnable.byteSize();
    public static final long SIZE$sqShaderMask = LAYOUT$sqShaderMask.byteSize();
    public static final long SIZE$perfCounterCount = LAYOUT$perfCounterCount.byteSize();
    public static final long SIZE$pPerfCounters = LAYOUT$pPerfCounters.byteSize();
    public static final long SIZE$streamingPerfTraceSampleInterval = LAYOUT$streamingPerfTraceSampleInterval.byteSize();
    public static final long SIZE$perfCounterDeviceMemoryLimit = LAYOUT$perfCounterDeviceMemoryLimit.byteSize();
    public static final long SIZE$sqThreadTraceEnable = LAYOUT$sqThreadTraceEnable.byteSize();
    public static final long SIZE$sqThreadTraceSuppressInstructionTokens = LAYOUT$sqThreadTraceSuppressInstructionTokens.byteSize();
    public static final long SIZE$sqThreadTraceDeviceMemoryLimit = LAYOUT$sqThreadTraceDeviceMemoryLimit.byteSize();
    public static final long SIZE$timingPreSample = LAYOUT$timingPreSample.byteSize();
    public static final long SIZE$timingPostSample = LAYOUT$timingPostSample.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$sampleType = LAYOUT.byteOffset(PATH$sampleType);
    public static final long OFFSET$sampleInternalOperations = LAYOUT.byteOffset(PATH$sampleInternalOperations);
    public static final long OFFSET$cacheFlushOnCounterCollection = LAYOUT.byteOffset(PATH$cacheFlushOnCounterCollection);
    public static final long OFFSET$sqShaderMaskEnable = LAYOUT.byteOffset(PATH$sqShaderMaskEnable);
    public static final long OFFSET$sqShaderMask = LAYOUT.byteOffset(PATH$sqShaderMask);
    public static final long OFFSET$perfCounterCount = LAYOUT.byteOffset(PATH$perfCounterCount);
    public static final long OFFSET$pPerfCounters = LAYOUT.byteOffset(PATH$pPerfCounters);
    public static final long OFFSET$streamingPerfTraceSampleInterval = LAYOUT.byteOffset(PATH$streamingPerfTraceSampleInterval);
    public static final long OFFSET$perfCounterDeviceMemoryLimit = LAYOUT.byteOffset(PATH$perfCounterDeviceMemoryLimit);
    public static final long OFFSET$sqThreadTraceEnable = LAYOUT.byteOffset(PATH$sqThreadTraceEnable);
    public static final long OFFSET$sqThreadTraceSuppressInstructionTokens = LAYOUT.byteOffset(PATH$sqThreadTraceSuppressInstructionTokens);
    public static final long OFFSET$sqThreadTraceDeviceMemoryLimit = LAYOUT.byteOffset(PATH$sqThreadTraceDeviceMemoryLimit);
    public static final long OFFSET$timingPreSample = LAYOUT.byteOffset(PATH$timingPreSample);
    public static final long OFFSET$timingPostSample = LAYOUT.byteOffset(PATH$timingPostSample);
}
