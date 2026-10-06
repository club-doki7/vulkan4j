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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGraphicsPipelineShaderGroupsCreateInfoNV.html"><code>VkGraphicsPipelineShaderGroupsCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGraphicsPipelineShaderGroupsCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t groupCount; // optional // @link substring="groupCount" target="#groupCount"
///     VkGraphicsShaderGroupCreateInfoNV const* pGroups; // optional // @link substring="VkGraphicsShaderGroupCreateInfoNV" target="VkGraphicsShaderGroupCreateInfoNV" @link substring="pGroups" target="#pGroups"
///     uint32_t pipelineCount; // optional // @link substring="pipelineCount" target="#pipelineCount"
///     VkPipeline const* pPipelines; // optional // @link substring="VkPipeline" target="VkPipeline" @link substring="pPipelines" target="#pPipelines"
/// } VkGraphicsPipelineShaderGroupsCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_SHADER_GROUPS_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkGraphicsPipelineShaderGroupsCreateInfoNV#allocate(Arena)}, {@link VkGraphicsPipelineShaderGroupsCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkGraphicsPipelineShaderGroupsCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGraphicsPipelineShaderGroupsCreateInfoNV.html"><code>VkGraphicsPipelineShaderGroupsCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGraphicsPipelineShaderGroupsCreateInfoNV(@NotNull MemorySegment segment) implements IVkGraphicsPipelineShaderGroupsCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGraphicsPipelineShaderGroupsCreateInfoNV.html"><code>VkGraphicsPipelineShaderGroupsCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGraphicsPipelineShaderGroupsCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGraphicsPipelineShaderGroupsCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGraphicsPipelineShaderGroupsCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGraphicsPipelineShaderGroupsCreateInfoNV, Iterable<VkGraphicsPipelineShaderGroupsCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGraphicsPipelineShaderGroupsCreateInfoNV at(long index) {
            return new VkGraphicsPipelineShaderGroupsCreateInfoNV(segment.asSlice(index * VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES, VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES));
        }

        public VkGraphicsPipelineShaderGroupsCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkGraphicsPipelineShaderGroupsCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGraphicsPipelineShaderGroupsCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES, VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES,
                (end - start) * VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES));
        }

        public VkGraphicsPipelineShaderGroupsCreateInfoNV[] toArray() {
            VkGraphicsPipelineShaderGroupsCreateInfoNV[] ret = new VkGraphicsPipelineShaderGroupsCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGraphicsPipelineShaderGroupsCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGraphicsPipelineShaderGroupsCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES;
            }

            @Override
            public VkGraphicsPipelineShaderGroupsCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGraphicsPipelineShaderGroupsCreateInfoNV ret = new VkGraphicsPipelineShaderGroupsCreateInfoNV(segment.asSlice(0, VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES));
                segment = segment.asSlice(VkGraphicsPipelineShaderGroupsCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGraphicsPipelineShaderGroupsCreateInfoNV allocate(Arena arena) {
        VkGraphicsPipelineShaderGroupsCreateInfoNV ret = new VkGraphicsPipelineShaderGroupsCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.GRAPHICS_PIPELINE_SHADER_GROUPS_CREATE_INFO_NV);
        return ret;
    }

    public static VkGraphicsPipelineShaderGroupsCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkGraphicsPipelineShaderGroupsCreateInfoNV.Ptr ret = new VkGraphicsPipelineShaderGroupsCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.GRAPHICS_PIPELINE_SHADER_GROUPS_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkGraphicsPipelineShaderGroupsCreateInfoNV clone(Arena arena, VkGraphicsPipelineShaderGroupsCreateInfoNV src) {
        VkGraphicsPipelineShaderGroupsCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.GRAPHICS_PIPELINE_SHADER_GROUPS_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkGraphicsPipelineShaderGroupsCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkGraphicsPipelineShaderGroupsCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkGraphicsPipelineShaderGroupsCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int groupCount() {
        return segment.get(LAYOUT$groupCount, OFFSET$groupCount);
    }

    public VkGraphicsPipelineShaderGroupsCreateInfoNV groupCount(@Unsigned int value) {
        segment.set(LAYOUT$groupCount, OFFSET$groupCount, value);
        return this;
    }

    public VkGraphicsPipelineShaderGroupsCreateInfoNV pGroups(@Nullable IVkGraphicsShaderGroupCreateInfoNV value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pGroupsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkGraphicsShaderGroupCreateInfoNV.Ptr pGroups(int assumedCount) {
        MemorySegment s = pGroupsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkGraphicsShaderGroupCreateInfoNV.BYTES);
        return new VkGraphicsShaderGroupCreateInfoNV.Ptr(s);
    }

    public @Nullable VkGraphicsShaderGroupCreateInfoNV pGroups() {
        MemorySegment s = pGroupsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkGraphicsShaderGroupCreateInfoNV(s);
    }

    public @Pointer(target=VkGraphicsShaderGroupCreateInfoNV.class) @NotNull MemorySegment pGroupsRaw() {
        return segment.get(LAYOUT$pGroups, OFFSET$pGroups);
    }

    public void pGroupsRaw(@Pointer(target=VkGraphicsShaderGroupCreateInfoNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pGroups, OFFSET$pGroups, value);
    }

    public @Unsigned int pipelineCount() {
        return segment.get(LAYOUT$pipelineCount, OFFSET$pipelineCount);
    }

    public VkGraphicsPipelineShaderGroupsCreateInfoNV pipelineCount(@Unsigned int value) {
        segment.set(LAYOUT$pipelineCount, OFFSET$pipelineCount, value);
        return this;
    }

    /// Note: the returned {@link VkPipeline.Ptr} does not have correct {@link VkPipeline.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkPipeline.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkPipeline.Ptr pPipelines() {
        MemorySegment s = pPipelinesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipeline.Ptr(s);
    }

    public VkGraphicsPipelineShaderGroupsCreateInfoNV pPipelines(@Nullable VkPipeline.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPipelinesRaw(s);
        return this;
    }

    public @Pointer(target=VkPipeline.class) @NotNull MemorySegment pPipelinesRaw() {
        return segment.get(LAYOUT$pPipelines, OFFSET$pPipelines);
    }

    public void pPipelinesRaw(@Pointer(target=VkPipeline.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPipelines, OFFSET$pPipelines, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("groupCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkGraphicsShaderGroupCreateInfoNV.LAYOUT).withName("pGroups"),
        ValueLayout.JAVA_INT.withName("pipelineCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pPipelines")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$groupCount = PathElement.groupElement("groupCount");
    public static final PathElement PATH$pGroups = PathElement.groupElement("pGroups");
    public static final PathElement PATH$pipelineCount = PathElement.groupElement("pipelineCount");
    public static final PathElement PATH$pPipelines = PathElement.groupElement("pPipelines");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$groupCount = (OfInt) LAYOUT.select(PATH$groupCount);
    public static final AddressLayout LAYOUT$pGroups = (AddressLayout) LAYOUT.select(PATH$pGroups);
    public static final OfInt LAYOUT$pipelineCount = (OfInt) LAYOUT.select(PATH$pipelineCount);
    public static final AddressLayout LAYOUT$pPipelines = (AddressLayout) LAYOUT.select(PATH$pPipelines);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$groupCount = LAYOUT$groupCount.byteSize();
    public static final long SIZE$pGroups = LAYOUT$pGroups.byteSize();
    public static final long SIZE$pipelineCount = LAYOUT$pipelineCount.byteSize();
    public static final long SIZE$pPipelines = LAYOUT$pPipelines.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$groupCount = LAYOUT.byteOffset(PATH$groupCount);
    public static final long OFFSET$pGroups = LAYOUT.byteOffset(PATH$pGroups);
    public static final long OFFSET$pipelineCount = LAYOUT.byteOffset(PATH$pipelineCount);
    public static final long OFFSET$pPipelines = LAYOUT.byteOffset(PATH$pPipelines);
}
