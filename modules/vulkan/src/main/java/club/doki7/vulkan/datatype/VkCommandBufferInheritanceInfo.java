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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCommandBufferInheritanceInfo.html"><code>VkCommandBufferInheritanceInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCommandBufferInheritanceInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkRenderPass renderPass; // optional // @link substring="VkRenderPass" target="VkRenderPass" @link substring="renderPass" target="#renderPass"
///     uint32_t subpass; // @link substring="subpass" target="#subpass"
///     VkFramebuffer framebuffer; // optional // @link substring="VkFramebuffer" target="VkFramebuffer" @link substring="framebuffer" target="#framebuffer"
///     VkBool32 occlusionQueryEnable; // @link substring="occlusionQueryEnable" target="#occlusionQueryEnable"
///     VkQueryControlFlags queryFlags; // optional // @link substring="VkQueryControlFlags" target="VkQueryControlFlags" @link substring="queryFlags" target="#queryFlags"
///     VkQueryPipelineStatisticFlags pipelineStatistics; // optional // @link substring="VkQueryPipelineStatisticFlags" target="VkQueryPipelineStatisticFlags" @link substring="pipelineStatistics" target="#pipelineStatistics"
/// } VkCommandBufferInheritanceInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_COMMAND_BUFFER_INHERITANCE_INFO`
///
/// The {@code allocate} ({@link VkCommandBufferInheritanceInfo#allocate(Arena)}, {@link VkCommandBufferInheritanceInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCommandBufferInheritanceInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCommandBufferInheritanceInfo.html"><code>VkCommandBufferInheritanceInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCommandBufferInheritanceInfo(@NotNull MemorySegment segment) implements IVkCommandBufferInheritanceInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCommandBufferInheritanceInfo.html"><code>VkCommandBufferInheritanceInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCommandBufferInheritanceInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCommandBufferInheritanceInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCommandBufferInheritanceInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCommandBufferInheritanceInfo, Iterable<VkCommandBufferInheritanceInfo> {
        public long size() {
            return segment.byteSize() / VkCommandBufferInheritanceInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCommandBufferInheritanceInfo at(long index) {
            return new VkCommandBufferInheritanceInfo(segment.asSlice(index * VkCommandBufferInheritanceInfo.BYTES, VkCommandBufferInheritanceInfo.BYTES));
        }

        public VkCommandBufferInheritanceInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkCommandBufferInheritanceInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCommandBufferInheritanceInfo value) {
            MemorySegment s = segment.asSlice(index * VkCommandBufferInheritanceInfo.BYTES, VkCommandBufferInheritanceInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCommandBufferInheritanceInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCommandBufferInheritanceInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCommandBufferInheritanceInfo.BYTES,
                (end - start) * VkCommandBufferInheritanceInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCommandBufferInheritanceInfo.BYTES));
        }

        public VkCommandBufferInheritanceInfo[] toArray() {
            VkCommandBufferInheritanceInfo[] ret = new VkCommandBufferInheritanceInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCommandBufferInheritanceInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCommandBufferInheritanceInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCommandBufferInheritanceInfo.BYTES;
            }

            @Override
            public VkCommandBufferInheritanceInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCommandBufferInheritanceInfo ret = new VkCommandBufferInheritanceInfo(segment.asSlice(0, VkCommandBufferInheritanceInfo.BYTES));
                segment = segment.asSlice(VkCommandBufferInheritanceInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCommandBufferInheritanceInfo allocate(Arena arena) {
        VkCommandBufferInheritanceInfo ret = new VkCommandBufferInheritanceInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.COMMAND_BUFFER_INHERITANCE_INFO);
        return ret;
    }

    public static VkCommandBufferInheritanceInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCommandBufferInheritanceInfo.Ptr ret = new VkCommandBufferInheritanceInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.COMMAND_BUFFER_INHERITANCE_INFO);
        }
        return ret;
    }

    public static VkCommandBufferInheritanceInfo clone(Arena arena, VkCommandBufferInheritanceInfo src) {
        VkCommandBufferInheritanceInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.COMMAND_BUFFER_INHERITANCE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCommandBufferInheritanceInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCommandBufferInheritanceInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCommandBufferInheritanceInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkRenderPass renderPass() {
        MemorySegment s = segment.asSlice(OFFSET$renderPass, SIZE$renderPass);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRenderPass(s);
    }

    public VkCommandBufferInheritanceInfo renderPass(@Nullable VkRenderPass value) {
        segment.set(LAYOUT$renderPass, OFFSET$renderPass, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int subpass() {
        return segment.get(LAYOUT$subpass, OFFSET$subpass);
    }

    public VkCommandBufferInheritanceInfo subpass(@Unsigned int value) {
        segment.set(LAYOUT$subpass, OFFSET$subpass, value);
        return this;
    }

    public @Nullable VkFramebuffer framebuffer() {
        MemorySegment s = segment.asSlice(OFFSET$framebuffer, SIZE$framebuffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkFramebuffer(s);
    }

    public VkCommandBufferInheritanceInfo framebuffer(@Nullable VkFramebuffer value) {
        segment.set(LAYOUT$framebuffer, OFFSET$framebuffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int occlusionQueryEnable() {
        return segment.get(LAYOUT$occlusionQueryEnable, OFFSET$occlusionQueryEnable);
    }

    public VkCommandBufferInheritanceInfo occlusionQueryEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$occlusionQueryEnable, OFFSET$occlusionQueryEnable, value);
        return this;
    }

    public @Bitmask(VkQueryControlFlags.class) int queryFlags() {
        return segment.get(LAYOUT$queryFlags, OFFSET$queryFlags);
    }

    public VkCommandBufferInheritanceInfo queryFlags(@Bitmask(VkQueryControlFlags.class) int value) {
        segment.set(LAYOUT$queryFlags, OFFSET$queryFlags, value);
        return this;
    }

    public @Bitmask(VkQueryPipelineStatisticFlags.class) int pipelineStatistics() {
        return segment.get(LAYOUT$pipelineStatistics, OFFSET$pipelineStatistics);
    }

    public VkCommandBufferInheritanceInfo pipelineStatistics(@Bitmask(VkQueryPipelineStatisticFlags.class) int value) {
        segment.set(LAYOUT$pipelineStatistics, OFFSET$pipelineStatistics, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("renderPass"),
        ValueLayout.JAVA_INT.withName("subpass"),
        ValueLayout.ADDRESS.withName("framebuffer"),
        ValueLayout.JAVA_INT.withName("occlusionQueryEnable"),
        ValueLayout.JAVA_INT.withName("queryFlags"),
        ValueLayout.JAVA_INT.withName("pipelineStatistics")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$renderPass = PathElement.groupElement("renderPass");
    public static final PathElement PATH$subpass = PathElement.groupElement("subpass");
    public static final PathElement PATH$framebuffer = PathElement.groupElement("framebuffer");
    public static final PathElement PATH$occlusionQueryEnable = PathElement.groupElement("occlusionQueryEnable");
    public static final PathElement PATH$queryFlags = PathElement.groupElement("queryFlags");
    public static final PathElement PATH$pipelineStatistics = PathElement.groupElement("pipelineStatistics");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$renderPass = (AddressLayout) LAYOUT.select(PATH$renderPass);
    public static final OfInt LAYOUT$subpass = (OfInt) LAYOUT.select(PATH$subpass);
    public static final AddressLayout LAYOUT$framebuffer = (AddressLayout) LAYOUT.select(PATH$framebuffer);
    public static final OfInt LAYOUT$occlusionQueryEnable = (OfInt) LAYOUT.select(PATH$occlusionQueryEnable);
    public static final OfInt LAYOUT$queryFlags = (OfInt) LAYOUT.select(PATH$queryFlags);
    public static final OfInt LAYOUT$pipelineStatistics = (OfInt) LAYOUT.select(PATH$pipelineStatistics);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$renderPass = LAYOUT$renderPass.byteSize();
    public static final long SIZE$subpass = LAYOUT$subpass.byteSize();
    public static final long SIZE$framebuffer = LAYOUT$framebuffer.byteSize();
    public static final long SIZE$occlusionQueryEnable = LAYOUT$occlusionQueryEnable.byteSize();
    public static final long SIZE$queryFlags = LAYOUT$queryFlags.byteSize();
    public static final long SIZE$pipelineStatistics = LAYOUT$pipelineStatistics.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$renderPass = LAYOUT.byteOffset(PATH$renderPass);
    public static final long OFFSET$subpass = LAYOUT.byteOffset(PATH$subpass);
    public static final long OFFSET$framebuffer = LAYOUT.byteOffset(PATH$framebuffer);
    public static final long OFFSET$occlusionQueryEnable = LAYOUT.byteOffset(PATH$occlusionQueryEnable);
    public static final long OFFSET$queryFlags = LAYOUT.byteOffset(PATH$queryFlags);
    public static final long OFFSET$pipelineStatistics = LAYOUT.byteOffset(PATH$pipelineStatistics);
}
