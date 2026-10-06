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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRayTracingPipelineCreateInfoKHR.html"><code>VkRayTracingPipelineCreateInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRayTracingPipelineCreateInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineCreateFlags flags; // optional // @link substring="VkPipelineCreateFlags" target="VkPipelineCreateFlags" @link substring="flags" target="#flags"
///     uint32_t stageCount; // optional // @link substring="stageCount" target="#stageCount"
///     VkPipelineShaderStageCreateInfo const* pStages; // optional // @link substring="VkPipelineShaderStageCreateInfo" target="VkPipelineShaderStageCreateInfo" @link substring="pStages" target="#pStages"
///     uint32_t groupCount; // optional // @link substring="groupCount" target="#groupCount"
///     VkRayTracingShaderGroupCreateInfoKHR const* pGroups; // optional // @link substring="VkRayTracingShaderGroupCreateInfoKHR" target="VkRayTracingShaderGroupCreateInfoKHR" @link substring="pGroups" target="#pGroups"
///     uint32_t maxPipelineRayRecursionDepth; // @link substring="maxPipelineRayRecursionDepth" target="#maxPipelineRayRecursionDepth"
///     VkPipelineLibraryCreateInfoKHR const* pLibraryInfo; // optional // @link substring="VkPipelineLibraryCreateInfoKHR" target="VkPipelineLibraryCreateInfoKHR" @link substring="pLibraryInfo" target="#pLibraryInfo"
///     VkRayTracingPipelineInterfaceCreateInfoKHR const* pLibraryInterface; // optional // @link substring="VkRayTracingPipelineInterfaceCreateInfoKHR" target="VkRayTracingPipelineInterfaceCreateInfoKHR" @link substring="pLibraryInterface" target="#pLibraryInterface"
///     VkPipelineDynamicStateCreateInfo const* pDynamicState; // optional // @link substring="VkPipelineDynamicStateCreateInfo" target="VkPipelineDynamicStateCreateInfo" @link substring="pDynamicState" target="#pDynamicState"
///     VkPipelineLayout layout; // optional // @link substring="VkPipelineLayout" target="VkPipelineLayout" @link substring="layout" target="#layout"
///     VkPipeline basePipelineHandle; // optional // @link substring="VkPipeline" target="VkPipeline" @link substring="basePipelineHandle" target="#basePipelineHandle"
///     int32_t basePipelineIndex; // @link substring="basePipelineIndex" target="#basePipelineIndex"
/// } VkRayTracingPipelineCreateInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_RAY_TRACING_PIPELINE_CREATE_INFO_KHR`
///
/// The {@code allocate} ({@link VkRayTracingPipelineCreateInfoKHR#allocate(Arena)}, {@link VkRayTracingPipelineCreateInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkRayTracingPipelineCreateInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRayTracingPipelineCreateInfoKHR.html"><code>VkRayTracingPipelineCreateInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRayTracingPipelineCreateInfoKHR(@NotNull MemorySegment segment) implements IVkRayTracingPipelineCreateInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRayTracingPipelineCreateInfoKHR.html"><code>VkRayTracingPipelineCreateInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRayTracingPipelineCreateInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRayTracingPipelineCreateInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRayTracingPipelineCreateInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRayTracingPipelineCreateInfoKHR, Iterable<VkRayTracingPipelineCreateInfoKHR> {
        public long size() {
            return segment.byteSize() / VkRayTracingPipelineCreateInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRayTracingPipelineCreateInfoKHR at(long index) {
            return new VkRayTracingPipelineCreateInfoKHR(segment.asSlice(index * VkRayTracingPipelineCreateInfoKHR.BYTES, VkRayTracingPipelineCreateInfoKHR.BYTES));
        }

        public VkRayTracingPipelineCreateInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkRayTracingPipelineCreateInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRayTracingPipelineCreateInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkRayTracingPipelineCreateInfoKHR.BYTES, VkRayTracingPipelineCreateInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRayTracingPipelineCreateInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRayTracingPipelineCreateInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRayTracingPipelineCreateInfoKHR.BYTES,
                (end - start) * VkRayTracingPipelineCreateInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRayTracingPipelineCreateInfoKHR.BYTES));
        }

        public VkRayTracingPipelineCreateInfoKHR[] toArray() {
            VkRayTracingPipelineCreateInfoKHR[] ret = new VkRayTracingPipelineCreateInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRayTracingPipelineCreateInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRayTracingPipelineCreateInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRayTracingPipelineCreateInfoKHR.BYTES;
            }

            @Override
            public VkRayTracingPipelineCreateInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRayTracingPipelineCreateInfoKHR ret = new VkRayTracingPipelineCreateInfoKHR(segment.asSlice(0, VkRayTracingPipelineCreateInfoKHR.BYTES));
                segment = segment.asSlice(VkRayTracingPipelineCreateInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRayTracingPipelineCreateInfoKHR allocate(Arena arena) {
        VkRayTracingPipelineCreateInfoKHR ret = new VkRayTracingPipelineCreateInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.RAY_TRACING_PIPELINE_CREATE_INFO_KHR);
        return ret;
    }

    public static VkRayTracingPipelineCreateInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkRayTracingPipelineCreateInfoKHR.Ptr ret = new VkRayTracingPipelineCreateInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.RAY_TRACING_PIPELINE_CREATE_INFO_KHR);
        }
        return ret;
    }

    public static VkRayTracingPipelineCreateInfoKHR clone(Arena arena, VkRayTracingPipelineCreateInfoKHR src) {
        VkRayTracingPipelineCreateInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.RAY_TRACING_PIPELINE_CREATE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkRayTracingPipelineCreateInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkRayTracingPipelineCreateInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkRayTracingPipelineCreateInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkRayTracingPipelineCreateInfoKHR flags(@Bitmask(VkPipelineCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int stageCount() {
        return segment.get(LAYOUT$stageCount, OFFSET$stageCount);
    }

    public VkRayTracingPipelineCreateInfoKHR stageCount(@Unsigned int value) {
        segment.set(LAYOUT$stageCount, OFFSET$stageCount, value);
        return this;
    }

    public VkRayTracingPipelineCreateInfoKHR pStages(@Nullable IVkPipelineShaderStageCreateInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStagesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineShaderStageCreateInfo.Ptr pStages(int assumedCount) {
        MemorySegment s = pStagesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineShaderStageCreateInfo.BYTES);
        return new VkPipelineShaderStageCreateInfo.Ptr(s);
    }

    public @Nullable VkPipelineShaderStageCreateInfo pStages() {
        MemorySegment s = pStagesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineShaderStageCreateInfo(s);
    }

    public @Pointer(target=VkPipelineShaderStageCreateInfo.class) @NotNull MemorySegment pStagesRaw() {
        return segment.get(LAYOUT$pStages, OFFSET$pStages);
    }

    public void pStagesRaw(@Pointer(target=VkPipelineShaderStageCreateInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStages, OFFSET$pStages, value);
    }

    public @Unsigned int groupCount() {
        return segment.get(LAYOUT$groupCount, OFFSET$groupCount);
    }

    public VkRayTracingPipelineCreateInfoKHR groupCount(@Unsigned int value) {
        segment.set(LAYOUT$groupCount, OFFSET$groupCount, value);
        return this;
    }

    public VkRayTracingPipelineCreateInfoKHR pGroups(@Nullable IVkRayTracingShaderGroupCreateInfoKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pGroupsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRayTracingShaderGroupCreateInfoKHR.Ptr pGroups(int assumedCount) {
        MemorySegment s = pGroupsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRayTracingShaderGroupCreateInfoKHR.BYTES);
        return new VkRayTracingShaderGroupCreateInfoKHR.Ptr(s);
    }

    public @Nullable VkRayTracingShaderGroupCreateInfoKHR pGroups() {
        MemorySegment s = pGroupsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRayTracingShaderGroupCreateInfoKHR(s);
    }

    public @Pointer(target=VkRayTracingShaderGroupCreateInfoKHR.class) @NotNull MemorySegment pGroupsRaw() {
        return segment.get(LAYOUT$pGroups, OFFSET$pGroups);
    }

    public void pGroupsRaw(@Pointer(target=VkRayTracingShaderGroupCreateInfoKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pGroups, OFFSET$pGroups, value);
    }

    public @Unsigned int maxPipelineRayRecursionDepth() {
        return segment.get(LAYOUT$maxPipelineRayRecursionDepth, OFFSET$maxPipelineRayRecursionDepth);
    }

    public VkRayTracingPipelineCreateInfoKHR maxPipelineRayRecursionDepth(@Unsigned int value) {
        segment.set(LAYOUT$maxPipelineRayRecursionDepth, OFFSET$maxPipelineRayRecursionDepth, value);
        return this;
    }

    public VkRayTracingPipelineCreateInfoKHR pLibraryInfo(@Nullable IVkPipelineLibraryCreateInfoKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pLibraryInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineLibraryCreateInfoKHR.Ptr pLibraryInfo(int assumedCount) {
        MemorySegment s = pLibraryInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineLibraryCreateInfoKHR.BYTES);
        return new VkPipelineLibraryCreateInfoKHR.Ptr(s);
    }

    public @Nullable VkPipelineLibraryCreateInfoKHR pLibraryInfo() {
        MemorySegment s = pLibraryInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineLibraryCreateInfoKHR(s);
    }

    public @Pointer(target=VkPipelineLibraryCreateInfoKHR.class) @NotNull MemorySegment pLibraryInfoRaw() {
        return segment.get(LAYOUT$pLibraryInfo, OFFSET$pLibraryInfo);
    }

    public void pLibraryInfoRaw(@Pointer(target=VkPipelineLibraryCreateInfoKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pLibraryInfo, OFFSET$pLibraryInfo, value);
    }

    public VkRayTracingPipelineCreateInfoKHR pLibraryInterface(@Nullable IVkRayTracingPipelineInterfaceCreateInfoKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pLibraryInterfaceRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRayTracingPipelineInterfaceCreateInfoKHR.Ptr pLibraryInterface(int assumedCount) {
        MemorySegment s = pLibraryInterfaceRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRayTracingPipelineInterfaceCreateInfoKHR.BYTES);
        return new VkRayTracingPipelineInterfaceCreateInfoKHR.Ptr(s);
    }

    public @Nullable VkRayTracingPipelineInterfaceCreateInfoKHR pLibraryInterface() {
        MemorySegment s = pLibraryInterfaceRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRayTracingPipelineInterfaceCreateInfoKHR(s);
    }

    public @Pointer(target=VkRayTracingPipelineInterfaceCreateInfoKHR.class) @NotNull MemorySegment pLibraryInterfaceRaw() {
        return segment.get(LAYOUT$pLibraryInterface, OFFSET$pLibraryInterface);
    }

    public void pLibraryInterfaceRaw(@Pointer(target=VkRayTracingPipelineInterfaceCreateInfoKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pLibraryInterface, OFFSET$pLibraryInterface, value);
    }

    public VkRayTracingPipelineCreateInfoKHR pDynamicState(@Nullable IVkPipelineDynamicStateCreateInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDynamicStateRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineDynamicStateCreateInfo.Ptr pDynamicState(int assumedCount) {
        MemorySegment s = pDynamicStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineDynamicStateCreateInfo.BYTES);
        return new VkPipelineDynamicStateCreateInfo.Ptr(s);
    }

    public @Nullable VkPipelineDynamicStateCreateInfo pDynamicState() {
        MemorySegment s = pDynamicStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineDynamicStateCreateInfo(s);
    }

    public @Pointer(target=VkPipelineDynamicStateCreateInfo.class) @NotNull MemorySegment pDynamicStateRaw() {
        return segment.get(LAYOUT$pDynamicState, OFFSET$pDynamicState);
    }

    public void pDynamicStateRaw(@Pointer(target=VkPipelineDynamicStateCreateInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDynamicState, OFFSET$pDynamicState, value);
    }

    public @Nullable VkPipelineLayout layout() {
        MemorySegment s = segment.asSlice(OFFSET$layout, SIZE$layout);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineLayout(s);
    }

    public VkRayTracingPipelineCreateInfoKHR layout(@Nullable VkPipelineLayout value) {
        segment.set(LAYOUT$layout, OFFSET$layout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkPipeline basePipelineHandle() {
        MemorySegment s = segment.asSlice(OFFSET$basePipelineHandle, SIZE$basePipelineHandle);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipeline(s);
    }

    public VkRayTracingPipelineCreateInfoKHR basePipelineHandle(@Nullable VkPipeline value) {
        segment.set(LAYOUT$basePipelineHandle, OFFSET$basePipelineHandle, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public int basePipelineIndex() {
        return segment.get(LAYOUT$basePipelineIndex, OFFSET$basePipelineIndex);
    }

    public VkRayTracingPipelineCreateInfoKHR basePipelineIndex(int value) {
        segment.set(LAYOUT$basePipelineIndex, OFFSET$basePipelineIndex, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("stageCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineShaderStageCreateInfo.LAYOUT).withName("pStages"),
        ValueLayout.JAVA_INT.withName("groupCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkRayTracingShaderGroupCreateInfoKHR.LAYOUT).withName("pGroups"),
        ValueLayout.JAVA_INT.withName("maxPipelineRayRecursionDepth"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineLibraryCreateInfoKHR.LAYOUT).withName("pLibraryInfo"),
        ValueLayout.ADDRESS.withTargetLayout(VkRayTracingPipelineInterfaceCreateInfoKHR.LAYOUT).withName("pLibraryInterface"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineDynamicStateCreateInfo.LAYOUT).withName("pDynamicState"),
        ValueLayout.ADDRESS.withName("layout"),
        ValueLayout.ADDRESS.withName("basePipelineHandle"),
        ValueLayout.JAVA_INT.withName("basePipelineIndex")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$stageCount = PathElement.groupElement("stageCount");
    public static final PathElement PATH$pStages = PathElement.groupElement("pStages");
    public static final PathElement PATH$groupCount = PathElement.groupElement("groupCount");
    public static final PathElement PATH$pGroups = PathElement.groupElement("pGroups");
    public static final PathElement PATH$maxPipelineRayRecursionDepth = PathElement.groupElement("maxPipelineRayRecursionDepth");
    public static final PathElement PATH$pLibraryInfo = PathElement.groupElement("pLibraryInfo");
    public static final PathElement PATH$pLibraryInterface = PathElement.groupElement("pLibraryInterface");
    public static final PathElement PATH$pDynamicState = PathElement.groupElement("pDynamicState");
    public static final PathElement PATH$layout = PathElement.groupElement("layout");
    public static final PathElement PATH$basePipelineHandle = PathElement.groupElement("basePipelineHandle");
    public static final PathElement PATH$basePipelineIndex = PathElement.groupElement("basePipelineIndex");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$stageCount = (OfInt) LAYOUT.select(PATH$stageCount);
    public static final AddressLayout LAYOUT$pStages = (AddressLayout) LAYOUT.select(PATH$pStages);
    public static final OfInt LAYOUT$groupCount = (OfInt) LAYOUT.select(PATH$groupCount);
    public static final AddressLayout LAYOUT$pGroups = (AddressLayout) LAYOUT.select(PATH$pGroups);
    public static final OfInt LAYOUT$maxPipelineRayRecursionDepth = (OfInt) LAYOUT.select(PATH$maxPipelineRayRecursionDepth);
    public static final AddressLayout LAYOUT$pLibraryInfo = (AddressLayout) LAYOUT.select(PATH$pLibraryInfo);
    public static final AddressLayout LAYOUT$pLibraryInterface = (AddressLayout) LAYOUT.select(PATH$pLibraryInterface);
    public static final AddressLayout LAYOUT$pDynamicState = (AddressLayout) LAYOUT.select(PATH$pDynamicState);
    public static final AddressLayout LAYOUT$layout = (AddressLayout) LAYOUT.select(PATH$layout);
    public static final AddressLayout LAYOUT$basePipelineHandle = (AddressLayout) LAYOUT.select(PATH$basePipelineHandle);
    public static final OfInt LAYOUT$basePipelineIndex = (OfInt) LAYOUT.select(PATH$basePipelineIndex);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$stageCount = LAYOUT$stageCount.byteSize();
    public static final long SIZE$pStages = LAYOUT$pStages.byteSize();
    public static final long SIZE$groupCount = LAYOUT$groupCount.byteSize();
    public static final long SIZE$pGroups = LAYOUT$pGroups.byteSize();
    public static final long SIZE$maxPipelineRayRecursionDepth = LAYOUT$maxPipelineRayRecursionDepth.byteSize();
    public static final long SIZE$pLibraryInfo = LAYOUT$pLibraryInfo.byteSize();
    public static final long SIZE$pLibraryInterface = LAYOUT$pLibraryInterface.byteSize();
    public static final long SIZE$pDynamicState = LAYOUT$pDynamicState.byteSize();
    public static final long SIZE$layout = LAYOUT$layout.byteSize();
    public static final long SIZE$basePipelineHandle = LAYOUT$basePipelineHandle.byteSize();
    public static final long SIZE$basePipelineIndex = LAYOUT$basePipelineIndex.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$stageCount = LAYOUT.byteOffset(PATH$stageCount);
    public static final long OFFSET$pStages = LAYOUT.byteOffset(PATH$pStages);
    public static final long OFFSET$groupCount = LAYOUT.byteOffset(PATH$groupCount);
    public static final long OFFSET$pGroups = LAYOUT.byteOffset(PATH$pGroups);
    public static final long OFFSET$maxPipelineRayRecursionDepth = LAYOUT.byteOffset(PATH$maxPipelineRayRecursionDepth);
    public static final long OFFSET$pLibraryInfo = LAYOUT.byteOffset(PATH$pLibraryInfo);
    public static final long OFFSET$pLibraryInterface = LAYOUT.byteOffset(PATH$pLibraryInterface);
    public static final long OFFSET$pDynamicState = LAYOUT.byteOffset(PATH$pDynamicState);
    public static final long OFFSET$layout = LAYOUT.byteOffset(PATH$layout);
    public static final long OFFSET$basePipelineHandle = LAYOUT.byteOffset(PATH$basePipelineHandle);
    public static final long OFFSET$basePipelineIndex = LAYOUT.byteOffset(PATH$basePipelineIndex);
}
