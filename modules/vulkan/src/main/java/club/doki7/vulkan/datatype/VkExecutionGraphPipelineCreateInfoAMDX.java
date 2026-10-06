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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExecutionGraphPipelineCreateInfoAMDX.html"><code>VkExecutionGraphPipelineCreateInfoAMDX</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkExecutionGraphPipelineCreateInfoAMDX {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineCreateFlags flags; // optional // @link substring="VkPipelineCreateFlags" target="VkPipelineCreateFlags" @link substring="flags" target="#flags"
///     uint32_t stageCount; // optional // @link substring="stageCount" target="#stageCount"
///     VkPipelineShaderStageCreateInfo const* pStages; // optional // @link substring="VkPipelineShaderStageCreateInfo" target="VkPipelineShaderStageCreateInfo" @link substring="pStages" target="#pStages"
///     VkPipelineLibraryCreateInfoKHR const* pLibraryInfo; // optional // @link substring="VkPipelineLibraryCreateInfoKHR" target="VkPipelineLibraryCreateInfoKHR" @link substring="pLibraryInfo" target="#pLibraryInfo"
///     VkPipelineLayout layout; // optional // @link substring="VkPipelineLayout" target="VkPipelineLayout" @link substring="layout" target="#layout"
///     VkPipeline basePipelineHandle; // optional // @link substring="VkPipeline" target="VkPipeline" @link substring="basePipelineHandle" target="#basePipelineHandle"
///     int32_t basePipelineIndex; // @link substring="basePipelineIndex" target="#basePipelineIndex"
/// } VkExecutionGraphPipelineCreateInfoAMDX;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_EXECUTION_GRAPH_PIPELINE_CREATE_INFO_AMDX`
///
/// The {@code allocate} ({@link VkExecutionGraphPipelineCreateInfoAMDX#allocate(Arena)}, {@link VkExecutionGraphPipelineCreateInfoAMDX#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkExecutionGraphPipelineCreateInfoAMDX#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExecutionGraphPipelineCreateInfoAMDX.html"><code>VkExecutionGraphPipelineCreateInfoAMDX</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkExecutionGraphPipelineCreateInfoAMDX(@NotNull MemorySegment segment) implements IVkExecutionGraphPipelineCreateInfoAMDX {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExecutionGraphPipelineCreateInfoAMDX.html"><code>VkExecutionGraphPipelineCreateInfoAMDX</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkExecutionGraphPipelineCreateInfoAMDX}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkExecutionGraphPipelineCreateInfoAMDX to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkExecutionGraphPipelineCreateInfoAMDX.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkExecutionGraphPipelineCreateInfoAMDX, Iterable<VkExecutionGraphPipelineCreateInfoAMDX> {
        public long size() {
            return segment.byteSize() / VkExecutionGraphPipelineCreateInfoAMDX.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkExecutionGraphPipelineCreateInfoAMDX at(long index) {
            return new VkExecutionGraphPipelineCreateInfoAMDX(segment.asSlice(index * VkExecutionGraphPipelineCreateInfoAMDX.BYTES, VkExecutionGraphPipelineCreateInfoAMDX.BYTES));
        }

        public VkExecutionGraphPipelineCreateInfoAMDX.Ptr at(long index, @NotNull Consumer<@NotNull VkExecutionGraphPipelineCreateInfoAMDX> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkExecutionGraphPipelineCreateInfoAMDX value) {
            MemorySegment s = segment.asSlice(index * VkExecutionGraphPipelineCreateInfoAMDX.BYTES, VkExecutionGraphPipelineCreateInfoAMDX.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkExecutionGraphPipelineCreateInfoAMDX.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkExecutionGraphPipelineCreateInfoAMDX.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkExecutionGraphPipelineCreateInfoAMDX.BYTES,
                (end - start) * VkExecutionGraphPipelineCreateInfoAMDX.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkExecutionGraphPipelineCreateInfoAMDX.BYTES));
        }

        public VkExecutionGraphPipelineCreateInfoAMDX[] toArray() {
            VkExecutionGraphPipelineCreateInfoAMDX[] ret = new VkExecutionGraphPipelineCreateInfoAMDX[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkExecutionGraphPipelineCreateInfoAMDX> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkExecutionGraphPipelineCreateInfoAMDX> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkExecutionGraphPipelineCreateInfoAMDX.BYTES;
            }

            @Override
            public VkExecutionGraphPipelineCreateInfoAMDX next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkExecutionGraphPipelineCreateInfoAMDX ret = new VkExecutionGraphPipelineCreateInfoAMDX(segment.asSlice(0, VkExecutionGraphPipelineCreateInfoAMDX.BYTES));
                segment = segment.asSlice(VkExecutionGraphPipelineCreateInfoAMDX.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkExecutionGraphPipelineCreateInfoAMDX allocate(Arena arena) {
        VkExecutionGraphPipelineCreateInfoAMDX ret = new VkExecutionGraphPipelineCreateInfoAMDX(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.EXECUTION_GRAPH_PIPELINE_CREATE_INFO_AMDX);
        return ret;
    }

    public static VkExecutionGraphPipelineCreateInfoAMDX.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkExecutionGraphPipelineCreateInfoAMDX.Ptr ret = new VkExecutionGraphPipelineCreateInfoAMDX.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.EXECUTION_GRAPH_PIPELINE_CREATE_INFO_AMDX);
        }
        return ret;
    }

    public static VkExecutionGraphPipelineCreateInfoAMDX clone(Arena arena, VkExecutionGraphPipelineCreateInfoAMDX src) {
        VkExecutionGraphPipelineCreateInfoAMDX ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.EXECUTION_GRAPH_PIPELINE_CREATE_INFO_AMDX);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkExecutionGraphPipelineCreateInfoAMDX sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkExecutionGraphPipelineCreateInfoAMDX pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkExecutionGraphPipelineCreateInfoAMDX pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkExecutionGraphPipelineCreateInfoAMDX flags(@Bitmask(VkPipelineCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int stageCount() {
        return segment.get(LAYOUT$stageCount, OFFSET$stageCount);
    }

    public VkExecutionGraphPipelineCreateInfoAMDX stageCount(@Unsigned int value) {
        segment.set(LAYOUT$stageCount, OFFSET$stageCount, value);
        return this;
    }

    public VkExecutionGraphPipelineCreateInfoAMDX pStages(@Nullable IVkPipelineShaderStageCreateInfo value) {
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

    public VkExecutionGraphPipelineCreateInfoAMDX pLibraryInfo(@Nullable IVkPipelineLibraryCreateInfoKHR value) {
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

    public @Nullable VkPipelineLayout layout() {
        MemorySegment s = segment.asSlice(OFFSET$layout, SIZE$layout);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineLayout(s);
    }

    public VkExecutionGraphPipelineCreateInfoAMDX layout(@Nullable VkPipelineLayout value) {
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

    public VkExecutionGraphPipelineCreateInfoAMDX basePipelineHandle(@Nullable VkPipeline value) {
        segment.set(LAYOUT$basePipelineHandle, OFFSET$basePipelineHandle, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public int basePipelineIndex() {
        return segment.get(LAYOUT$basePipelineIndex, OFFSET$basePipelineIndex);
    }

    public VkExecutionGraphPipelineCreateInfoAMDX basePipelineIndex(int value) {
        segment.set(LAYOUT$basePipelineIndex, OFFSET$basePipelineIndex, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("stageCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineShaderStageCreateInfo.LAYOUT).withName("pStages"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineLibraryCreateInfoKHR.LAYOUT).withName("pLibraryInfo"),
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
    public static final PathElement PATH$pLibraryInfo = PathElement.groupElement("pLibraryInfo");
    public static final PathElement PATH$layout = PathElement.groupElement("layout");
    public static final PathElement PATH$basePipelineHandle = PathElement.groupElement("basePipelineHandle");
    public static final PathElement PATH$basePipelineIndex = PathElement.groupElement("basePipelineIndex");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$stageCount = (OfInt) LAYOUT.select(PATH$stageCount);
    public static final AddressLayout LAYOUT$pStages = (AddressLayout) LAYOUT.select(PATH$pStages);
    public static final AddressLayout LAYOUT$pLibraryInfo = (AddressLayout) LAYOUT.select(PATH$pLibraryInfo);
    public static final AddressLayout LAYOUT$layout = (AddressLayout) LAYOUT.select(PATH$layout);
    public static final AddressLayout LAYOUT$basePipelineHandle = (AddressLayout) LAYOUT.select(PATH$basePipelineHandle);
    public static final OfInt LAYOUT$basePipelineIndex = (OfInt) LAYOUT.select(PATH$basePipelineIndex);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$stageCount = LAYOUT$stageCount.byteSize();
    public static final long SIZE$pStages = LAYOUT$pStages.byteSize();
    public static final long SIZE$pLibraryInfo = LAYOUT$pLibraryInfo.byteSize();
    public static final long SIZE$layout = LAYOUT$layout.byteSize();
    public static final long SIZE$basePipelineHandle = LAYOUT$basePipelineHandle.byteSize();
    public static final long SIZE$basePipelineIndex = LAYOUT$basePipelineIndex.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$stageCount = LAYOUT.byteOffset(PATH$stageCount);
    public static final long OFFSET$pStages = LAYOUT.byteOffset(PATH$pStages);
    public static final long OFFSET$pLibraryInfo = LAYOUT.byteOffset(PATH$pLibraryInfo);
    public static final long OFFSET$layout = LAYOUT.byteOffset(PATH$layout);
    public static final long OFFSET$basePipelineHandle = LAYOUT.byteOffset(PATH$basePipelineHandle);
    public static final long OFFSET$basePipelineIndex = LAYOUT.byteOffset(PATH$basePipelineIndex);
}
