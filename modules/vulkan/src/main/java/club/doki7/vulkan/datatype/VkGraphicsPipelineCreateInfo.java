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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGraphicsPipelineCreateInfo.html"><code>VkGraphicsPipelineCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGraphicsPipelineCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineCreateFlags flags; // optional // @link substring="VkPipelineCreateFlags" target="VkPipelineCreateFlags" @link substring="flags" target="#flags"
///     uint32_t stageCount; // optional // @link substring="stageCount" target="#stageCount"
///     VkPipelineShaderStageCreateInfo const* pStages; // optional // @link substring="VkPipelineShaderStageCreateInfo" target="VkPipelineShaderStageCreateInfo" @link substring="pStages" target="#pStages"
///     VkPipelineVertexInputStateCreateInfo const* pVertexInputState; // optional // @link substring="VkPipelineVertexInputStateCreateInfo" target="VkPipelineVertexInputStateCreateInfo" @link substring="pVertexInputState" target="#pVertexInputState"
///     VkPipelineInputAssemblyStateCreateInfo const* pInputAssemblyState; // optional // @link substring="VkPipelineInputAssemblyStateCreateInfo" target="VkPipelineInputAssemblyStateCreateInfo" @link substring="pInputAssemblyState" target="#pInputAssemblyState"
///     VkPipelineTessellationStateCreateInfo const* pTessellationState; // optional // @link substring="VkPipelineTessellationStateCreateInfo" target="VkPipelineTessellationStateCreateInfo" @link substring="pTessellationState" target="#pTessellationState"
///     VkPipelineViewportStateCreateInfo const* pViewportState; // optional // @link substring="VkPipelineViewportStateCreateInfo" target="VkPipelineViewportStateCreateInfo" @link substring="pViewportState" target="#pViewportState"
///     VkPipelineRasterizationStateCreateInfo const* pRasterizationState; // optional // @link substring="VkPipelineRasterizationStateCreateInfo" target="VkPipelineRasterizationStateCreateInfo" @link substring="pRasterizationState" target="#pRasterizationState"
///     VkPipelineMultisampleStateCreateInfo const* pMultisampleState; // optional // @link substring="VkPipelineMultisampleStateCreateInfo" target="VkPipelineMultisampleStateCreateInfo" @link substring="pMultisampleState" target="#pMultisampleState"
///     VkPipelineDepthStencilStateCreateInfo const* pDepthStencilState; // optional // @link substring="VkPipelineDepthStencilStateCreateInfo" target="VkPipelineDepthStencilStateCreateInfo" @link substring="pDepthStencilState" target="#pDepthStencilState"
///     VkPipelineColorBlendStateCreateInfo const* pColorBlendState; // optional // @link substring="VkPipelineColorBlendStateCreateInfo" target="VkPipelineColorBlendStateCreateInfo" @link substring="pColorBlendState" target="#pColorBlendState"
///     VkPipelineDynamicStateCreateInfo const* pDynamicState; // optional // @link substring="VkPipelineDynamicStateCreateInfo" target="VkPipelineDynamicStateCreateInfo" @link substring="pDynamicState" target="#pDynamicState"
///     VkPipelineLayout layout; // optional // @link substring="VkPipelineLayout" target="VkPipelineLayout" @link substring="layout" target="#layout"
///     VkRenderPass renderPass; // optional // @link substring="VkRenderPass" target="VkRenderPass" @link substring="renderPass" target="#renderPass"
///     uint32_t subpass; // @link substring="subpass" target="#subpass"
///     VkPipeline basePipelineHandle; // optional // @link substring="VkPipeline" target="VkPipeline" @link substring="basePipelineHandle" target="#basePipelineHandle"
///     int32_t basePipelineIndex; // @link substring="basePipelineIndex" target="#basePipelineIndex"
/// } VkGraphicsPipelineCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkGraphicsPipelineCreateInfo#allocate(Arena)}, {@link VkGraphicsPipelineCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkGraphicsPipelineCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGraphicsPipelineCreateInfo.html"><code>VkGraphicsPipelineCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGraphicsPipelineCreateInfo(@NotNull MemorySegment segment) implements IVkGraphicsPipelineCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGraphicsPipelineCreateInfo.html"><code>VkGraphicsPipelineCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGraphicsPipelineCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGraphicsPipelineCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGraphicsPipelineCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGraphicsPipelineCreateInfo, Iterable<VkGraphicsPipelineCreateInfo> {
        public long size() {
            return segment.byteSize() / VkGraphicsPipelineCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGraphicsPipelineCreateInfo at(long index) {
            return new VkGraphicsPipelineCreateInfo(segment.asSlice(index * VkGraphicsPipelineCreateInfo.BYTES, VkGraphicsPipelineCreateInfo.BYTES));
        }

        public VkGraphicsPipelineCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkGraphicsPipelineCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGraphicsPipelineCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkGraphicsPipelineCreateInfo.BYTES, VkGraphicsPipelineCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGraphicsPipelineCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGraphicsPipelineCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGraphicsPipelineCreateInfo.BYTES,
                (end - start) * VkGraphicsPipelineCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGraphicsPipelineCreateInfo.BYTES));
        }

        public VkGraphicsPipelineCreateInfo[] toArray() {
            VkGraphicsPipelineCreateInfo[] ret = new VkGraphicsPipelineCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGraphicsPipelineCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGraphicsPipelineCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGraphicsPipelineCreateInfo.BYTES;
            }

            @Override
            public VkGraphicsPipelineCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGraphicsPipelineCreateInfo ret = new VkGraphicsPipelineCreateInfo(segment.asSlice(0, VkGraphicsPipelineCreateInfo.BYTES));
                segment = segment.asSlice(VkGraphicsPipelineCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGraphicsPipelineCreateInfo allocate(Arena arena) {
        VkGraphicsPipelineCreateInfo ret = new VkGraphicsPipelineCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.GRAPHICS_PIPELINE_CREATE_INFO);
        return ret;
    }

    public static VkGraphicsPipelineCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkGraphicsPipelineCreateInfo.Ptr ret = new VkGraphicsPipelineCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.GRAPHICS_PIPELINE_CREATE_INFO);
        }
        return ret;
    }

    public static VkGraphicsPipelineCreateInfo clone(Arena arena, VkGraphicsPipelineCreateInfo src) {
        VkGraphicsPipelineCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.GRAPHICS_PIPELINE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkGraphicsPipelineCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkGraphicsPipelineCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkGraphicsPipelineCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkGraphicsPipelineCreateInfo flags(@Bitmask(VkPipelineCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int stageCount() {
        return segment.get(LAYOUT$stageCount, OFFSET$stageCount);
    }

    public VkGraphicsPipelineCreateInfo stageCount(@Unsigned int value) {
        segment.set(LAYOUT$stageCount, OFFSET$stageCount, value);
        return this;
    }

    public VkGraphicsPipelineCreateInfo pStages(@Nullable IVkPipelineShaderStageCreateInfo value) {
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

    public VkGraphicsPipelineCreateInfo pVertexInputState(@Nullable IVkPipelineVertexInputStateCreateInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pVertexInputStateRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineVertexInputStateCreateInfo.Ptr pVertexInputState(int assumedCount) {
        MemorySegment s = pVertexInputStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineVertexInputStateCreateInfo.BYTES);
        return new VkPipelineVertexInputStateCreateInfo.Ptr(s);
    }

    public @Nullable VkPipelineVertexInputStateCreateInfo pVertexInputState() {
        MemorySegment s = pVertexInputStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineVertexInputStateCreateInfo(s);
    }

    public @Pointer(target=VkPipelineVertexInputStateCreateInfo.class) @NotNull MemorySegment pVertexInputStateRaw() {
        return segment.get(LAYOUT$pVertexInputState, OFFSET$pVertexInputState);
    }

    public void pVertexInputStateRaw(@Pointer(target=VkPipelineVertexInputStateCreateInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pVertexInputState, OFFSET$pVertexInputState, value);
    }

    public VkGraphicsPipelineCreateInfo pInputAssemblyState(@Nullable IVkPipelineInputAssemblyStateCreateInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pInputAssemblyStateRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineInputAssemblyStateCreateInfo.Ptr pInputAssemblyState(int assumedCount) {
        MemorySegment s = pInputAssemblyStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineInputAssemblyStateCreateInfo.BYTES);
        return new VkPipelineInputAssemblyStateCreateInfo.Ptr(s);
    }

    public @Nullable VkPipelineInputAssemblyStateCreateInfo pInputAssemblyState() {
        MemorySegment s = pInputAssemblyStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineInputAssemblyStateCreateInfo(s);
    }

    public @Pointer(target=VkPipelineInputAssemblyStateCreateInfo.class) @NotNull MemorySegment pInputAssemblyStateRaw() {
        return segment.get(LAYOUT$pInputAssemblyState, OFFSET$pInputAssemblyState);
    }

    public void pInputAssemblyStateRaw(@Pointer(target=VkPipelineInputAssemblyStateCreateInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pInputAssemblyState, OFFSET$pInputAssemblyState, value);
    }

    public VkGraphicsPipelineCreateInfo pTessellationState(@Nullable IVkPipelineTessellationStateCreateInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTessellationStateRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineTessellationStateCreateInfo.Ptr pTessellationState(int assumedCount) {
        MemorySegment s = pTessellationStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineTessellationStateCreateInfo.BYTES);
        return new VkPipelineTessellationStateCreateInfo.Ptr(s);
    }

    public @Nullable VkPipelineTessellationStateCreateInfo pTessellationState() {
        MemorySegment s = pTessellationStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineTessellationStateCreateInfo(s);
    }

    public @Pointer(target=VkPipelineTessellationStateCreateInfo.class) @NotNull MemorySegment pTessellationStateRaw() {
        return segment.get(LAYOUT$pTessellationState, OFFSET$pTessellationState);
    }

    public void pTessellationStateRaw(@Pointer(target=VkPipelineTessellationStateCreateInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTessellationState, OFFSET$pTessellationState, value);
    }

    public VkGraphicsPipelineCreateInfo pViewportState(@Nullable IVkPipelineViewportStateCreateInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pViewportStateRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineViewportStateCreateInfo.Ptr pViewportState(int assumedCount) {
        MemorySegment s = pViewportStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineViewportStateCreateInfo.BYTES);
        return new VkPipelineViewportStateCreateInfo.Ptr(s);
    }

    public @Nullable VkPipelineViewportStateCreateInfo pViewportState() {
        MemorySegment s = pViewportStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineViewportStateCreateInfo(s);
    }

    public @Pointer(target=VkPipelineViewportStateCreateInfo.class) @NotNull MemorySegment pViewportStateRaw() {
        return segment.get(LAYOUT$pViewportState, OFFSET$pViewportState);
    }

    public void pViewportStateRaw(@Pointer(target=VkPipelineViewportStateCreateInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pViewportState, OFFSET$pViewportState, value);
    }

    public VkGraphicsPipelineCreateInfo pRasterizationState(@Nullable IVkPipelineRasterizationStateCreateInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pRasterizationStateRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineRasterizationStateCreateInfo.Ptr pRasterizationState(int assumedCount) {
        MemorySegment s = pRasterizationStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineRasterizationStateCreateInfo.BYTES);
        return new VkPipelineRasterizationStateCreateInfo.Ptr(s);
    }

    public @Nullable VkPipelineRasterizationStateCreateInfo pRasterizationState() {
        MemorySegment s = pRasterizationStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineRasterizationStateCreateInfo(s);
    }

    public @Pointer(target=VkPipelineRasterizationStateCreateInfo.class) @NotNull MemorySegment pRasterizationStateRaw() {
        return segment.get(LAYOUT$pRasterizationState, OFFSET$pRasterizationState);
    }

    public void pRasterizationStateRaw(@Pointer(target=VkPipelineRasterizationStateCreateInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pRasterizationState, OFFSET$pRasterizationState, value);
    }

    public VkGraphicsPipelineCreateInfo pMultisampleState(@Nullable IVkPipelineMultisampleStateCreateInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pMultisampleStateRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineMultisampleStateCreateInfo.Ptr pMultisampleState(int assumedCount) {
        MemorySegment s = pMultisampleStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineMultisampleStateCreateInfo.BYTES);
        return new VkPipelineMultisampleStateCreateInfo.Ptr(s);
    }

    public @Nullable VkPipelineMultisampleStateCreateInfo pMultisampleState() {
        MemorySegment s = pMultisampleStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineMultisampleStateCreateInfo(s);
    }

    public @Pointer(target=VkPipelineMultisampleStateCreateInfo.class) @NotNull MemorySegment pMultisampleStateRaw() {
        return segment.get(LAYOUT$pMultisampleState, OFFSET$pMultisampleState);
    }

    public void pMultisampleStateRaw(@Pointer(target=VkPipelineMultisampleStateCreateInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pMultisampleState, OFFSET$pMultisampleState, value);
    }

    public VkGraphicsPipelineCreateInfo pDepthStencilState(@Nullable IVkPipelineDepthStencilStateCreateInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDepthStencilStateRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineDepthStencilStateCreateInfo.Ptr pDepthStencilState(int assumedCount) {
        MemorySegment s = pDepthStencilStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineDepthStencilStateCreateInfo.BYTES);
        return new VkPipelineDepthStencilStateCreateInfo.Ptr(s);
    }

    public @Nullable VkPipelineDepthStencilStateCreateInfo pDepthStencilState() {
        MemorySegment s = pDepthStencilStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineDepthStencilStateCreateInfo(s);
    }

    public @Pointer(target=VkPipelineDepthStencilStateCreateInfo.class) @NotNull MemorySegment pDepthStencilStateRaw() {
        return segment.get(LAYOUT$pDepthStencilState, OFFSET$pDepthStencilState);
    }

    public void pDepthStencilStateRaw(@Pointer(target=VkPipelineDepthStencilStateCreateInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDepthStencilState, OFFSET$pDepthStencilState, value);
    }

    public VkGraphicsPipelineCreateInfo pColorBlendState(@Nullable IVkPipelineColorBlendStateCreateInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pColorBlendStateRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineColorBlendStateCreateInfo.Ptr pColorBlendState(int assumedCount) {
        MemorySegment s = pColorBlendStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineColorBlendStateCreateInfo.BYTES);
        return new VkPipelineColorBlendStateCreateInfo.Ptr(s);
    }

    public @Nullable VkPipelineColorBlendStateCreateInfo pColorBlendState() {
        MemorySegment s = pColorBlendStateRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineColorBlendStateCreateInfo(s);
    }

    public @Pointer(target=VkPipelineColorBlendStateCreateInfo.class) @NotNull MemorySegment pColorBlendStateRaw() {
        return segment.get(LAYOUT$pColorBlendState, OFFSET$pColorBlendState);
    }

    public void pColorBlendStateRaw(@Pointer(target=VkPipelineColorBlendStateCreateInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pColorBlendState, OFFSET$pColorBlendState, value);
    }

    public VkGraphicsPipelineCreateInfo pDynamicState(@Nullable IVkPipelineDynamicStateCreateInfo value) {
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

    public VkGraphicsPipelineCreateInfo layout(@Nullable VkPipelineLayout value) {
        segment.set(LAYOUT$layout, OFFSET$layout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkRenderPass renderPass() {
        MemorySegment s = segment.asSlice(OFFSET$renderPass, SIZE$renderPass);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRenderPass(s);
    }

    public VkGraphicsPipelineCreateInfo renderPass(@Nullable VkRenderPass value) {
        segment.set(LAYOUT$renderPass, OFFSET$renderPass, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int subpass() {
        return segment.get(LAYOUT$subpass, OFFSET$subpass);
    }

    public VkGraphicsPipelineCreateInfo subpass(@Unsigned int value) {
        segment.set(LAYOUT$subpass, OFFSET$subpass, value);
        return this;
    }

    public @Nullable VkPipeline basePipelineHandle() {
        MemorySegment s = segment.asSlice(OFFSET$basePipelineHandle, SIZE$basePipelineHandle);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipeline(s);
    }

    public VkGraphicsPipelineCreateInfo basePipelineHandle(@Nullable VkPipeline value) {
        segment.set(LAYOUT$basePipelineHandle, OFFSET$basePipelineHandle, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public int basePipelineIndex() {
        return segment.get(LAYOUT$basePipelineIndex, OFFSET$basePipelineIndex);
    }

    public VkGraphicsPipelineCreateInfo basePipelineIndex(int value) {
        segment.set(LAYOUT$basePipelineIndex, OFFSET$basePipelineIndex, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("stageCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineShaderStageCreateInfo.LAYOUT).withName("pStages"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineVertexInputStateCreateInfo.LAYOUT).withName("pVertexInputState"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineInputAssemblyStateCreateInfo.LAYOUT).withName("pInputAssemblyState"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineTessellationStateCreateInfo.LAYOUT).withName("pTessellationState"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineViewportStateCreateInfo.LAYOUT).withName("pViewportState"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineRasterizationStateCreateInfo.LAYOUT).withName("pRasterizationState"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineMultisampleStateCreateInfo.LAYOUT).withName("pMultisampleState"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineDepthStencilStateCreateInfo.LAYOUT).withName("pDepthStencilState"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineColorBlendStateCreateInfo.LAYOUT).withName("pColorBlendState"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineDynamicStateCreateInfo.LAYOUT).withName("pDynamicState"),
        ValueLayout.ADDRESS.withName("layout"),
        ValueLayout.ADDRESS.withName("renderPass"),
        ValueLayout.JAVA_INT.withName("subpass"),
        ValueLayout.ADDRESS.withName("basePipelineHandle"),
        ValueLayout.JAVA_INT.withName("basePipelineIndex")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$stageCount = PathElement.groupElement("stageCount");
    public static final PathElement PATH$pStages = PathElement.groupElement("pStages");
    public static final PathElement PATH$pVertexInputState = PathElement.groupElement("pVertexInputState");
    public static final PathElement PATH$pInputAssemblyState = PathElement.groupElement("pInputAssemblyState");
    public static final PathElement PATH$pTessellationState = PathElement.groupElement("pTessellationState");
    public static final PathElement PATH$pViewportState = PathElement.groupElement("pViewportState");
    public static final PathElement PATH$pRasterizationState = PathElement.groupElement("pRasterizationState");
    public static final PathElement PATH$pMultisampleState = PathElement.groupElement("pMultisampleState");
    public static final PathElement PATH$pDepthStencilState = PathElement.groupElement("pDepthStencilState");
    public static final PathElement PATH$pColorBlendState = PathElement.groupElement("pColorBlendState");
    public static final PathElement PATH$pDynamicState = PathElement.groupElement("pDynamicState");
    public static final PathElement PATH$layout = PathElement.groupElement("layout");
    public static final PathElement PATH$renderPass = PathElement.groupElement("renderPass");
    public static final PathElement PATH$subpass = PathElement.groupElement("subpass");
    public static final PathElement PATH$basePipelineHandle = PathElement.groupElement("basePipelineHandle");
    public static final PathElement PATH$basePipelineIndex = PathElement.groupElement("basePipelineIndex");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$stageCount = (OfInt) LAYOUT.select(PATH$stageCount);
    public static final AddressLayout LAYOUT$pStages = (AddressLayout) LAYOUT.select(PATH$pStages);
    public static final AddressLayout LAYOUT$pVertexInputState = (AddressLayout) LAYOUT.select(PATH$pVertexInputState);
    public static final AddressLayout LAYOUT$pInputAssemblyState = (AddressLayout) LAYOUT.select(PATH$pInputAssemblyState);
    public static final AddressLayout LAYOUT$pTessellationState = (AddressLayout) LAYOUT.select(PATH$pTessellationState);
    public static final AddressLayout LAYOUT$pViewportState = (AddressLayout) LAYOUT.select(PATH$pViewportState);
    public static final AddressLayout LAYOUT$pRasterizationState = (AddressLayout) LAYOUT.select(PATH$pRasterizationState);
    public static final AddressLayout LAYOUT$pMultisampleState = (AddressLayout) LAYOUT.select(PATH$pMultisampleState);
    public static final AddressLayout LAYOUT$pDepthStencilState = (AddressLayout) LAYOUT.select(PATH$pDepthStencilState);
    public static final AddressLayout LAYOUT$pColorBlendState = (AddressLayout) LAYOUT.select(PATH$pColorBlendState);
    public static final AddressLayout LAYOUT$pDynamicState = (AddressLayout) LAYOUT.select(PATH$pDynamicState);
    public static final AddressLayout LAYOUT$layout = (AddressLayout) LAYOUT.select(PATH$layout);
    public static final AddressLayout LAYOUT$renderPass = (AddressLayout) LAYOUT.select(PATH$renderPass);
    public static final OfInt LAYOUT$subpass = (OfInt) LAYOUT.select(PATH$subpass);
    public static final AddressLayout LAYOUT$basePipelineHandle = (AddressLayout) LAYOUT.select(PATH$basePipelineHandle);
    public static final OfInt LAYOUT$basePipelineIndex = (OfInt) LAYOUT.select(PATH$basePipelineIndex);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$stageCount = LAYOUT$stageCount.byteSize();
    public static final long SIZE$pStages = LAYOUT$pStages.byteSize();
    public static final long SIZE$pVertexInputState = LAYOUT$pVertexInputState.byteSize();
    public static final long SIZE$pInputAssemblyState = LAYOUT$pInputAssemblyState.byteSize();
    public static final long SIZE$pTessellationState = LAYOUT$pTessellationState.byteSize();
    public static final long SIZE$pViewportState = LAYOUT$pViewportState.byteSize();
    public static final long SIZE$pRasterizationState = LAYOUT$pRasterizationState.byteSize();
    public static final long SIZE$pMultisampleState = LAYOUT$pMultisampleState.byteSize();
    public static final long SIZE$pDepthStencilState = LAYOUT$pDepthStencilState.byteSize();
    public static final long SIZE$pColorBlendState = LAYOUT$pColorBlendState.byteSize();
    public static final long SIZE$pDynamicState = LAYOUT$pDynamicState.byteSize();
    public static final long SIZE$layout = LAYOUT$layout.byteSize();
    public static final long SIZE$renderPass = LAYOUT$renderPass.byteSize();
    public static final long SIZE$subpass = LAYOUT$subpass.byteSize();
    public static final long SIZE$basePipelineHandle = LAYOUT$basePipelineHandle.byteSize();
    public static final long SIZE$basePipelineIndex = LAYOUT$basePipelineIndex.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$stageCount = LAYOUT.byteOffset(PATH$stageCount);
    public static final long OFFSET$pStages = LAYOUT.byteOffset(PATH$pStages);
    public static final long OFFSET$pVertexInputState = LAYOUT.byteOffset(PATH$pVertexInputState);
    public static final long OFFSET$pInputAssemblyState = LAYOUT.byteOffset(PATH$pInputAssemblyState);
    public static final long OFFSET$pTessellationState = LAYOUT.byteOffset(PATH$pTessellationState);
    public static final long OFFSET$pViewportState = LAYOUT.byteOffset(PATH$pViewportState);
    public static final long OFFSET$pRasterizationState = LAYOUT.byteOffset(PATH$pRasterizationState);
    public static final long OFFSET$pMultisampleState = LAYOUT.byteOffset(PATH$pMultisampleState);
    public static final long OFFSET$pDepthStencilState = LAYOUT.byteOffset(PATH$pDepthStencilState);
    public static final long OFFSET$pColorBlendState = LAYOUT.byteOffset(PATH$pColorBlendState);
    public static final long OFFSET$pDynamicState = LAYOUT.byteOffset(PATH$pDynamicState);
    public static final long OFFSET$layout = LAYOUT.byteOffset(PATH$layout);
    public static final long OFFSET$renderPass = LAYOUT.byteOffset(PATH$renderPass);
    public static final long OFFSET$subpass = LAYOUT.byteOffset(PATH$subpass);
    public static final long OFFSET$basePipelineHandle = LAYOUT.byteOffset(PATH$basePipelineHandle);
    public static final long OFFSET$basePipelineIndex = LAYOUT.byteOffset(PATH$basePipelineIndex);
}
