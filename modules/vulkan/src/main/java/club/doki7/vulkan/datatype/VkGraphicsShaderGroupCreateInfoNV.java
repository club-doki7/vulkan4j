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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGraphicsShaderGroupCreateInfoNV.html"><code>VkGraphicsShaderGroupCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGraphicsShaderGroupCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t stageCount; // @link substring="stageCount" target="#stageCount"
///     VkPipelineShaderStageCreateInfo const* pStages; // @link substring="VkPipelineShaderStageCreateInfo" target="VkPipelineShaderStageCreateInfo" @link substring="pStages" target="#pStages"
///     VkPipelineVertexInputStateCreateInfo const* pVertexInputState; // optional // @link substring="VkPipelineVertexInputStateCreateInfo" target="VkPipelineVertexInputStateCreateInfo" @link substring="pVertexInputState" target="#pVertexInputState"
///     VkPipelineTessellationStateCreateInfo const* pTessellationState; // optional // @link substring="VkPipelineTessellationStateCreateInfo" target="VkPipelineTessellationStateCreateInfo" @link substring="pTessellationState" target="#pTessellationState"
/// } VkGraphicsShaderGroupCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_GRAPHICS_SHADER_GROUP_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkGraphicsShaderGroupCreateInfoNV#allocate(Arena)}, {@link VkGraphicsShaderGroupCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkGraphicsShaderGroupCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGraphicsShaderGroupCreateInfoNV.html"><code>VkGraphicsShaderGroupCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGraphicsShaderGroupCreateInfoNV(@NotNull MemorySegment segment) implements IVkGraphicsShaderGroupCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGraphicsShaderGroupCreateInfoNV.html"><code>VkGraphicsShaderGroupCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGraphicsShaderGroupCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGraphicsShaderGroupCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGraphicsShaderGroupCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGraphicsShaderGroupCreateInfoNV, Iterable<VkGraphicsShaderGroupCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkGraphicsShaderGroupCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGraphicsShaderGroupCreateInfoNV at(long index) {
            return new VkGraphicsShaderGroupCreateInfoNV(segment.asSlice(index * VkGraphicsShaderGroupCreateInfoNV.BYTES, VkGraphicsShaderGroupCreateInfoNV.BYTES));
        }

        public VkGraphicsShaderGroupCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkGraphicsShaderGroupCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGraphicsShaderGroupCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkGraphicsShaderGroupCreateInfoNV.BYTES, VkGraphicsShaderGroupCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGraphicsShaderGroupCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGraphicsShaderGroupCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGraphicsShaderGroupCreateInfoNV.BYTES,
                (end - start) * VkGraphicsShaderGroupCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGraphicsShaderGroupCreateInfoNV.BYTES));
        }

        public VkGraphicsShaderGroupCreateInfoNV[] toArray() {
            VkGraphicsShaderGroupCreateInfoNV[] ret = new VkGraphicsShaderGroupCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGraphicsShaderGroupCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGraphicsShaderGroupCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGraphicsShaderGroupCreateInfoNV.BYTES;
            }

            @Override
            public VkGraphicsShaderGroupCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGraphicsShaderGroupCreateInfoNV ret = new VkGraphicsShaderGroupCreateInfoNV(segment.asSlice(0, VkGraphicsShaderGroupCreateInfoNV.BYTES));
                segment = segment.asSlice(VkGraphicsShaderGroupCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGraphicsShaderGroupCreateInfoNV allocate(Arena arena) {
        VkGraphicsShaderGroupCreateInfoNV ret = new VkGraphicsShaderGroupCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.GRAPHICS_SHADER_GROUP_CREATE_INFO_NV);
        return ret;
    }

    public static VkGraphicsShaderGroupCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkGraphicsShaderGroupCreateInfoNV.Ptr ret = new VkGraphicsShaderGroupCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.GRAPHICS_SHADER_GROUP_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkGraphicsShaderGroupCreateInfoNV clone(Arena arena, VkGraphicsShaderGroupCreateInfoNV src) {
        VkGraphicsShaderGroupCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.GRAPHICS_SHADER_GROUP_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkGraphicsShaderGroupCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkGraphicsShaderGroupCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkGraphicsShaderGroupCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int stageCount() {
        return segment.get(LAYOUT$stageCount, OFFSET$stageCount);
    }

    public VkGraphicsShaderGroupCreateInfoNV stageCount(@Unsigned int value) {
        segment.set(LAYOUT$stageCount, OFFSET$stageCount, value);
        return this;
    }

    public VkGraphicsShaderGroupCreateInfoNV pStages(@Nullable IVkPipelineShaderStageCreateInfo value) {
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

    public VkGraphicsShaderGroupCreateInfoNV pVertexInputState(@Nullable IVkPipelineVertexInputStateCreateInfo value) {
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

    public VkGraphicsShaderGroupCreateInfoNV pTessellationState(@Nullable IVkPipelineTessellationStateCreateInfo value) {
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

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("stageCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineShaderStageCreateInfo.LAYOUT).withName("pStages"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineVertexInputStateCreateInfo.LAYOUT).withName("pVertexInputState"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineTessellationStateCreateInfo.LAYOUT).withName("pTessellationState")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$stageCount = PathElement.groupElement("stageCount");
    public static final PathElement PATH$pStages = PathElement.groupElement("pStages");
    public static final PathElement PATH$pVertexInputState = PathElement.groupElement("pVertexInputState");
    public static final PathElement PATH$pTessellationState = PathElement.groupElement("pTessellationState");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$stageCount = (OfInt) LAYOUT.select(PATH$stageCount);
    public static final AddressLayout LAYOUT$pStages = (AddressLayout) LAYOUT.select(PATH$pStages);
    public static final AddressLayout LAYOUT$pVertexInputState = (AddressLayout) LAYOUT.select(PATH$pVertexInputState);
    public static final AddressLayout LAYOUT$pTessellationState = (AddressLayout) LAYOUT.select(PATH$pTessellationState);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$stageCount = LAYOUT$stageCount.byteSize();
    public static final long SIZE$pStages = LAYOUT$pStages.byteSize();
    public static final long SIZE$pVertexInputState = LAYOUT$pVertexInputState.byteSize();
    public static final long SIZE$pTessellationState = LAYOUT$pTessellationState.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$stageCount = LAYOUT.byteOffset(PATH$stageCount);
    public static final long OFFSET$pStages = LAYOUT.byteOffset(PATH$pStages);
    public static final long OFFSET$pVertexInputState = LAYOUT.byteOffset(PATH$pVertexInputState);
    public static final long OFFSET$pTessellationState = LAYOUT.byteOffset(PATH$pTessellationState);
}
